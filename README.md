# Flask Compiler (DSL -> Flask + Jinja2)

This project is a custom compiler built with Java and ANTLR4. It parses a DSL and generates a Python Flask backend plus Jinja2 HTML templates and CSS.

## Requirements

- Java 17+ (or compatible JDK)
- Python 3.10+ (to run generated Flask app)
- ANTLR4 jar is already included: `antlr4-4.13.1-complete.jar`

## Build the compiler

### Windows

```bat
build.bat
```

### Linux / macOS

```bash
./build.sh
```

This regenerates the ANTLR lexer/parser, compiles Java sources, and runs the compiler.

By default, the build scripts run `samples/sample.txt`. To run a different sample, edit the `SAMPLE` line in the build script and uncomment the desired file.

## Run the generated Flask app

The compiler writes output to `generated_components/`.

```bash
cd generated_components
python -m venv .venv
# Windows: .\.venv\Scripts\Activate.ps1
# Linux/macOS: source .venv/bin/activate
pip install flask
python app.py
```

By default, the app runs at http://127.0.0.1:5000.

## Samples

Sample DSL inputs live in `samples/`. The build scripts are pre-configured to run `samples/sample.txt`, with other samples listed and commented out.

## Project layout (high level)

- `FlaskLexer.g4`, `FlaskParser.g4`: ANTLR grammar
- `classes/`: AST nodes and visitor logic
- `semantic_check/`: semantic validations
- `code_generation/`: Flask/Jinja2 code generation
- `generated_components/`: output Flask app (created by the compiler)
