# AST Diagram

This diagram matches the current generated product application and the richer AST printing format.

```text
Application
  PythonProgramNode
    ListNode(name="products_data", value="products_data = [...]")

    RouteNode(route="/", function="index")
      AssignmentNode(name="allLabel", value=""All Products"")
      AssignmentNode(name="addLabel", value=""Add Product"")
      ReturnNode(expression="render_template_string(...)")
        RenderTemplateNode(template="template", args="allLabel=allLabel, addLabel=addLabel")
      TemplateNode(content="<nav ...>")
        HtmlElementNode(tag="nav")
        HtmlElementNode(tag="h1")
        HtmlElementNode(tag="a")
        JinjaVariableNode(expression="allLabel")
        JinjaVariableNode(expression="addLabel")

    RouteNode(route="/products", function="products")
      AssignmentNode(name="detailsLabel", value=""View Details"")
      AssignmentNode(name="items", value="products_data")
      ReturnNode(expression="render_template_string(...)")
        RenderTemplateNode(template="template", args="items=products_data, detailsLabel=detailsLabel")
      TemplateNode(content="<div class="grid"> ...")
        HtmlElementNode(tag="div")
        JinjaForNode(variable="p", source="items")
        JinjaVariableNode(expression="p.image")
        JinjaVariableNode(expression="p.name")
        JinjaVariableNode(expression="p.price")
        JinjaVariableNode(expression="p.id")
        JinjaVariableNode(expression="detailsLabel")

    RouteNode(route="/product/add", function="add_product", methods="GET,POST")
      AssignmentNode(name="addTitle", value=""Add New Product"")
      AssignmentNode(name="saveLabel", value=""Save Product"")
      TemplateNode(content="<section> ...")
        HtmlElementNode(tag="section")
        HtmlElementNode(tag="form")
        JinjaVariableNode(expression="addTitle")
        JinjaVariableNode(expression="saveLabel")
      ReturnNode(expression="render_template_string(...)")
        RenderTemplateNode(template="template", args="addTitle=addTitle, saveLabel=saveLabel")

    RouteNode(route="/product/<int:id>", function="product_detail")
      AssignmentNode(name="product", value="next((p for p in products_data if p["id"] == id), None)")
      AssignmentNode(name="backLabel", value=""Back to Products"")
      ReturnNode(expression="render_template_string(...)")
        RenderTemplateNode(template="template", args="product=product, backLabel=backLabel")
      TemplateNode(content="<section class="card"> ...")
        JinjaVariableNode(expression="product.image")
        JinjaVariableNode(expression="product.name")
        JinjaVariableNode(expression="product.price")
        JinjaVariableNode(expression="product.details")
        JinjaVariableNode(expression="backLabel")

    Generated Action Route
      RouteNode(route="/product/delete/<int:id>", function="delete_product", methods="POST")
      DeleteProductView
```

## Symbol Table

The symbol table is printed at runtime and includes:

- variable/type/scope/location rows
- Python rows such as `globalVariable`, `classProperty`, `routeFunction`
- Jinja rows such as `template`, `jinjaVariable`, `jinjaFor`
- binding rows of type `templateBinding`

Example binding:

```text
Python -> Jinja Bindings:
  products: items -> products_data @ 60:4
```

## Runtime Printing

`Main.printAst(...)` prints:

- `program.printPythonAst()`
- `program.printJinjaAst()`
- `program.printFullAst()`

## DeleteProductView Note

DeleteProductView is an action route. It does not generate `DeleteProduct.html` because it handles POST deletion and redirects to `/products`.
