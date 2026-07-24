# Final Project Report

## Project Status

The project now matches the course clarification for the code generation phase.

The compiler accepts a course-style Flask/Jinja project from `official_input/`, analyzes it, performs semantic checks, and generates:

- runnable Flask/Jinja output in `generated_components/`
- final rendered HTML output in `output/`
- compiler-stage artifacts in `compiler_output/`

Final verification passed with:

```bat
build.bat
run_tests.bat
```

The latest test run ended with:

```text
All checks finished.
```

## Official Input

The default build input is:

- `official_input/app.py`
- `official_input/templates/index.jinja`
- `official_input/templates/products.jinja`
- `official_input/templates/add_product.jinja`
- `official_input/templates/product_detail.jinja`
- `official_input/templates/edit_product.jinja`
- `official_input/style.css`
- `official_input/script.js`

`classes/ProjectInputLoader.java` loads this directory structure and converts external `render_template(...)` calls into an internal representation that the compiler can parse and analyze.

## Compiler Pipeline

The implemented pipeline is:

```text
Flask/Python input
  -> Lexer
  -> Parser
  -> Python AST
  -> Jinja AST
  -> Symbol Table
  -> Semantic Analysis
  -> Code Generation
  -> Flask/Jinja app + rendered HTML + compiler reports
```

Important implementation areas:

- Lexer grammar: `FlaskLexer.g4`
- Parser grammar: `FlaskParser.g4`
- AST nodes: `classes/`, `python_ast/`, `jinja_ast/`
- Symbol table: `symbol_table/`
- Semantic checks: `semantic_check/`
- Code generation: `code_generation/`

## Generated Flask/Jinja Application

Generated in `generated_components/`:

- `generated_components/app.py`
- `generated_components/templates/base.html`
- `generated_components/templates/Index.html`
- `generated_components/templates/Products.html`
- `generated_components/templates/AddProduct.html`
- `generated_components/templates/ProductDetail.html`
- `generated_components/templates/EditProduct.html`
- `generated_components/static/style.css`

Generated routes:

- `/`
- `/products`
- `/product/add`
- `/product/<int:id>`
- `/product/edit/<int:id>`
- `/product/delete/<int:id>`

The edit route supports both `GET` and `POST`, updates the selected product, and redirects back to the product detail page.

## Final Translator Output

Generated in `output/`:

- `output/index.html`
- `output/products.html`
- `output/add_product.html`
- `output/product_detail.html`
- `output/edit_product.html`
- `output/app.py`
- `output/style.css`
- `output/script.js`

The HTML files in `output/` are rendered HTML files. They should not contain raw Jinja expressions such as:

```text
{{ variable }}
{% for ... %}
```

## Compiler Artifacts

Generated in `compiler_output/`:

- `compiler_output/ast_python.json`
- `compiler_output/ast_jinja.json`
- `compiler_output/semantic_report.txt`
- `compiler_output/generation_log.txt`

These files are the required evidence for the analysis and generation stages.

## Semantic Analysis

Semantic checks are registered in `semantic_check/SemanticAnalyzer.java`.

Covered checks include:

- undefined Jinja variables
- undefined Python variables
- invalid Jinja loop sources
- duplicate routes
- duplicate route function names
- invalid Jinja if conditions
- missing product fields
- invalid product property access
- empty product data lists
- missing template requirements

The invalid sample `samples/sample_semantic_full.txt` reports 10 semantic errors and skips generation.

## Syntax Analysis

Syntax errors are handled by `syntax_check/SyntaxErrorListener.java`.

The invalid sample `samples/sample_syntax_error.txt` reports a syntax error with line and column information and skips later compiler stages.

## Verification

`run_tests.bat` verifies:

- valid build
- generated Flask Python syntax
- semantic error reporting
- syntax error reporting
- Flask smoke test
- edit page `GET /product/edit/1`
- edit submission `POST /product/edit/1`

Expected final output:

```text
All checks finished.
```

