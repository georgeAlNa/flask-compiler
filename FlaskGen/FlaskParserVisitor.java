// Generated from FlaskParser.g4 by ANTLR 4.13.1
package FlaskGen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code applicationRoot}
	 * labeled alternative in {@link FlaskParser#application}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplicationRoot(FlaskParser.ApplicationRootContext ctx);
	/**
	 * Visit a parse tree produced by the {@code importDef}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDef(FlaskParser.ImportDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code appDef}
	 * labeled alternative in {@link FlaskParser#appDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppDef(FlaskParser.AppDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalListDef}
	 * labeled alternative in {@link FlaskParser#globalAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalListDef(FlaskParser.GlobalListDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictDef}
	 * labeled alternative in {@link FlaskParser#dictLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictDef(FlaskParser.DictDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictEntryDef}
	 * labeled alternative in {@link FlaskParser#dictEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictEntryDef(FlaskParser.DictEntryDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routeDef}
	 * labeled alternative in {@link FlaskParser#routeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDef(FlaskParser.RouteDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routeDecoratorDef}
	 * labeled alternative in {@link FlaskParser#routeDecorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDecoratorDef(FlaskParser.RouteDecoratorDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramList}
	 * labeled alternative in {@link FlaskParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(FlaskParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routeBodyContent}
	 * labeled alternative in {@link FlaskParser#routeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteBodyContent(FlaskParser.RouteBodyContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyIfBlock}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyIfBlock(FlaskParser.BodyIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyTemplateAssignment}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyTemplateAssignment(FlaskParser.BodyTemplateAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyReturnStatement}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyReturnStatement(FlaskParser.BodyReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyVarAssignment}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyVarAssignment(FlaskParser.BodyVarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyExpressionStatement}
	 * labeled alternative in {@link FlaskParser#bodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyExpressionStatement(FlaskParser.BodyExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifBlockDef}
	 * labeled alternative in {@link FlaskParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlockDef(FlaskParser.IfBlockDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerBodyTemplateAssignment}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerBodyTemplateAssignment(FlaskParser.InnerBodyTemplateAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerBodyVarAssignment}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerBodyVarAssignment(FlaskParser.InnerBodyVarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerBodyExpressionStatement}
	 * labeled alternative in {@link FlaskParser#innerBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerBodyExpressionStatement(FlaskParser.InnerBodyExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mainGuardDef}
	 * labeled alternative in {@link FlaskParser#mainGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainGuardDef(FlaskParser.MainGuardDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#pyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyExpression(FlaskParser.PyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#pyAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyAtom(FlaskParser.PyAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#pyOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyOp(FlaskParser.PyOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#pyInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyInner(FlaskParser.PyInnerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneLiteral(FlaskParser.NoneLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(FlaskParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(FlaskParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(FlaskParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(FlaskParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(FlaskParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlDocumentContent}
	 * labeled alternative in {@link FlaskParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocumentContent(FlaskParser.HtmlDocumentContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlStandardElement}
	 * labeled alternative in {@link FlaskParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlStandardElement(FlaskParser.HtmlStandardElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlSelfClosingElement}
	 * labeled alternative in {@link FlaskParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlSelfClosingElement(FlaskParser.HtmlSelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlStartTag}
	 * labeled alternative in {@link FlaskParser#startTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlStartTag(FlaskParser.HtmlStartTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlEndTag}
	 * labeled alternative in {@link FlaskParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlEndTag(FlaskParser.HtmlEndTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlSelfClosingTag}
	 * labeled alternative in {@link FlaskParser#selfClosingTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlSelfClosingTag(FlaskParser.HtmlSelfClosingTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlNestedElement}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlNestedElement(FlaskParser.HtmlNestedElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlTemplateExpression}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTemplateExpression(FlaskParser.HtmlTemplateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlJinja2Block}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlJinja2Block(FlaskParser.HtmlJinja2BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlTextContent}
	 * labeled alternative in {@link FlaskParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTextContent(FlaskParser.HtmlTextContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#textToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextToken(FlaskParser.TextTokenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinja2IfBlock}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2IfBlock(FlaskParser.Jinja2IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinja2ForBlock}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2ForBlock(FlaskParser.Jinja2ForBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinja2BlockTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2BlockTag(FlaskParser.Jinja2BlockTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinja2ExtendsTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2ExtendsTag(FlaskParser.Jinja2ExtendsTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinja2IncludeTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2IncludeTag(FlaskParser.Jinja2IncludeTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinja2SetTag}
	 * labeled alternative in {@link FlaskParser#jinja2Block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja2SetTag(FlaskParser.Jinja2SetTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlTagName}
	 * labeled alternative in {@link FlaskParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTagName(FlaskParser.HtmlTagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlAttributeBasic}
	 * labeled alternative in {@link FlaskParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeBasic(FlaskParser.HtmlAttributeBasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlAttributeClass}
	 * labeled alternative in {@link FlaskParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeClass(FlaskParser.HtmlAttributeClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlAttributeValue}
	 * labeled alternative in {@link FlaskParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeValue(FlaskParser.HtmlAttributeValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(FlaskParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(FlaskParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(FlaskParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(FlaskParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(FlaskParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(FlaskParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(FlaskParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(FlaskParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssContentRules}
	 * labeled alternative in {@link FlaskParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssContentRules(FlaskParser.CssContentRulesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssRuleDefinition}
	 * labeled alternative in {@link FlaskParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRuleDefinition(FlaskParser.CssRuleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelector(FlaskParser.CssSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssDeclarationEntry}
	 * labeled alternative in {@link FlaskParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclarationEntry(FlaskParser.CssDeclarationEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssCustomPropertyEntry}
	 * labeled alternative in {@link FlaskParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssCustomPropertyEntry(FlaskParser.CssCustomPropertyEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssValueString}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueString(FlaskParser.CssValueStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssValueDimension}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueDimension(FlaskParser.CssValueDimensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssValueNumber}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueNumber(FlaskParser.CssValueNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssValueAlphabet}
	 * labeled alternative in {@link FlaskParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueAlphabet(FlaskParser.CssValueAlphabetContext ctx);
}