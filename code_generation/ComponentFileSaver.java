package code_generation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ComponentFileSaver {

    public static void saveComponents(List<GeneratedComponent> components, String outputDir) {
        saveComponents(components, outputDir, null);
    }

    public static void saveComponents(List<GeneratedComponent> components, String outputDir,
            List<String> globalDeclarations) {
        try {
            // Clean the output directory before saving
            File dir = new File(outputDir);
            if (dir.exists()) {
                deleteRecursive(dir);
            }

            // Create directory structure
            Files.createDirectories(Paths.get(outputDir));
            Files.createDirectories(Paths.get(outputDir + "/templates"));
            Files.createDirectories(Paths.get(outputDir + "/static"));

            // 1) Generate unified app.py with all routes
            StringBuilder appPy = new StringBuilder();
            appPy.append("from flask import Flask, render_template, request, redirect, url_for\n\n");
            appPy.append("app = Flask(__name__)\n\n");

            // Emit global variable declarations (e.g. products_data = [...])
            if (globalDeclarations != null && !globalDeclarations.isEmpty()) {
                for (String decl : globalDeclarations) {
                    appPy.append(decl).append("\n\n");
                }
            }

            for (GeneratedComponent component : components) {
                if (component.getPy() != null && !component.getPy().trim().isEmpty()) {
                    appPy.append(component.getPy()).append("\n");
                }
            }

            appPy.append("\nif __name__ == '__main__':\n");
            appPy.append("    app.run(debug=True)\n");

            saveToFile(outputDir + "/app.py", appPy.toString());

            // 2) Generate base.html layout template
            saveToFile(outputDir + "/templates/base.html", generateBaseTemplate());

            // 3) Save HTML templates into templates/ folder
            for (GeneratedComponent component : components) {
                String name = component.getComponentName();
                if (component.getHtml() != null && !component.getHtml().trim().isEmpty()) {
                    saveToFile(outputDir + "/templates/" + name + ".html", component.getHtml());
                }
            }

            // 4) Generate professional CSS
            StringBuilder allCss = new StringBuilder();
            allCss.append(generateBaseCss());
            for (GeneratedComponent component : components) {
                if (component.getCss() != null && !component.getCss().trim().isEmpty()) {
                    allCss.append("\n/* === ").append(component.getComponentName()).append(" Styles === */\n");
                    allCss.append(component.getCss()).append("\n");
                }
            }
            saveToFile(outputDir + "/static/style.css", allCss.toString());

            System.out.println("\nSaved " + components.size() + " component(s) to: " + outputDir);
            System.out.println("  - " + outputDir + "/app.py");
            System.out.println("  - " + outputDir + "/templates/base.html");
            System.out.println("  - " + outputDir + "/templates/ (" + components.size() + " pages)");
            System.out.println("  - " + outputDir + "/static/style.css");

        } catch (IOException e) {
            System.err.println("Error creating output directory: " + e.getMessage());
        }
    }

    private static String generateBaseTemplate() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>{% block title %}Flask App{% endblock %}</title>
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
                    <link rel="stylesheet" href="{{ url_for('static', filename='style.css') }}">
                </head>
                <body>
                    <nav class="topbar">
                        <div class="nav-container">
                            <a href="/" class="logo">
                                <span class="logo-icon">&#9670;</span>
                                <span class="logo-text">FlaskStore</span>
                            </a>
                            <div class="nav-links">
                                <a href="/products" class="nav-link">
                                    <span class="nav-icon">&#9776;</span> All Products
                                </a>
                                <a href="/product/add" class="nav-link nav-link-accent">
                                    <span class="nav-icon">&#43;</span> Add Product
                                </a>
                            </div>
                        </div>
                    </nav>
                    <main class="main-content">
                        {% block content %}{% endblock %}
                    </main>
                    <footer class="footer">
                        <p>&copy; 2026 FlaskStore &mdash; Generated by Flask Compiler</p>
                    </footer>
                </body>
                </html>
                """;
    }

    private static String generateBaseCss() {
        return """
                /* ================================================================
                   FlaskStore - Professional Design System
                   Generated by Flask Compiler
                   ================================================================ */

                /* === Reset & Base === */
                *, *::before, *::after {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                }

                :root {
                    --primary: #6366f1;
                    --primary-dark: #4f46e5;
                    --primary-light: #818cf8;
                    --accent: #f59e0b;
                    --danger: #ef4444;
                    --success: #10b981;
                    --dark: #1e1b4b;
                    --dark-secondary: #312e81;
                    --light: #f8fafc;
                    --gray-50: #f8fafc;
                    --gray-100: #f1f5f9;
                    --gray-200: #e2e8f0;
                    --gray-300: #cbd5e1;
                    --gray-400: #94a3b8;
                    --gray-500: #64748b;
                    --gray-700: #334155;
                    --gray-900: #0f172a;
                    --shadow-sm: 0 1px 2px rgba(0, 0, 0, 0.05);
                    --shadow-md: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -2px rgba(0, 0, 0, 0.1);
                    --shadow-lg: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -4px rgba(0, 0, 0, 0.1);
                    --shadow-xl: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 8px 10px -6px rgba(0, 0, 0, 0.1);
                    --radius-sm: 8px;
                    --radius-md: 12px;
                    --radius-lg: 16px;
                    --radius-xl: 24px;
                    --transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
                }

                body {
                    font-family: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif;
                    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                    min-height: 100vh;
                    color: var(--gray-900);
                    line-height: 1.6;
                }

                /* === Navigation Bar === */
                .topbar {
                    background: rgba(30, 27, 75, 0.95);
                    backdrop-filter: blur(20px);
                    -webkit-backdrop-filter: blur(20px);
                    border-bottom: 1px solid rgba(255, 255, 255, 0.1);
                    padding: 0 24px;
                    position: sticky;
                    top: 0;
                    z-index: 1000;
                    box-shadow: 0 4px 30px rgba(0, 0, 0, 0.3);
                }

                .nav-container {
                    max-width: 1200px;
                    margin: 0 auto;
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    height: 70px;
                }

                .logo {
                    display: flex;
                    align-items: center;
                    gap: 10px;
                    text-decoration: none;
                    transition: var(--transition);
                }

                .logo:hover {
                    transform: scale(1.05);
                }

                .logo-icon {
                    font-size: 28px;
                    color: var(--primary-light);
                    filter: drop-shadow(0 0 10px rgba(129, 140, 248, 0.5));
                }

                .logo-text {
                    font-size: 22px;
                    font-weight: 700;
                    background: linear-gradient(135deg, #818cf8, #c084fc);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                    background-clip: text;
                    letter-spacing: -0.5px;
                }

                .nav-links {
                    display: flex;
                    gap: 8px;
                    align-items: center;
                }

                .nav-link {
                    color: rgba(255, 255, 255, 0.8);
                    text-decoration: none;
                    padding: 10px 18px;
                    border-radius: var(--radius-sm);
                    font-weight: 500;
                    font-size: 14px;
                    transition: var(--transition);
                    display: flex;
                    align-items: center;
                    gap: 6px;
                }

                .nav-link:hover {
                    color: white;
                    background: rgba(255, 255, 255, 0.1);
                    transform: translateY(-1px);
                }

                .nav-link-accent {
                    background: linear-gradient(135deg, var(--primary), var(--primary-dark));
                    color: white !important;
                    box-shadow: 0 4px 15px rgba(99, 102, 241, 0.4);
                }

                .nav-link-accent:hover {
                    background: linear-gradient(135deg, var(--primary-light), var(--primary));
                    box-shadow: 0 6px 20px rgba(99, 102, 241, 0.6);
                    transform: translateY(-2px);
                }

                .nav-icon {
                    font-size: 16px;
                }

                /* === Main Content === */
                .main-content {
                    max-width: 1200px;
                    margin: 32px auto;
                    padding: 0 24px;
                    min-height: calc(100vh - 180px);
                    animation: fadeIn 0.5s ease-out;
                }

                @keyframes fadeIn {
                    from { opacity: 0; transform: translateY(20px); }
                    to { opacity: 1; transform: translateY(0); }
                }

                /* === Cards === */
                .card {
                    background: rgba(255, 255, 255, 0.95);
                    backdrop-filter: blur(10px);
                    border: 1px solid rgba(255, 255, 255, 0.2);
                    border-radius: var(--radius-lg);
                    padding: 28px;
                    box-shadow: var(--shadow-lg);
                    transition: var(--transition);
                }

                .card:hover {
                    transform: translateY(-4px);
                    box-shadow: var(--shadow-xl);
                }

                /* === Grid Layout === */
                .grid {
                    display: grid;
                    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
                    gap: 24px;
                }

                /* === Product Image === */
                .product-image {
                    width: 100%;
                    height: 200px;
                    object-fit: cover;
                    border-radius: var(--radius-md);
                    margin-bottom: 16px;
                    background: linear-gradient(135deg, var(--gray-100), var(--gray-200));
                }

                /* === Typography === */
                h1, h2, h3 {
                    color: var(--dark);
                    letter-spacing: -0.5px;
                }

                h1 {
                    font-size: 32px;
                    font-weight: 700;
                    margin-bottom: 8px;
                }

                h2 {
                    font-size: 26px;
                    font-weight: 600;
                    margin-bottom: 16px;
                    color: white;
                    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                }

                h3 {
                    font-size: 18px;
                    font-weight: 600;
                    margin-bottom: 8px;
                }

                /* === Price === */
                .price {
                    font-size: 20px;
                    font-weight: 700;
                    background: linear-gradient(135deg, var(--primary), #8b5cf6);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                    background-clip: text;
                    margin: 8px 0;
                }

                /* === Buttons === */
                .btn {
                    display: inline-flex;
                    align-items: center;
                    justify-content: center;
                    gap: 8px;
                    padding: 12px 24px;
                    font-size: 14px;
                    font-weight: 600;
                    font-family: inherit;
                    border: none;
                    border-radius: var(--radius-sm);
                    cursor: pointer;
                    transition: var(--transition);
                    text-decoration: none;
                    background: linear-gradient(135deg, var(--primary), var(--primary-dark));
                    color: white;
                    box-shadow: 0 4px 15px rgba(99, 102, 241, 0.3);
                }

                .btn:hover {
                    transform: translateY(-2px);
                    box-shadow: 0 8px 25px rgba(99, 102, 241, 0.5);
                }

                .btn:active {
                    transform: translateY(0);
                }

                .btn-danger {
                    background: linear-gradient(135deg, var(--danger), #dc2626);
                    box-shadow: 0 4px 15px rgba(239, 68, 68, 0.3);
                }

                .btn-danger:hover {
                    box-shadow: 0 8px 25px rgba(239, 68, 68, 0.5);
                }

                /* === Forms === */
                form {
                    background: rgba(255, 255, 255, 0.95);
                    backdrop-filter: blur(10px);
                    border-radius: var(--radius-lg);
                    padding: 32px;
                    box-shadow: var(--shadow-lg);
                    max-width: 600px;
                    margin: 0 auto;
                }

                input, textarea, select {
                    width: 100%;
                    padding: 14px 18px;
                    border: 2px solid var(--gray-200);
                    border-radius: var(--radius-sm);
                    font-size: 15px;
                    font-family: inherit;
                    transition: var(--transition);
                    background: var(--gray-50);
                    margin-bottom: 16px;
                    color: var(--gray-900);
                }

                input:focus, textarea:focus, select:focus {
                    outline: none;
                    border-color: var(--primary);
                    box-shadow: 0 0 0 4px rgba(99, 102, 241, 0.15);
                    background: white;
                }

                input::placeholder, textarea::placeholder {
                    color: var(--gray-400);
                }

                textarea {
                    min-height: 120px;
                    resize: vertical;
                }

                /* === Section Styling === */
                section {
                    padding: 20px 0;
                }

                /* === Links in cards === */
                .card a {
                    color: var(--primary);
                    text-decoration: none;
                    font-weight: 500;
                    transition: var(--transition);
                }

                .card a:hover {
                    color: var(--primary-dark);
                    text-decoration: underline;
                }

                /* === Footer === */
                .footer {
                    text-align: center;
                    padding: 24px;
                    color: rgba(255, 255, 255, 0.6);
                    font-size: 13px;
                    margin-top: 40px;
                }

                /* === Responsive === */
                @media (max-width: 768px) {
                    .nav-container {
                        flex-direction: column;
                        height: auto;
                        padding: 16px 0;
                        gap: 12px;
                    }

                    .grid {
                        grid-template-columns: 1fr;
                    }

                    .main-content {
                        padding: 0 16px;
                        margin: 20px auto;
                    }

                    form {
                        padding: 24px;
                    }
                }

                """;
    }

    private static void saveToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(content);
            System.out.println("Saved: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving file " + filePath + ": " + e.getMessage());
        }
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
