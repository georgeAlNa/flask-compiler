# Semantic Checks Reference

All checks are registered in `semantic_check/SemanticAnalyzer.java`.
The combined demonstration sample is `samples/sample_semantic_full.txt`, which should print `Semantic Errors (10)`.

| Check | Error Detected | Example Pattern | Sample |
| --- | --- | --- | --- |
| `UndefinedJinjaVariableCheck` | Jinja variable used without a Python/context binding | `{{ missingVar }}` | `samples/sample_semantic_full.txt` |
| `UndefinedPythonVariableCheck` | Python variable used before definition | `brokenValue = missingPythonSource` | `samples/sample_semantic_full.txt` |
| `ForLoopSourceCheck` | Jinja loop uses an undefined or non-list source | `{% for row in unknownList %}` / `{% for letter in nonList %}` | `samples/sample_semantic_full.txt` |
| `RouteUniquenessCheck` | Duplicate Flask route path | `@app.route('/broken')` declared twice | `samples/sample_semantic_full.txt` |
| `RouteFunctionUniquenessCheck` | Duplicate route function name | `def broken()` declared twice | `samples/sample_semantic_full.txt` |
| `JinjaIfConditionCheck` | Jinja `if` condition uses an undefined variable | `{% if missingFlag %}` | `samples/sample_semantic_full.txt` |
| `ProductRequiredFieldsCheck` | Product dictionary misses required fields | Product item without `name` or `price` | `samples/sample_semantic_full.txt` |
| `InvalidPropertyAccessCheck` | Template reads a property not present in the data source | `{{ p.unknownField }}` | `samples/sample_semantic_full.txt` |
| `EmptyDataListCheck` | Data list is empty or invalid for display | `products_data = []` or invalid list content | `samples/sample_semantic_full.txt` |
| `RouteTemplateRequirementsCheck` | Route view is missing required template structure | Route without a template when one is required | `samples/sample_errors.txt` or custom route-only sample |

Expected command:

```bat
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_semantic_full.txt
```

Expected result:

```text
=== Semantic Errors (10) ===
Code generation skipped because semantic errors were found.
```
