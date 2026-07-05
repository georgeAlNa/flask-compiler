package symbol_table;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {

    private List<Row> rows = new ArrayList<>();

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public void print() {
        System.out.println("\n==================== Symbol Table ====================");
        System.out.printf("%-18s %-24s %-10s %-10s %-12s %-7s %-7s %-10s%n",
                "Type", "Value", "Origin", "DataType", "Scope", "Used", "Passed", "Location");
        System.out.println("-----------------------------------------------------------");

        for (Row row : rows) {
            if (row != null) {
                String type     = row.getType();
                String value    = formatValue(row);
                String location = row.getLine() + ":" + row.getColumn();

                System.out.printf("%-18s %-24s %-10s %-10s %-12s %-7s %-7s %-10s%n",
                        type,
                        value.length() > 24 ? value.substring(0, 21) + "..." : value,
                        safe(row.getOrigin()),
                        safe(row.getDataType()),
                        safe(row.getScope()),
                        row.isUsedInTemplate(),
                        row.isPassedToTemplate(),
                        location);

                if ("template".equals(type) && row.getValue() != null) {
                    printTemplateContent(row.getValue());
                }
            }
        }
        printTemplateBindings();
        System.out.println("===========================================================");
    }

    private String safe(String value) {
        return value == null ? "-" : value;
    }

    private String formatValue(Row row) {
        String value = row.getValue();
        if (value == null) return "null";
        if ("template".equals(row.getType())) return "[Template]";
        return value.replace("\n", "\\n");
    }

    private void printTemplateContent(String template) {
        System.out.println("\nTemplate Content:");
        System.out.println("+------------------------------------------------------");
        String[] lines = template.split("\n");
        for (String line : lines) {
            System.out.println("| " + line);
        }
        System.out.println("+------------------------------------------------------");
    }

    private void printTemplateBindings() {
        boolean headerPrinted = false;
        for (Row row : rows) {
            if (!"templateBinding".equals(row.getType())) {
                continue;
            }
            if (!headerPrinted) {
                System.out.println("\nPython -> Jinja Bindings:");
                headerPrinted = true;
            }
            System.out.println("  " + row.getScope() + ": " + row.getValue()
                    + " -> " + row.getAdditionalData()
                    + " @ " + row.getLine() + ":" + row.getColumn());
        }
    }
}
