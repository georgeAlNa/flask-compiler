package code_generation;

import classes.ComponentMetadata;
import classes.FlaskComponent;
import classes.InlineTemplate;
import classes.RouteEntry;
import classes.StylesContent;
import classes.StylesEntry;
import classes.TemplateEntry;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ViewFactory {

    public static BaseComponentView createView(FlaskComponent component) {
        ComponentMetadata metadata = component.getComponentMetadata();
        String template = extractTemplate(metadata);
        String styles = extractStyles(metadata);
        String route = extractRoute(metadata);
        String logic = extractLogic(component);
        String funcName = component.getFlaskClass() != null
                ? component.getFlaskClass().getClassName()
                : "unknown";
        String className = toClassName(funcName);
        java.util.List<String> methods = extractMethods(metadata);

        // Extract raw if-block code and pre-return code for verbatim emission
        String ifBlockCode = extractIfBlockCode(component);
        String preReturnCode = extractPreReturnCode(component);

        return new GenericView(funcName, className, template, styles, logic, route, methods,
                ifBlockCode, preReturnCode);
    }

    private static String extractTemplate(ComponentMetadata metadata) {
        return metadata.getMetadataEntries().stream()
                .filter(e -> e instanceof TemplateEntry)
                .map(e -> {
                    InlineTemplate t = ((TemplateEntry) e).getInlineTemplate();
                    if (t == null)
                        return "";
                    String raw = t.getRawContent();
                    if (raw != null) {
                        raw = raw.trim();
                        if (raw.startsWith("`"))
                            raw = raw.substring(1);
                        if (raw.endsWith("`"))
                            raw = raw.substring(0, raw.length() - 1);
                        if (raw.startsWith("\"\"\""))
                            raw = raw.substring(3);
                        if (raw.endsWith("\"\"\""))
                            raw = raw.substring(0, raw.length() - 3);
                        return raw.trim();
                    }
                    return "";
                })
                .findFirst().orElse("");
    }

    private static String extractStyles(ComponentMetadata metadata) {
        return metadata.getMetadataEntries().stream()
                .filter(e -> e instanceof StylesEntry)
                .map(e -> {
                    StylesContent sc = ((StylesEntry) e).getStylesContent();
                    if (sc == null)
                        return "";
                    String raw = sc.getRawCss();
                    if (raw != null) {
                        raw = raw.trim();
                        if (raw.startsWith("`"))
                            raw = raw.substring(1);
                        if (raw.endsWith("`"))
                            raw = raw.substring(0, raw.length() - 1);
                        return raw.trim();
                    }
                    return "";
                })
                .findFirst().orElse("");
    }

    private static String extractRoute(ComponentMetadata metadata) {
        return metadata.getMetadataEntries().stream()
                .filter(e -> e instanceof RouteEntry)
                .map(e -> ((RouteEntry) e).getRoute())
                .findFirst().orElse("/");
    }

    private static java.util.List<String> extractMethods(ComponentMetadata metadata) {
        return metadata.getMetadataEntries().stream()
                .filter(e -> e instanceof RouteEntry)
                .map(e -> ((RouteEntry) e).getMethods())
                .filter(m -> m != null && !m.isEmpty())
                .findFirst().orElse(null);
    }

    private static String extractLogic(FlaskComponent component) {
        StringBuilder logic = new StringBuilder();
        if (component.getFlaskClass() == null)
            return "";
        var classBody = component.getFlaskClass().getClassBody();
        if (classBody == null)
            return "";

        // Collect names of properties that are already covered by preReturnRawLines
        // to avoid duplicate emission
        Set<String> preReturnVarNames = new HashSet<>();
        for (String line : component.getPreReturnRawLines()) {
            int eq = line.indexOf('=');
            if (eq > 0) {
                preReturnVarNames.add(line.substring(0, eq).trim());
            }
        }

        for (var member : classBody.getClassMembers()) {
            if (member.getPropertyDeclaration() != null) {
                var prop = member.getPropertyDeclaration();
                // Skip properties that will be emitted via preReturnRawLines
                if (preReturnVarNames.contains(prop.getIdentifier())) {
                    continue;
                }
                logic.append(prop.getIdentifier())
                        .append(" = ").append(prop.getValue() != null ? prop.getValue() : "''")
                        .append("\n");
            }
        }
        return logic.toString();
    }

    /**
     * Combine all raw if-block code fragments into a single string.
     */
    private static String extractIfBlockCode(FlaskComponent component) {
        List<String> blocks = component.getIfBlockRawCode();
        if (blocks.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (String block : blocks) {
            if (!sb.isEmpty())
                sb.append("\n");
            sb.append(block);
        }
        return sb.toString();
    }

    /**
     * Combine all pre-return raw lines into a single string.
     */
    private static String extractPreReturnCode(FlaskComponent component) {
        List<String> lines = component.getPreReturnRawLines();
        if (lines.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (!sb.isEmpty())
                sb.append("\n");
            sb.append(line);
        }
        return sb.toString();
    }

    private static String toClassName(String funcName) {
        String[] parts = funcName.split("_");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty())
                sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1));
        }
        return sb.toString();
    }
}
