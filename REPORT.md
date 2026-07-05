# Flask Compiler Report

## Overview

This project is a Java/ANTLR compiler that parses a Flask-oriented Python DSL and generates a runnable Flask/Jinja2/CSS web application.

## Compiler Stages

1. Lexical analysis: `FlaskLexer.g4`
2. Syntax analysis: `FlaskParser.g4`
3. AST construction: `classes`, `python_ast`, `jinja_ast`
4. Symbol table construction: `symbol_table`
5. Semantic analysis: `semantic_check`
6. Code generation: `code_generation`

## AST Structure

The base AST node is `classes.ASTNode`. It stores:

- `nodeType`
- `line`
- `column`
- `children`

It also supports:

- `addChild(ASTNode child)`
- `print()`
- getters for the node metadata

## Python AST

Package: `python_ast`

- `PythonProgramNode`: root for parsed Python/Flask code.
- `RouteNode`: Flask route and function metadata.
- `AssignmentNode`: route-local variable assignments.
- `ListNode`: global list data such as `products_data`.
- `DictNode`: dictionary object representation.
- `ReturnNode`: route return statement.
- `RenderTemplateNode`: template rendering and context variables.

## Jinja2 AST

Package: `jinja_ast`

- `TemplateNode`: root node for one template.
- `HtmlElementNode`: HTML tag usage.
- `JinjaVariableNode`: `{{ variable }}` and `{{ object.property }}`.
- `JinjaForNode`: `{% for item in source %}`.
- `JinjaIfNode`: `{% if condition %}`.
- `JinjaExpressionNode`: full template expression text.

## Symbol Table

`symbol_table.Row` stores:

- `type`
- `value`
- `line`
- `column`
- `scope`
- `origin` (`PYTHON` or `JINJA`)
- `dataType`
- `usedInTemplate`
- `passedToTemplate`

## Semantic Checks

Implemented checks:

- `UndefinedJinjaVariableCheck`
- `ForLoopSourceCheck`
- `RouteUniquenessCheck`
- `ProductRequiredFieldsCheck`
- `InvalidPropertyAccessCheck`
- `EmptyDataListCheck`
- `ComponentRequirementsCheck`

## Code Generation

The generator writes a runnable Flask app under `generated_components/`.

Generated product routes include:

- `/products`
- `/product/add`
- `/product/<int:id>`
- `/product/delete/<int:id>`

## Testing

Run:

```bat
build.bat
```

Then verify generated Python syntax:

```bat
python -m py_compile generated_components\app.py
```

Run semantic error sample:

```bat
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_errors.txt
```
