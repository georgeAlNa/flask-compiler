package code_generation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaticOutputSaver {

    private StaticOutputSaver() {
    }

    public static List<String> saveStaticOutput(List<GeneratedRouteView> routeViews, String outputDir,
            String generatedComponentsDir, List<String> globalDeclarations) {
        return saveStaticOutput(routeViews, outputDir, generatedComponentsDir, globalDeclarations, null);
    }

    public static List<String> saveStaticOutput(List<GeneratedRouteView> routeViews, String outputDir,
            String generatedComponentsDir, List<String> globalDeclarations, Path supportInputDir) {
        List<String> savedFiles = new ArrayList<>();
        try {
            File dir = new File(outputDir);
            if (dir.exists()) {
                deleteRecursive(dir);
            }
            Files.createDirectories(Path.of(outputDir));

            List<Map<String, String>> products = extractProducts(globalDeclarations);
            boolean hasEditProductView = false;
            for (GeneratedRouteView routeView : routeViews) {
                if (routeView.getHtml() == null || routeView.getHtml().isBlank()) {
                    continue;
                }

                String fileName = outputFileName(routeView.getViewName());
                if (fileName.isBlank()) {
                    continue;
                }
                if ("EditProduct".equals(routeView.getViewName())) {
                    hasEditProductView = true;
                }

                String rendered = renderPage(routeView.getViewName(), routeView.getHtml(), products);
                saveFile(outputDir, fileName, rendered);
                savedFiles.add(outputDir + "/" + fileName);
            }

            if (!hasEditProductView && !products.isEmpty()) {
                String editPreview = renderEditProductPreview(products.get(0));
                saveFile(outputDir, "edit_product.html", editPreview);
                savedFiles.add(outputDir + "/edit_product.html");
            }

            copySupportFiles(outputDir, generatedComponentsDir, supportInputDir, savedFiles);

            System.out.println("Saved static translator output to: " + outputDir);
            for (String savedFile : savedFiles) {
                System.out.println("  - " + savedFile);
            }
        } catch (IOException e) {
            System.err.println("Error saving static output: " + e.getMessage());
        }
        return savedFiles;
    }

    private static void copySupportFiles(String outputDir, String generatedComponentsDir, Path supportInputDir,
            List<String> savedFiles) throws IOException {
        boolean copiedScript = false;
        if (supportInputDir != null) {
            copyIfExists(supportInputDir.resolve("app.py"), Path.of(outputDir, "app.py"), savedFiles);
            copyIfExists(supportInputDir.resolve("style.css"), Path.of(outputDir, "style.css"), savedFiles);
            copiedScript = copyIfExists(supportInputDir.resolve("script.js"), Path.of(outputDir, "script.js"), savedFiles);
        }

        if (!Files.exists(Path.of(outputDir, "app.py"))) {
            copyIfExists(Path.of(generatedComponentsDir, "app.py"), Path.of(outputDir, "app.py"), savedFiles);
        }
        if (!Files.exists(Path.of(outputDir, "style.css"))) {
            copyIfExists(Path.of(generatedComponentsDir, "static", "style.css"), Path.of(outputDir, "style.css"),
                    savedFiles);
        }
        if (!copiedScript && !Files.exists(Path.of(outputDir, "script.js"))) {
            saveFile(outputDir, "script.js", "// Optional runtime script copied with generated output.\n");
            savedFiles.add(outputDir + "/script.js");
        }
    }

    private static String renderPage(String viewName, String template, List<Map<String, String>> products) {
        Map<String, Object> context = contextFor(viewName, products);
        String content = extractContentBlock(template);
        content = renderLoops(content, context);
        content = renderVariables(content, context);
        return wrapHtml(titleFor(viewName), content);
    }

    private static Map<String, Object> contextFor(String viewName, List<Map<String, String>> products) {
        Map<String, Object> context = new LinkedHashMap<>();
        switch (viewName) {
            case "Index" -> {
                context.put("allLabel", "All Products");
                context.put("addLabel", "Add Product");
            }
            case "Products" -> {
                context.put("detailsLabel", "View Details");
                context.put("items", products);
            }
            case "AddProduct" -> {
                context.put("addTitle", "Add New Product");
                context.put("saveLabel", "Save Product");
            }
            case "ProductDetail" -> {
                context.put("backLabel", "Back to Products");
                if (!products.isEmpty()) {
                    context.put("product", products.get(0));
                }
            }
            case "EditProduct" -> {
                context.put("editTitle", "Edit Product");
                context.put("saveLabel", "Save Changes");
                context.put("backLabel", "Back to Product");
                if (!products.isEmpty()) {
                    context.put("product", products.get(0));
                }
            }
            default -> {
            }
        }
        return context;
    }

    private static String renderLoops(String html, Map<String, Object> context) {
        Pattern loopPattern = Pattern.compile("\\{%\\s*for\\s+(\\w+)\\s+in\\s+(\\w+)\\s*%\\}([\\s\\S]*?)\\{%\\s*endfor\\s*%\\}");
        Matcher matcher = loopPattern.matcher(html);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String itemName = matcher.group(1);
            String sourceName = matcher.group(2);
            String body = matcher.group(3);
            Object source = context.get(sourceName);
            StringBuilder renderedLoop = new StringBuilder();
            if (source instanceof List<?> items) {
                for (Object item : items) {
                    Map<String, Object> nestedContext = new LinkedHashMap<>(context);
                    nestedContext.put(itemName, item);
                    renderedLoop.append(renderVariables(body, nestedContext));
                }
            }
            matcher.appendReplacement(result, Matcher.quoteReplacement(renderedLoop.toString()));
        }
        matcher.appendTail(result);
        return result.toString();
    }

    private static String renderVariables(String html, Map<String, Object> context) {
        Pattern variablePattern = Pattern.compile("\\{\\{\\s*([a-zA-Z_][a-zA-Z0-9_]*)(?:\\.([a-zA-Z_][a-zA-Z0-9_]*))?\\s*\\}\\}");
        Matcher matcher = variablePattern.matcher(html);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String name = matcher.group(1);
            String property = matcher.group(2);
            String value = resolveValue(context, name, property);
            matcher.appendReplacement(result, Matcher.quoteReplacement(escapeHtml(value)));
        }
        matcher.appendTail(result);
        return result.toString();
    }

    private static String resolveValue(Map<String, Object> context, String name, String property) {
        Object value = context.get(name);
        if (property == null) {
            return value == null ? "" : String.valueOf(value);
        }
        if (value instanceof Map<?, ?> map) {
            Object propertyValue = map.get(property);
            return propertyValue == null ? "" : String.valueOf(propertyValue);
        }
        return "";
    }

    private static List<Map<String, String>> extractProducts(List<String> globalDeclarations) {
        List<Map<String, String>> products = new ArrayList<>();
        if (globalDeclarations == null) {
            return products;
        }

        Pattern dictPattern = Pattern.compile("\\{([\\s\\S]*?)\\}");
        Pattern pairPattern = Pattern.compile("\"([^\"]+)\"\\s*:\\s*(\"([^\"]*)\"|\\d+(?:\\.\\d+)?)");
        for (String declaration : globalDeclarations) {
            if (declaration == null || !declaration.contains("products_data")) {
                continue;
            }
            Matcher dictMatcher = dictPattern.matcher(declaration);
            while (dictMatcher.find()) {
                Map<String, String> product = new LinkedHashMap<>();
                Matcher pairMatcher = pairPattern.matcher(dictMatcher.group(1));
                while (pairMatcher.find()) {
                    String value = pairMatcher.group(3) != null ? pairMatcher.group(3) : pairMatcher.group(2);
                    product.put(pairMatcher.group(1), value);
                }
                if (!product.isEmpty()) {
                    products.add(product);
                }
            }
        }
        return products;
    }

    private static String extractContentBlock(String template) {
        Matcher matcher = Pattern.compile("\\{%\\s*block\\s+content\\s*%\\}([\\s\\S]*?)\\{%\\s*endblock\\s*%\\}")
                .matcher(template);
        return matcher.find() ? matcher.group(1).trim() : template.trim();
    }

    private static String wrapHtml(String title, String content) {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>%s</title>
                    <link rel="stylesheet" href="style.css">
                </head>
                <body>
                    <main class="main-content">
                %s
                    </main>
                    <script src="script.js"></script>
                </body>
                </html>
                """.formatted(escapeHtml(title), indent(content, "        "));
    }

    private static String renderEditProductPreview(Map<String, String> product) {
        String content = """
                <section>
                    <h2>Edit Product</h2>
                    <form method="post">
                        <input name="name" value="%s" required />
                        <input type="number" name="price" value="%s" required />
                        <input name="image" value="%s" required />
                        <textarea name="description">%s</textarea>
                        <button type="submit">Save Changes</button>
                    </form>
                </section>
                """.formatted(
                escapeHtml(product.getOrDefault("name", "")),
                escapeHtml(product.getOrDefault("price", "")),
                escapeHtml(product.getOrDefault("image", "")),
                escapeHtml(product.getOrDefault("details", "")));
        return wrapHtml("Edit Product", content.trim());
    }

    private static String outputFileName(String viewName) {
        return switch (viewName) {
            case "Index" -> "index.html";
            case "Products" -> "products.html";
            case "AddProduct" -> "add_product.html";
            case "ProductDetail" -> "product_detail.html";
            case "EditProduct" -> "edit_product.html";
            default -> "";
        };
    }

    private static String titleFor(String viewName) {
        return switch (viewName) {
            case "Index" -> "Index";
            case "Products" -> "Products";
            case "AddProduct" -> "Add Product";
            case "ProductDetail" -> "Product Detail";
            case "EditProduct" -> "Edit Product";
            default -> viewName;
        };
    }

    private static boolean copyIfExists(Path source, Path target, List<String> savedFiles) throws IOException {
        if (Files.exists(source)) {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            savedFiles.add(target.toString().replace('\\', '/'));
            return true;
        }
        return false;
    }

    private static void saveFile(String outputDir, String fileName, String content) throws IOException {
        Files.writeString(Path.of(outputDir, fileName), content);
    }

    private static String indent(String value, String prefix) {
        return prefix + value.replace("\n", "\n" + prefix);
    }

    private static String escapeHtml(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteRecursive(child);
                }
            }
        }
        file.delete();
    }
}
