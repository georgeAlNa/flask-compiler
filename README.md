# Flask Compiler (DSL -> Flask + Jinja2 + HTML)

This project is a custom compiler built with Java and ANTLR4. It parses a Flask/Jinja-focused DSL, builds AST structures, runs semantic checks, and generates both a runnable Flask application and final rendered HTML output.

## Requirements

- Java 17+ or compatible JDK
- Python 3.10+
- Flask, only for running or smoke-testing the generated Flask app
- ANTLR4 jar is included: `antlr4-4.13.1-complete.jar`

## Build

On Windows:

```bat
build.bat
```

On Linux/macOS:

```bash
./build.sh
```

The default input is `official_input/`. This directory matches the course announcement structure:

- `official_input/app.py`
- `official_input/templates/*.jinja`
- `official_input/style.css`
- `official_input/script.js`

The compiler also still accepts the older single-file DSL samples under `samples/` for syntax and semantic tests. Generation stops if syntax or semantic errors are found.

## Compiler Pipeline

1. Lexical analysis: `FlaskLexer.g4` tokenizes the source.
2. Parsing: `FlaskParser.g4` builds the parse tree.
3. AST construction: `BaseVisitor` builds Python AST and Jinja AST nodes.
4. Symbol table: Python variables, routes, templates, Jinja variables, and Python-to-Jinja bindings are recorded.
5. Semantic analysis: checks in `semantic_check/` validate routes, bindings, variables, data lists, and property access.
6. Code generation: `code_generation/` generates Flask routes, Jinja templates, CSS, static HTML pages, and compiler reports.

## Generated Output

After `build.bat`, the compiler produces three important output areas.

### `generated_components/`

Runnable Flask/Jinja application:

- `generated_components/app.py`
- `generated_components/templates/Index.html`
- `generated_components/templates/Products.html`
- `generated_components/templates/AddProduct.html`
- `generated_components/templates/ProductDetail.html`
- `generated_components/templates/EditProduct.html`
- `generated_components/templates/base.html`
- `generated_components/static/style.css`

Generated Flask routes include:

- `/`
- `/products`
- `/product/add`
- `/product/<int:id>`
- `/product/edit/<int:id>`
- `/product/delete/<int:id>`

### `output/`

Final generated translator output, including static HTML pages after Jinja variable replacement:

- `output/index.html`
- `output/products.html`
- `output/add_product.html`
- `output/product_detail.html`
- `output/edit_product.html`
- `output/app.py`
- `output/style.css`
- `output/script.js`

The `output/*.html` files are rendered HTML files, not raw Jinja templates.

### `compiler_output/`

Compiler-stage artifacts required for discussion:

- `compiler_output/ast_python.json`
- `compiler_output/ast_jinja.json`
- `compiler_output/semantic_report.txt`
- `compiler_output/generation_log.txt`

## Run the Generated Flask App

```bat
cd generated_components
python app.py
```

Default URL:

```text
http://127.0.0.1:5000
```

For a clean environment:

```bat
cd generated_components
python -m venv .venv
.\.venv\Scripts\Activate.ps1
pip install flask
python app.py
```

## Final Verification

Run:

```bat
run_tests.bat
```

The test runner verifies:

- valid compiler build
- generated Flask Python syntax
- semantic error reporting
- syntax error reporting
- Flask smoke test for generated routes
- `GET /product/edit/1`
- `POST /product/edit/1` updates product data

Useful direct commands:

```bat
java -cp "out;antlr4-4.13.1-complete.jar" Main official_input
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_semantic_full.txt
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_syntax_error.txt
```


## Project Layout

- `FlaskLexer.g4`, `FlaskParser.g4`: ANTLR grammar
- `classes/`: AST nodes and visitor logic
- `python_ast/`: Python AST node classes
- `jinja_ast/`: Jinja/HTML AST node classes
- `symbol_table/`: symbol table rows and printing
- `semantic_check/`: semantic checks
- `syntax_check/`: syntax error listener
- `code_generation/`: Flask/Jinja/static HTML/code report generators
- `official_input/`: course-style input with `app.py`, `templates/`, `style.css`, and optional `script.js`
- `samples/`: legacy single-file samples and error-test inputs
- `generated_components/`: runnable Flask output
- `output/`: final generated HTML output
- `compiler_output/`: AST JSON files and reports
