package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectInputLoader {

    private static final Pattern RENDER_TEMPLATE_PATTERN = Pattern.compile(
            "render_template\\(\\s*['\"]([^'\"]+)['\"]\\s*(?:,\\s*(.*))?\\)");

    private ProjectInputLoader() {
    }

    public static String loadProjectDirectory(Path projectDir) throws IOException {
        Path appPy = projectDir.resolve("app.py");
        if (!Files.exists(appPy)) {
            throw new IOException("Missing required input file: " + appPy);
        }

        StringBuilder source = new StringBuilder();
        String[] lines = Files.readString(appPy).replace("\r\n", "\n").split("\n", -1);
        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.startsWith("from flask import")) {
                source.append("from flask import Flask, render_template_string, request, redirect\n");
                continue;
            }

            Matcher matcher = RENDER_TEMPLATE_PATTERN.matcher(line);
            if (trimmed.startsWith("return render_template(") && matcher.find()) {
                appendInlineTemplateReturn(source, projectDir, line, matcher);
                continue;
            }

            source.append(line).append("\n");
        }
        return source.toString();
    }

    private static void appendInlineTemplateReturn(StringBuilder source, Path projectDir, String line, Matcher matcher)
            throws IOException {
        String indent = line.substring(0, line.indexOf("return"));
        String templateName = matcher.group(1);
        String args = matcher.group(2);
        Path templatePath = projectDir.resolve("templates").resolve(templateName);
        if (!Files.exists(templatePath)) {
            throw new IOException("Missing Jinja template referenced by app.py: " + templatePath);
        }

        String templateContent = Files.readString(templatePath)
                .replace("\r\n", "\n")
                .replace("\"\"\"", "\\\"\\\"\\\"");

        source.append(indent).append("template = \"\"\"\n");
        source.append(templateContent);
        if (!templateContent.endsWith("\n")) {
            source.append("\n");
        }
        source.append(indent).append("\"\"\"\n\n");
        source.append(indent).append("return render_template_string(template");
        if (args != null && !args.isBlank()) {
            source.append(", ").append(args.trim());
        }
        source.append(")\n");
    }
}
