package code_generation;

import classes.Application;
import semantic_check.SemanticError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class CompilerOutputSaver {

    private CompilerOutputSaver() {
    }

    public static void save(Application program, List<SemanticError> semanticErrors,
            List<String> generationLogLines, String compilerOutputDir) {
        try {
            Path outputDir = Path.of(compilerOutputDir);
            Files.createDirectories(outputDir);

            Files.writeString(outputDir.resolve("ast_python.json"), program.pythonAstJson());
            Files.writeString(outputDir.resolve("ast_jinja.json"), program.jinjaAstJson());
            Files.writeString(outputDir.resolve("semantic_report.txt"), buildSemanticReport(semanticErrors));
            Files.writeString(outputDir.resolve("generation_log.txt"), buildGenerationLog(generationLogLines));

            System.out.println("Saved compiler artifacts to: " + compilerOutputDir);
            System.out.println("  - " + compilerOutputDir + "/ast_python.json");
            System.out.println("  - " + compilerOutputDir + "/ast_jinja.json");
            System.out.println("  - " + compilerOutputDir + "/semantic_report.txt");
            System.out.println("  - " + compilerOutputDir + "/generation_log.txt");
        } catch (IOException e) {
            System.err.println("Error saving compiler output: " + e.getMessage());
        }
    }

    private static String buildSemanticReport(List<SemanticError> semanticErrors) {
        StringBuilder report = new StringBuilder();
        report.append("Semantic Analysis Report\n");
        report.append("========================\n");
        report.append("Generated at: ").append(LocalDateTime.now()).append("\n\n");

        if (semanticErrors == null || semanticErrors.isEmpty()) {
            report.append("[OK] No semantic errors found.\n");
            return report.toString();
        }

        report.append("Semantic Errors (").append(semanticErrors.size()).append(")\n\n");
        for (int i = 0; i < semanticErrors.size(); i++) {
            SemanticError error = semanticErrors.get(i);
            report.append("Error #").append(i + 1).append("\n");
            report.append("Type: ").append(error.getType()).append("\n");
            report.append("Message: ").append(error.getMessage()).append("\n");
            report.append("Details: ").append(error.getTitle()).append("\n");
            report.append("Location: Line ").append(error.getLine())
                    .append(", Column ").append(error.getColumn()).append("\n\n");
        }
        return report.toString();
    }

    private static String buildGenerationLog(List<String> generationLogLines) {
        StringBuilder log = new StringBuilder();
        log.append("Code Generation Log\n");
        log.append("===================\n");
        log.append("Generated at: ").append(LocalDateTime.now()).append("\n\n");

        if (generationLogLines == null || generationLogLines.isEmpty()) {
            log.append("No generation entries were recorded.\n");
            return log.toString();
        }

        for (String line : generationLogLines) {
            log.append("- ").append(line).append("\n");
        }
        return log.toString();
    }
}
