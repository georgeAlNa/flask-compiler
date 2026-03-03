// Generated from FlaskParser.g4 by ANTLR 4.13.1
package FlaskGen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskParser}.
 */
public interface FlaskParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code applicationRoot}
	 * labeled alternative in {@link FlaskParser#application}.
	 * @param ctx the parse tree
	 */
	void enterApplicationRoot(FlaskParser.ApplicationRootContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applicationRoot}
	 * labeled alternative in {@link FlaskParser#application}.
	 * @param ctx the parse tree
	 */
	void exitApplicationRoot(FlaskParser.ApplicationRootContext ctx);
	/**
	 * Enter a parse tree produced by the {@code importDef}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportDef(FlaskParser.ImportDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code importDef}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportDef(FlaskParser.ImportDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code appDef}
	 * labeled alternative in {@link FlaskParser#appDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAppDef(FlaskParser.AppDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code appDef}
	 * labeled alternative in {@link FlaskParser#appDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAppDef(FlaskParser.AppDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code globalListDef}
	 * labeled alternative in {@link FlaskParser#globalAssignment}.
	 * @param ctx the parse tree
	 */
	void enterGlobalListDef(FlaskParser.GlobalListDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code globalListDef}
	 * labeled alternative in {@link FlaskParser#globalAssignment}.
	 * @param ctx the parse tree
	 */
	void exitGlobalListDef(FlaskParser.GlobalListDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictDef}
	 * labeled alternative in {@link FlaskParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictDef(FlaskParser.DictDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictDef}
	 * labeled alternative in {@link FlaskParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictDef(FlaskParser.DictDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictEntryDef}
	 * labeled alternative in {@link FlaskParser#dictEntry}.
	 * @param ctx the parse tree
	 */
	void enterDictEntryDef(FlaskParser.DictEntryDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictEntryDef}
	 * labeled alternative in {@link FlaskParser#dictEntry}.
	 * @param ctx the parse tree
	 */
	void exitDictEntryDef(FlaskParser.DictEntryDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code routeDef}
	 * labeled alternative in {@link FlaskParser#routeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterRouteDef(FlaskParser.RouteDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code routeDef}
	 * labeled alternative in {@link FlaskParser#routeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitRouteDef(FlaskParser.RouteDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code routeDecoratorDef}
	 * labeled alternative in {@link FlaskParser#routeDecorator}.
	 * @param ctx the parse tree
	 */
	void enterRouteDecoratorDef(FlaskParser.RouteDecoratorDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code routeDecoratorDef}
	 * labeled alternative in {@link FlaskParser#routeDecorator}.
	 * @param ctx the parse tree
	 */
	void exitRouteDecoratorDef(FlaskParser.RouteDecoratorDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramList}
	 * labeled alternative in {@link FlaskParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(FlaskParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramList}
	 * labeled alternative in {@link FlaskParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(FlaskParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code routeBodyContent}
	 * labeled alternative in {@link FlaskParser#routeBody}.
	 * @param ctx the parse tree
	 */
	void enterRouteBodyContent(FlaskParser.RouteBodyContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code routeBodyContent}
	 * labeled alternative in {@link FlaskParser#routeBody}.
	 * @param ctx the parse tree
	 */
	void exitRouteBodyContent(FlaskParser.RouteBodyContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodyIfBlock}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterBodyIfBlock(FlaskParser.BodyIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodyIfBlock}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitBodyIfBlock(FlaskParser.BodyIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodyTemplateAssignment}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterBodyTemplateAssignment(FlaskParser.BodyTemplateAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodyTemplateAssignment}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitBodyTemplateAssignment(FlaskParser.BodyTemplateAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodyReturnStatement}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterBodyReturnStatement(FlaskParser.BodyReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodyReturnStatement}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitBodyReturnStatement(FlaskParser.BodyReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodyVarAssignment}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterBodyVarAssignment(FlaskParser.BodyVarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodyVarAssignment}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitBodyVarAssignment(FlaskParser.BodyVarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodyExpressionStatement}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterBodyExpressionStatement(FlaskParser.BodyExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodyExpressionStatement}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitBodyExpressionStatement(FlaskParser.BodyExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifBlockDef}
	 * labeled alternative in {@link FlaskParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlockDef(FlaskParser.IfBlockDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifBlockDef}
	 * labeled alternative in {@link FlaskParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlockDef(FlaskParser.IfBlockDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerBodyTemplateAssignment}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterInnerBodyTemplateAssignment(FlaskParser.InnerBodyTemplateAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerBodyTemplateAssignment}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitInnerBodyTemplateAssignment(FlaskParser.InnerBodyTemplateAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerBodyVarAssignment}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterInnerBodyVarAssignment(FlaskParser.InnerBodyVarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerBodyVarAssignment}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitInnerBodyVarAssignment(FlaskParser.InnerBodyVarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerBodyExpressionStatement}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 */
	void enterInnerBodyExpressionStatement(FlaskParser.InnerBodyExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerBodyExpressionStatement}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 */
	void exitInnerBodyExpressionStatement(FlaskParser.InnerBodyExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mainGuardDef}
	 * labeled alternative in {@link FlaskParser#mainGuard}.
	 * @param ctx the parse tree
	 */
	void enterMainGuardDef(FlaskParser.MainGuardDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mainGuardDef}
	 * labeled alternative in {@link FlaskParser#mainGuard}.
	 * @param ctx the parse tree
	 */
	void exitMainGuardDef(FlaskParser.MainGuardDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#pyExpression}.
	 * @param ctx the parse tree
	 */
	void enterPyExpression(FlaskParser.PyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#pyExpression}.
	 * @param ctx the parse tree
	 */
	void exitPyExpression(FlaskParser.PyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#pyAtom}.
	 * @param ctx the parse tree
	 */
	void enterPyAtom(FlaskParser.PyAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#pyAtom}.
	 * @param ctx the parse tree
	 */
	void exitPyAtom(FlaskParser.PyAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#pyOp}.
	 * @param ctx the parse tree
	 */
	void enterPyOp(FlaskParser.PyOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#pyOp}.
	 * @param ctx the parse tree
	 */
	void exitPyOp(FlaskParser.PyOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#pyInner}.
	 * @param ctx the parse tree
	 */
	void enterPyInner(FlaskParser.PyInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#pyInner}.
	 * @param ctx the parse tree
	 */
	void exitPyInner(FlaskParser.PyInnerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNoneLiteral(FlaskParser.NoneLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNoneLiteral(FlaskParser.NoneLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(FlaskParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(FlaskParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTrueLiteral(FlaskParser.TrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTrueLiteral(FlaskParser.TrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFalseLiteral(FlaskParser.FalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFalseLiteral(FlaskParser.FalseLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(FlaskParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(FlaskParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(FlaskParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(FlaskParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlDocumentContent}
	 * labeled alternative in {@link FlaskParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocumentContent(FlaskParser.HtmlDocumentContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlDocumentContent}
	 * labeled alternative in {@link FlaskParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocumentContent(FlaskParser.HtmlDocumentContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlStandardElement}
	 * labeled alternative in {@link FlaskParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlStandardElement(FlaskParser.HtmlStandardElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlStandardElement}
	 * labeled alternative in {@link FlaskParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlStandardElement(FlaskParser.HtmlStandardElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlSelfClosingElement}
	 * labeled alternative in {@link FlaskParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlSelfClosingElement(FlaskParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlSelfClosingElement}
	 * labeled alternative in {@link FlaskParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlSelfClosingElement(FlaskParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlStartTag}
	 * labeled alternative in {@link FlaskParser#startTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlStartTag(FlaskParser.HtmlStartTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlStartTag}
	 * labeled alternative in {@link FlaskParser#startTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlStartTag(FlaskParser.HtmlStartTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlEndTag}
	 * labeled alternative in {@link FlaskParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlEndTag(FlaskParser.HtmlEndTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlEndTag}
	 * labeled alternative in {@link FlaskParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlEndTag(FlaskParser.HtmlEndTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlSelfClosingTag}
	 * labeled alternative in {@link FlaskParser#selfClosingTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlSelfClosingTag(FlaskParser.HtmlSelfClosingTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlSelfClosingTag}
	 * labeled alternative in {@link FlaskParser#selfClosingTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlSelfClosingTag(FlaskParser.HtmlSelfClosingTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlNestedElement}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlNestedElement(FlaskParser.HtmlNestedElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlNestedElement}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlNestedElement(FlaskParser.HtmlNestedElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlTemplateExpression}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTemplateExpression(FlaskParser.HtmlTemplateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlTemplateExpression}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTemplateExpression(FlaskParser.HtmlTemplateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlJinja2Block}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlJinja2Block(FlaskParser.HtmlJinja2BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlJinja2Block}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlJinja2Block(FlaskParser.HtmlJinja2BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlTextContent}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextContent(FlaskParser.HtmlTextContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlTextContent}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextContent(FlaskParser.HtmlTextContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#textToken}.
	 * @param ctx the parse tree
	 */
	void enterTextToken(FlaskParser.TextTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#textToken}.
	 * @param ctx the parse tree
	 */
	void exitTextToken(FlaskParser.TextTokenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinja2IfBlock}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void enterJinja2IfBlock(FlaskParser.Jinja2IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2IfBlock}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void exitJinja2IfBlock(FlaskParser.Jinja2IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinja2ForBlock}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void enterJinja2ForBlock(FlaskParser.Jinja2ForBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2ForBlock}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void exitJinja2ForBlock(FlaskParser.Jinja2ForBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinja2BlockTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void enterJinja2BlockTag(FlaskParser.Jinja2BlockTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2BlockTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void exitJinja2BlockTag(FlaskParser.Jinja2BlockTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinja2ExtendsTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void enterJinja2ExtendsTag(FlaskParser.Jinja2ExtendsTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2ExtendsTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void exitJinja2ExtendsTag(FlaskParser.Jinja2ExtendsTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinja2IncludeTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void enterJinja2IncludeTag(FlaskParser.Jinja2IncludeTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2IncludeTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void exitJinja2IncludeTag(FlaskParser.Jinja2IncludeTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinja2SetTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void enterJinja2SetTag(FlaskParser.Jinja2SetTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinja2SetTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 */
	void exitJinja2SetTag(FlaskParser.Jinja2SetTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlTagName}
	 * labeled alternative in {@link FlaskParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTagName(FlaskParser.HtmlTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlTagName}
	 * labeled alternative in {@link FlaskParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTagName(FlaskParser.HtmlTagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlAttributeBasic}
	 * labeled alternative in {@link FlaskParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeBasic(FlaskParser.HtmlAttributeBasicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlAttributeBasic}
	 * labeled alternative in {@link FlaskParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeBasic(FlaskParser.HtmlAttributeBasicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlAttributeClass}
	 * labeled alternative in {@link FlaskParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeClass(FlaskParser.HtmlAttributeClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlAttributeClass}
	 * labeled alternative in {@link FlaskParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeClass(FlaskParser.HtmlAttributeClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlAttributeValue}
	 * labeled alternative in {@link FlaskParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeValue(FlaskParser.HtmlAttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlAttributeValue}
	 * labeled alternative in {@link FlaskParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeValue(FlaskParser.HtmlAttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(FlaskParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(FlaskParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(FlaskParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(FlaskParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(FlaskParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(FlaskParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(FlaskParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(FlaskParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(FlaskParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(FlaskParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(FlaskParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(FlaskParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(FlaskParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(FlaskParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(FlaskParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(FlaskParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssContentRules}
	 * labeled alternative in {@link FlaskParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssContentRules(FlaskParser.CssContentRulesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssContentRules}
	 * labeled alternative in {@link FlaskParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssContentRules(FlaskParser.CssContentRulesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssRuleDefinition}
	 * labeled alternative in {@link FlaskParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRuleDefinition(FlaskParser.CssRuleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssRuleDefinition}
	 * labeled alternative in {@link FlaskParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRuleDefinition(FlaskParser.CssRuleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssSelector(FlaskParser.CssSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssSelector(FlaskParser.CssSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssDeclarationEntry}
	 * labeled alternative in {@link FlaskParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclarationEntry(FlaskParser.CssDeclarationEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssDeclarationEntry}
	 * labeled alternative in {@link FlaskParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclarationEntry(FlaskParser.CssDeclarationEntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssCustomPropertyEntry}
	 * labeled alternative in {@link FlaskParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssCustomPropertyEntry(FlaskParser.CssCustomPropertyEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssCustomPropertyEntry}
	 * labeled alternative in {@link FlaskParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssCustomPropertyEntry(FlaskParser.CssCustomPropertyEntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssValueString}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueString(FlaskParser.CssValueStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssValueString}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueString(FlaskParser.CssValueStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssValueDimension}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueDimension(FlaskParser.CssValueDimensionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssValueDimension}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueDimension(FlaskParser.CssValueDimensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssValueNumber}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueNumber(FlaskParser.CssValueNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssValueNumber}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueNumber(FlaskParser.CssValueNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssValueAlphabet}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValueAlphabet(FlaskParser.CssValueAlphabetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssValueAlphabet}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValueAlphabet(FlaskParser.CssValueAlphabetContext ctx);
}