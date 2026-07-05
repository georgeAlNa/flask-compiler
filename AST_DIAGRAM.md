# AST Diagram

```text
Application
  PythonProgramNode
    ListNode(products_data)
    RouteNode(/)
      AssignmentNode(allLabel)
      AssignmentNode(addLabel)
      ReturnNode
        RenderTemplateNode
      TemplateNode
        HtmlElementNode(nav)
        HtmlElementNode(h1)
        JinjaVariableNode(allLabel)
        JinjaVariableNode(addLabel)
    RouteNode(/products)
      AssignmentNode(detailsLabel)
      AssignmentNode(items)
      ReturnNode
        RenderTemplateNode
      TemplateNode
        HtmlElementNode(div)
        JinjaForNode(p in items)
        JinjaVariableNode(p.image)
        JinjaVariableNode(p.name)
        JinjaVariableNode(p.price)
        JinjaVariableNode(p.id)
        JinjaVariableNode(detailsLabel)
    RouteNode(/product/add)
      AssignmentNode(addTitle)
      AssignmentNode(saveLabel)
      TemplateNode
    RouteNode(/product/<int:id>)
      AssignmentNode(product)
      AssignmentNode(backLabel)
      TemplateNode
        JinjaVariableNode(product.image)
        JinjaVariableNode(product.name)
        JinjaVariableNode(product.price)
        JinjaVariableNode(product.details)
```

The actual tree is printed at runtime by `Main` through:

- `program.printPythonAst()`
- `program.printJinjaAst()`
- `program.printFullAst()`
