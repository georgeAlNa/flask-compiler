# تقرير مقارنة المشروع مع المتطلبات الرسمية الجديدة

## خلاصة الحكم

المشروع الحالي يملك Compiler pipeline عملياً وقابلاً للعرض: Lexer وParser عبر ANTLR، بناء AST، Symbol Table، Semantic Analysis، Code Generation، وتطبيق Flask/Jinja/CSS مولد داخل `generated_components/`.

الحالة العامة: المشروع يغطي معظم المتطلبات العملية الأساسية، وأقوى نقطة فيه حالياً هي وجود 10 فحوص دلالية مثبتة بعينة `samples/sample_semantic_full.txt`. المشروع يستخدم Java وANTLR لبناء compiler، بينما الكود الناتج هو تطبيق Python Flask/Jinja2. لذلك يجب توضيح أن Java/ANTLR هي أدوات تنفيذ المترجم، وليست مخالفة لفكرة المشروع، لأن الهدف النهائي هو تحليل وتوليد تطبيق Flask/Jinja.

ملاحظة مهمة: تم تنظيف مخرجات الطباعة الأساسية لتستخدم ASCII عادي بدلاً من الرموز الزخرفية التي قد تظهر مشوهة في PowerShell.

## 1. المتطلبات المنفذة

### Lexer / Lexical Analysis

- موجود فعلياً في `FlaskLexer.g4`.
- يدعم Tokens خاصة بـ Python/Flask مثل `FROM`, `IMPORT`, `DEF`, `RETURN`, `CLASS`, و`APP_ROUTE`.
- يدعم Tokens خاصة بـ Jinja2 مثل `BLOCK_START`, `BLOCK_END`, `TEMPLATE_EXPRESSION`, `IF`, `FOR`, `ENDFOR`, `EXTENDS`, `INCLUDE`, `SET`.
- يدعم HTML tags عبر `LT`, `GT`, `CLOSE_TAG`, `SELF_CLOSE`.
- يدعم CSS جزئياً عبر `CSS_CUSTOM_PROPERTY`, `COLON`, `SEMICOLON`, selectors/values في parser.
- ANTLR يحفظ line/column، والمشروع يستخدمها في `BaseVisitor.addRow(...)` وفي عقد AST والأخطاء.

### Parser / Syntax Analysis

- موجود فعلياً في `FlaskParser.g4`.
- قاعدة البداية `application` تقرأ imports ثم app declaration ثم global assignments ثم routes ثم main guard.
- يوجد parsing لـ:
  - Flask routes: `routeDefinition`, `routeDecorator`, `routeBody`.
  - Python subset: `globalAssignment`, `dictLiteral`, `pyExpression`, `ifBlock`.
  - Jinja2: `jinja2Block`, `jinja2IfBlock`, `jinja2ForBlock`, `jinja2BlockTag`, `jinja2ExtendsTag`, `jinja2IncludeTag`, `jinja2SetTag`.
  - HTML: `htmlDocument`, `htmlElement`, `startTag`, `endTag`, `attribute`.
  - CSS: `cssContent`, `cssRule`, `cssDeclaration`, `cssValue`.
- Syntax errors موجودة عبر `syntax_check/SyntaxErrorListener.java`.
- `Main.java` يوقف التوليد عند وجود syntax errors.
- تم التحقق بعينة `samples/sample_syntax_error.txt`: ظهرت `Syntax Errors (1)` وتم طباعة line/column وإيقاف التوليد.

### AST

- يوجد Base Node باسم `classes/ASTNode.java`.
- `ASTNode` يحتوي:
  - `nodeType`
  - `line`
  - `column`
  - `children`
  - `print()`
- توجد AST خاصة بـ Python/Flask في `python_ast/`:
  - `PythonProgramNode`
  - `RouteNode`
  - `AssignmentNode`
  - `ListNode`
  - `DictNode`
  - `ReturnNode`
  - `RenderTemplateNode`
- توجد AST خاصة بـ Jinja2/HTML في `jinja_ast/`:
  - `TemplateNode`
  - `JinjaVariableNode`
  - `JinjaForNode`
  - `JinjaIfNode`
  - `JinjaExpressionNode`
  - `HtmlElementNode`
- `classes/BaseVisitor.java` يبني الشجرتين ويربطهما داخل `Application`.
- `classes/Application.java` يطبع:
  - `printPythonAst()`
  - `printJinjaAst()`
  - `printFullAst()`
- يوجد مخطط AST في `AST_DIAGRAM.md`.

### OOP / Nodes

- يوجد inheritance واضح: عقد مثل `RouteNode`, `ListNode`, `TemplateNode`, `JinjaVariableNode` ترث من `ASTNode`.
- يوجد polymorphism عملي في `print()` لأن كل عقدة تستخدم البنية العامة من `ASTNode` ويمكنها إضافة children خاصة بها.
- كل عقدة أساسية تحفظ line/column.
- كل عقدة تستطيع حفظ children عبر `addChild(...)`.

### Symbol Table

- موجود في `symbol_table/SymbolTable.java`.
- الصفوف ممثلة في `symbol_table/Row.java`.
- `Row` يحفظ:
  - `type`
  - `value`
  - `line`
  - `column`
  - `scope`
  - `origin`
  - `dataType`
  - `usedInTemplate`
  - `passedToTemplate`
  - `additionalData`
- يتم تعبئته داخل `classes/BaseVisitor.java` أثناء زيارة parse tree.
- يتم استخدامه في Semantic Analysis.
- يمكن طباعته عبر `SymbolTable.print()`.
- يوجد ربط Python -> Jinja عبر rows من النوع `templateBinding` مثل: `items -> products_data`.

### Semantic Analysis

- موجود في `semantic_check/SemanticAnalyzer.java`.
- يعتمد على interface `semantic_check/SemanticCheck.java`.
- الفحوص المسجلة حالياً 10:
  - `UndefinedJinjaVariableCheck`
  - `UndefinedPythonVariableCheck`
  - `ForLoopSourceCheck`
  - `RouteUniquenessCheck`
  - `RouteFunctionUniquenessCheck`
  - `JinjaIfConditionCheck`
  - `ProductRequiredFieldsCheck`
  - `InvalidPropertyAccessCheck`
  - `EmptyDataListCheck`
  - `ComponentRequirementsCheck`
- الأخطاء تحتوي رسالة، تفاصيل، نوع، line، column عبر `SemanticError`.
- `Main.java` يوقف التوليد عند وجود semantic errors.
- تم التحقق بعينة `samples/sample_semantic_full.txt`، والنتيجة كانت `Semantic Errors (10)` مع إيقاف التوليد.
- يوجد توثيق لكل فحص في `SEMANTIC_CHECKS.md`.

### Code Generation

- موجود في مجلد `code_generation/`.
- الملفات المهمة:
  - `BaseComponentView.java`
  - `GenericView.java`
  - `ViewFactory.java`
  - `ComponentFileSaver.java`
  - `GeneratedComponent.java`
- يولد:
  - `generated_components/app.py`
  - `generated_components/templates/base.html`
  - `generated_components/templates/Index.html`
  - `generated_components/templates/Products.html`
  - `generated_components/templates/AddProduct.html`
  - `generated_components/templates/ProductDetail.html`
  - `generated_components/static/style.css`
- `generated_components/app.py` يحتوي routes:
  - `/`
  - `/products`
  - `/product/add`
  - `/product/<int:id>`
  - `/product/delete/<int:id>`
- البيانات `products_data` تظهر في Jinja عبر `items = products_data` ثم `{% for p in items %}`.
- تم فحص syntax تطبيق Flask المولد بالأمر `python -m py_compile generated_components\app.py` ونجح.

### واجهات الويب والتنقل

- عرض المنتجات موجود في `generated_components/templates/Products.html`.
- إضافة منتج موجودة في `generated_components/templates/AddProduct.html` وroute `/product/add`.
- تفاصيل المنتج موجودة في `generated_components/templates/ProductDetail.html` وroute `/product/<int:id>`.
- حذف المنتج موجود في `generated_components/app.py` عبر route `/product/delete/<int:id>` مع forms في Products وProductDetail.
- يوجد navigation في `base.html` إلى المنتجات والإضافة.
- CSS موجود في `generated_components/static/style.css`.

### التقرير والتسليم

- يوجد `README.md`.
- يوجد `AST_DIAGRAM.md`.
- يوجد `SEMANTIC_CHECKS.md`.
- يوجد `run_tests.bat` لتشغيل التحقق الأساسي قبل العرض.
- يوجد `generated_components_smoke_test.py` لاختبار routes التطبيق المولد عند توفر Flask.
- يوجد `REPORT.md` وهذا الملف هو تقرير المقارنة الحالي.
- يوجد `SUBMISSION_INFO.txt` لكنه يحتاج تعبئة فعلية.

## 2. المتطلبات الناقصة

- لا يوجد GitHub repository URL فعلي في `SUBMISSION_INFO.txt`.
- لا توجد أسماء أعضاء المجموعة في `SUBMISSION_INFO.txt`.
- لا يوجد ملف مضغوط نهائي باسم رقم المجموعة، وهذا طبيعي لأنه يعتمد على رقم المجموعة وقت التسليم.
- لا يوجد اختبار JUnit شامل، لكن يوجد `run_tests.bat` كاختبار عملي سريع للعرض.
- لا يوجد Parser كامل للغة Python الرسمية؛ الموجود subset مناسب للمشروع.
- لا يوجد Parser كامل لكل قواعد Jinja2 الرسمية؛ الموجود يغطي for/if/block/extends/include/set وبعض variables.
- لا يوجد Parser كامل لكل HTML/CSS؛ الموجود يغطي عناصر وقواعد أساسية فقط.
- لا توجد مرحلة type inference قوية؛ الموجود يستنتج أنواعاً بسيطة مثل list/string/dict/number/expression.
- لا توجد Symbol Table متعددة scopes بشكل عميق مثل scopes داخل if/for، بل scope غالباً route/function.
- لا يوجد تشغيل live server ضمن الاختبارات، لكن يوجد smoke test باستخدام Flask test client في `generated_components_smoke_test.py`.

## 3. القيود الحالية والتحسينات المستقبلية

- Lexer/Parser موجودان، لكنهما يصفان DSL محدوداً وليس Python/Jinja/HTML/CSS كاملة. يجب تسمية ذلك صراحة: "Compiler for a Flask subset".
- AST موجودة ومنفصلة، لكن بناء Jinja AST داخل `BaseVisitor.buildTemplateAst(...)` يعتمد على Regex، وليس على Parser كامل للقالب. هذا مقبول عملياً لكنه نقطة ضعف إذا سأل الدكتور عن parsing الحقيقي لـ Jinja.
- `FlaskParser.g4` يحتوي قواعد HTML/Jinja/CSS، لكن القوالب الفعلية داخل triple quoted strings لا تمر كلها عبر هذه القواعد؛ يتم استخراجها لاحقاً بـ Regex. الأفضل مستقبلاً تشغيل lexer/parser فرعي على محتوى القالب.
- `InvalidPropertyAccessCheck` و`ProductRequiredFieldsCheck` يعتمدان على Regex لاستخراج keys من dicts، وليس AST عميقة للقواميس.
- `UndefinedPythonVariableCheck` مفيد لكنه محدود، وقد يعطي نتائج غير كاملة مع expressions معقدة.
- تم تنظيف رسائل الطباعة الأساسية إلى ASCII، ويجب تشغيل `run_tests.bat` للتأكد من أن الخرج النهائي واضح في PowerShell.
- تم تعديل `build.bat` بحيث لا يعرض stack trace غير مؤثر من `javac` عند نجاح التجميع، مع إبقاء أخطاء التجميع الحقيقية ظاهرة عند الفشل.
- `REPORT.md` وملفات markdown السابقة كانت تعاني من ترميز مشوه؛ تم تحديث هذا التقرير بنص UTF-8 واضح، لكن يجب فتحه في محرر يدعم UTF-8.
- CSS والتصميم موجودان ومقبولان، لكن التصميم يعتمد كثيراً على gradients وأسلوب عام؛ ليس مشكلة مترجمات، لكنه ليس محور العلامة.

## 4. أخطر الفجوات في المشروع

### ملاحظات يجب توضيحها في المناقشة

1. المشروع يستخدم Java وANTLR لبناء compiler، بينما الكود الناتج هو تطبيق Python Flask/Jinja2. لذلك يجب توضيح أن Java/ANTLR هي أدوات تنفيذ المترجم، وليست مخالفة لفكرة المشروع، لأن الهدف النهائي هو تحليل وتوليد تطبيق Flask/Jinja.
2. الاعتماد على subset بدلاً من Python/Jinja كامل يجب توضيحه حتى لا يظهر كادعاء زائد.
3. يجب تعبئة `SUBMISSION_INFO.txt` برابط GitHub وأسماء الأعضاء الحقيقيين قبل التسليم.
4. يجب تشغيل `run_tests.bat` على جهاز العرض النهائي قبل المناقشة.

### تؤثر على العلامة

1. Jinja AST مبنية بـ Regex لا Parser مستقل كامل.
2. Semantic Analysis جيد لكنه محدود بالبنى الموجودة في العينة.
3. Symbol Table لا تدعم scopes داخلية عميقة.
4. يوجد test runner بسيط، لكنه ليس بديلاً عن اختبارات JUnit كاملة.
5. توجد أمثلة موثقة في `SEMANTIC_CHECKS.md`، ويمكن تحسينها أكثر بإضافة sample مستقل لكل فحص.

### تحسينها يعطي تميزاً في المناقشة

1. إضافة sample مستقل لكل SemanticCheck.
2. توسيع smoke test ليغطي POST add/delete.
3. تحسين مخرجات AST أكثر بإظهار روابط parent/context عند الحاجة.
4. تحويل parsing القوالب من Regex إلى Parser فرعي حقيقي أو استخدام قواعد `htmlDocument/jinja2Block`.
5. إضافة README section يشرح pipeline: Tokens -> Parse Tree -> AST -> Symbol Table -> Semantic -> Code Generation.

## 5. خطة التعديل المقترحة

### مرحلة Lexer/Parser

- توثيق أن القواعد تغطي subset من Flask/Python/Jinja/HTML/CSS.
- تقليل الاعتماد على `pyInner` المرن لأنه يقبل نصوصاً كثيرة بدون تحليل عميق.
- تفعيل قواعد `htmlDocument`, `jinja2Block`, `cssContent` على محتوى القوالب بدلاً من الاكتفاء بـ Regex.

### مرحلة AST

- تم تحسين طباعة العقد المهمة لتعرض `value/name`، مثل `RouteNode(route="/products", function="products")`.
- تمثيل dict entries في Python AST بعقد مستقلة بدلاً من raw text فقط.
- فصل Jinja AST عن Python AST في التخزين، مع الاحتفاظ بعقد binding واضحة بينهما.

### مرحلة Symbol Table

- إضافة scopes داخلية مثل `route.products`, `route.products.for.p`.
- جعل `templateBinding` يحتوي `pythonSource`, `jinjaName`, `routeName` كحقول واضحة بدلاً من الاعتماد على `additionalData`.
- إضافة دالة export إلى Markdown أو JSON لتسهيل وضع الجدول في التقرير النهائي.

### مرحلة Semantic Analysis

- كتابة sample صغير مستقل لكل فحص دلالي.
- استخدام `run_tests.bat` قبل المناقشة للتأكد من valid sample وsemantic sample وsyntax sample.
- تقوية فحص Python expressions حتى لا يعتمد كثيراً على regex.
- إضافة فحص type mismatch أو duplicate variable إن كان مطلوباً من الدكتور.

### مرحلة Generator

- إزالة أي duplication محتمل في إضافة delete button، لأنه يضاف في `Main.withDeleteButton(...)` ويوجد أيضاً منطق مشابه في `ComponentFileSaver`.
- استخدام `generated_components_smoke_test.py` لاستدعاء الصفحات الأساسية عبر Flask test client عند توفر Flask.
- التأكد من عدم الكتابة فوق `generated_components` عند وجود semantic errors.

### مرحلة واجهات Flask/Jinja

- تجربة CRUD يدوياً: عرض، إضافة، تفاصيل، حذف.
- التأكد أن route الحذف يستخدم POST كما هو حالياً.
- تحسين الصفحة الرئيسية إذا أراد الفريق عرض المشروع بشكل أفضل، لكن هذا أقل أهمية من المترجم.

### مرحلة التقرير والتسليم

- تعبئة `SUBMISSION_INFO.txt` بالقيم الحقيقية قبل التسليم.
- إضافة screenshots أو snippets من AST/Symbol Table/Semantic errors إلى التقرير النهائي.
- ضغط المشروع بعد حذف ملفات غير ضرورية إن لزم، مع الحفاظ على source وsamples وANTLR jar.
- تشغيل checklist أدناه قبل التسليم.

## 6. Checklist نهائية قبل التسليم

- [ ] `build.bat` يعمل بدون رسائل stack trace مربكة.
- [ ] `run_tests.bat` ينهي كل الفحوص برسالة `All checks finished.`
- [ ] `java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample.txt` يولد `generated_components`.
- [ ] `python -m py_compile generated_components\app.py` ينجح.
- [ ] `generated_components_smoke_test.py` يثبت أن `/`, `/products`, `/product/add`, `/product/1` تستجيب.
- [ ] إضافة منتج تعمل من صفحة `/product/add`.
- [ ] حذف منتج يعمل من `/products` أو `/product/1`.
- [ ] `samples/sample_syntax_error.txt` يظهر Syntax error مع line/column ويوقف التوليد.
- [ ] `samples/sample_semantic_full.txt` يظهر 10 Semantic errors ويوقف التوليد.
- [ ] Python AST تطبع من `Main.printAst(...)`.
- [ ] Jinja2 AST تطبع من `Main.printAst(...)`.
- [ ] Full AST تطبع بشكل هرمي.
- [ ] Symbol Table يطبع origin/dataType/scope/used/passed/location.
- [ ] Python -> Jinja bindings تظهر في Symbol Table.
- [ ] `README.md` يشرح طريقة البناء والتشغيل.
- [ ] `AST_DIAGRAM.md` موجود ومحدث.
- [ ] `SEMANTIC_CHECKS.md` موجود ومحدث.
- [ ] `REPORT.md` موجود ومقروء بترميز UTF-8.
- [ ] `SUBMISSION_INFO.txt` يحتوي رابط GitHub الحقيقي.
- [ ] `SUBMISSION_INFO.txt` يحتوي أسماء أعضاء المجموعة.
- [ ] الملف المضغوط النهائي يحتوي source code وsamples والتقرير والمخطط.
- [ ] اسم الملف المضغوط مطابق لرقم المجموعة المطلوب.

## أوامر التحقق التي تم تشغيلها

```bat
.\build.bat
python -m py_compile generated_components\app.py
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_semantic_full.txt
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_syntax_error.txt
```

نتائج التحقق:

- البناء ولّد تطبيق Flask صحيحاً في `generated_components/`.
- فحص Python syntax للملف `generated_components/app.py` نجح.
- عينة semantic أظهرت 10 أخطاء دلالية مع line/column وتم إيقاف التوليد.
- عينة syntax أظهرت خطأ syntax واحداً مع line/column وتم إيقاف التوليد.
