// Generated from FlaskParser.g4 by ANTLR 4.13.1
package FlaskGen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FlaskParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		APP_ROUTE=1, DEF=2, RETURN=3, FROM=4, IMPORT=5, CLASS=6, TEMPLATE_KW=7, 
		STYLES=8, IF=9, ELIF=10, ELSE=11, ENDIF=12, FOR=13, IN=14, ENDFOR=15, 
		BLOCK=16, ENDBLOCK=17, EXTENDS=18, INCLUDE=19, SET=20, NOT=21, AND=22, 
		OR=23, IS=24, TRUE=25, FALSE=26, NONE=27, NULL=28, SELF_CLOSE=29, CLOSE_TAG=30, 
		LT=31, GT=32, SLASH=33, BLOCK_START=34, BLOCK_END=35, COMMENT_START=36, 
		COMMENT_END=37, TEMPLATE_EXPRESSION=38, TRIPLE_QUOTE_STRING=39, LCURLEBRACE=40, 
		RCURLEBRACE=41, LSQBRACKET=42, RSQBRACKET=43, LPAREN=44, RPAREN=45, COLON=46, 
		COMMA=47, DOT=48, SEMICOLON=49, PIPE=50, STAR=51, PLUS=52, MINUS=53, PERCENT=54, 
		TILDE=55, QUESTION_MARK=56, AT=57, HASH=58, EQUAL=59, BACKTICK=60, EQEQ=61, 
		NOTEQ=62, LTE=63, GTE=64, CSS_CUSTOM_PROPERTY=65, DUNDER_NAME=66, IDENTIFIER=67, 
		STRING=68, NUMBER=69, PY_COMMENT=70, WS=71, LINE_COMMENT=72, BLOCK_COMMENT=73;
	public static final int
		RULE_application = 0, RULE_importStatement = 1, RULE_appDeclaration = 2, 
		RULE_globalAssignment = 3, RULE_dictLiteral = 4, RULE_dictEntry = 5, RULE_routeDefinition = 6, 
		RULE_routeDecorator = 7, RULE_parameterList = 8, RULE_routeBody = 9, RULE_bodyStatement = 10, 
		RULE_ifBlock = 11, RULE_innerBodyStatement = 12, RULE_mainGuard = 13, 
		RULE_pyExpression = 14, RULE_pyAtom = 15, RULE_pyOp = 16, RULE_pyInner = 17, 
		RULE_literal = 18, RULE_htmlDocument = 19, RULE_htmlElement = 20, RULE_startTag = 21, 
		RULE_endTag = 22, RULE_selfClosingTag = 23, RULE_htmlContent = 24, RULE_textToken = 25, 
		RULE_jinja2Block = 26, RULE_tagName = 27, RULE_attribute = 28, RULE_attributeValue = 29, 
		RULE_expression = 30, RULE_cssContent = 31, RULE_cssRule = 32, RULE_cssSelector = 33, 
		RULE_cssDeclaration = 34, RULE_cssValue = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"application", "importStatement", "appDeclaration", "globalAssignment", 
			"dictLiteral", "dictEntry", "routeDefinition", "routeDecorator", "parameterList", 
			"routeBody", "bodyStatement", "ifBlock", "innerBodyStatement", "mainGuard", 
			"pyExpression", "pyAtom", "pyOp", "pyInner", "literal", "htmlDocument", 
			"htmlElement", "startTag", "endTag", "selfClosingTag", "htmlContent", 
			"textToken", "jinja2Block", "tagName", "attribute", "attributeValue", 
			"expression", "cssContent", "cssRule", "cssSelector", "cssDeclaration", 
			"cssValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@app.route'", "'def'", "'return'", "'from'", "'import'", "'class'", 
			"'template'", "'styles'", "'if'", "'elif'", "'else'", "'endif'", "'for'", 
			"'in'", "'endfor'", "'block'", "'endblock'", "'extends'", "'include'", 
			"'set'", "'not'", "'and'", "'or'", "'is'", null, null, null, "'null'", 
			"'/>'", "'</'", "'<'", "'>'", "'/'", "'{%'", "'%}'", "'{#'", "'#}'", 
			null, null, "'{'", "'}'", "'['", "']'", "'('", "')'", "':'", "','", "'.'", 
			"';'", "'|'", "'*'", "'+'", "'-'", "'%'", "'~'", "'?'", "'@'", "'#'", 
			"'='", "'`'", "'=='", "'!='", "'<='", "'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "APP_ROUTE", "DEF", "RETURN", "FROM", "IMPORT", "CLASS", "TEMPLATE_KW", 
			"STYLES", "IF", "ELIF", "ELSE", "ENDIF", "FOR", "IN", "ENDFOR", "BLOCK", 
			"ENDBLOCK", "EXTENDS", "INCLUDE", "SET", "NOT", "AND", "OR", "IS", "TRUE", 
			"FALSE", "NONE", "NULL", "SELF_CLOSE", "CLOSE_TAG", "LT", "GT", "SLASH", 
			"BLOCK_START", "BLOCK_END", "COMMENT_START", "COMMENT_END", "TEMPLATE_EXPRESSION", 
			"TRIPLE_QUOTE_STRING", "LCURLEBRACE", "RCURLEBRACE", "LSQBRACKET", "RSQBRACKET", 
			"LPAREN", "RPAREN", "COLON", "COMMA", "DOT", "SEMICOLON", "PIPE", "STAR", 
			"PLUS", "MINUS", "PERCENT", "TILDE", "QUESTION_MARK", "AT", "HASH", "EQUAL", 
			"BACKTICK", "EQEQ", "NOTEQ", "LTE", "GTE", "CSS_CUSTOM_PROPERTY", "DUNDER_NAME", 
			"IDENTIFIER", "STRING", "NUMBER", "PY_COMMENT", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FlaskParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FlaskParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationContext extends ParserRuleContext {
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
	 
		public ApplicationContext() { }
		public void copyFrom(ApplicationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationRootContext extends ApplicationContext {
		public AppDeclarationContext appDeclaration() {
			return getRuleContext(AppDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FlaskParser.EOF, 0); }
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<GlobalAssignmentContext> globalAssignment() {
			return getRuleContexts(GlobalAssignmentContext.class);
		}
		public GlobalAssignmentContext globalAssignment(int i) {
			return getRuleContext(GlobalAssignmentContext.class,i);
		}
		public List<RouteDefinitionContext> routeDefinition() {
			return getRuleContexts(RouteDefinitionContext.class);
		}
		public RouteDefinitionContext routeDefinition(int i) {
			return getRuleContext(RouteDefinitionContext.class,i);
		}
		public MainGuardContext mainGuard() {
			return getRuleContext(MainGuardContext.class,0);
		}
		public ApplicationRootContext(ApplicationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterApplicationRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitApplicationRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitApplicationRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		ApplicationContext _localctx = new ApplicationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_application);
		int _la;
		try {
			_localctx = new ApplicationRootContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(72);
				importStatement();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			appDeclaration();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(79);
				globalAssignment();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				routeDefinition();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==APP_ROUTE );
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(90);
				mainGuard();
				}
			}

			setState(93);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
	 
		public ImportStatementContext() { }
		public void copyFrom(ImportStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportDefContext extends ImportStatementContext {
		public TerminalNode FROM() { return getToken(FlaskParser.FROM, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FlaskParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FlaskParser.IDENTIFIER, i);
		}
		public TerminalNode IMPORT() { return getToken(FlaskParser.IMPORT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskParser.COMMA, i);
		}
		public ImportDefContext(ImportStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterImportDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitImportDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitImportDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importStatement);
		int _la;
		try {
			_localctx = new ImportDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(FROM);
			setState(96);
			match(IDENTIFIER);
			setState(97);
			match(IMPORT);
			setState(98);
			match(IDENTIFIER);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(99);
				match(COMMA);
				setState(100);
				match(IDENTIFIER);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AppDeclarationContext extends ParserRuleContext {
		public AppDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_appDeclaration; }
	 
		public AppDeclarationContext() { }
		public void copyFrom(AppDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppDefContext extends AppDeclarationContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FlaskParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FlaskParser.IDENTIFIER, i);
		}
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskParser.LPAREN, 0); }
		public TerminalNode DUNDER_NAME() { return getToken(FlaskParser.DUNDER_NAME, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskParser.RPAREN, 0); }
		public AppDefContext(AppDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterAppDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitAppDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitAppDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppDeclarationContext appDeclaration() throws RecognitionException {
		AppDeclarationContext _localctx = new AppDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_appDeclaration);
		try {
			_localctx = new AppDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(IDENTIFIER);
			setState(107);
			match(EQUAL);
			setState(108);
			match(IDENTIFIER);
			setState(109);
			match(LPAREN);
			setState(110);
			match(DUNDER_NAME);
			setState(111);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalAssignmentContext extends ParserRuleContext {
		public GlobalAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalAssignment; }
	 
		public GlobalAssignmentContext() { }
		public void copyFrom(GlobalAssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GlobalListDefContext extends GlobalAssignmentContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public TerminalNode LSQBRACKET() { return getToken(FlaskParser.LSQBRACKET, 0); }
		public List<DictLiteralContext> dictLiteral() {
			return getRuleContexts(DictLiteralContext.class);
		}
		public DictLiteralContext dictLiteral(int i) {
			return getRuleContext(DictLiteralContext.class,i);
		}
		public TerminalNode RSQBRACKET() { return getToken(FlaskParser.RSQBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskParser.COMMA, i);
		}
		public GlobalListDefContext(GlobalAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterGlobalListDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitGlobalListDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitGlobalListDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalAssignmentContext globalAssignment() throws RecognitionException {
		GlobalAssignmentContext _localctx = new GlobalAssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_globalAssignment);
		int _la;
		try {
			_localctx = new GlobalListDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(IDENTIFIER);
			setState(114);
			match(EQUAL);
			setState(115);
			match(LSQBRACKET);
			setState(116);
			dictLiteral();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(117);
				match(COMMA);
				setState(118);
				dictLiteral();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(RSQBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DictLiteralContext extends ParserRuleContext {
		public DictLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictLiteral; }
	 
		public DictLiteralContext() { }
		public void copyFrom(DictLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DictDefContext extends DictLiteralContext {
		public TerminalNode LCURLEBRACE() { return getToken(FlaskParser.LCURLEBRACE, 0); }
		public TerminalNode RCURLEBRACE() { return getToken(FlaskParser.RCURLEBRACE, 0); }
		public List<DictEntryContext> dictEntry() {
			return getRuleContexts(DictEntryContext.class);
		}
		public DictEntryContext dictEntry(int i) {
			return getRuleContext(DictEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskParser.COMMA, i);
		}
		public DictDefContext(DictLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterDictDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitDictDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitDictDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictLiteralContext dictLiteral() throws RecognitionException {
		DictLiteralContext _localctx = new DictLiteralContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dictLiteral);
		int _la;
		try {
			_localctx = new DictDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(LCURLEBRACE);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(127);
				dictEntry();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128);
					match(COMMA);
					setState(129);
					dictEntry();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(137);
			match(RCURLEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DictEntryContext extends ParserRuleContext {
		public DictEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictEntry; }
	 
		public DictEntryContext() { }
		public void copyFrom(DictEntryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DictEntryDefContext extends DictEntryContext {
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(FlaskParser.COLON, 0); }
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public DictEntryDefContext(DictEntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterDictEntryDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitDictEntryDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitDictEntryDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictEntryContext dictEntry() throws RecognitionException {
		DictEntryContext _localctx = new DictEntryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dictEntry);
		try {
			_localctx = new DictEntryDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(STRING);
			setState(140);
			match(COLON);
			setState(141);
			pyExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteDefinitionContext extends ParserRuleContext {
		public RouteDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeDefinition; }
	 
		public RouteDefinitionContext() { }
		public void copyFrom(RouteDefinitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RouteDefContext extends RouteDefinitionContext {
		public RouteDecoratorContext routeDecorator() {
			return getRuleContext(RouteDecoratorContext.class,0);
		}
		public TerminalNode DEF() { return getToken(FlaskParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(FlaskParser.COLON, 0); }
		public RouteBodyContext routeBody() {
			return getRuleContext(RouteBodyContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public RouteDefContext(RouteDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterRouteDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitRouteDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitRouteDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteDefinitionContext routeDefinition() throws RecognitionException {
		RouteDefinitionContext _localctx = new RouteDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_routeDefinition);
		int _la;
		try {
			_localctx = new RouteDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			routeDecorator();
			setState(144);
			match(DEF);
			setState(145);
			match(IDENTIFIER);
			setState(146);
			match(LPAREN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(147);
				parameterList();
				}
			}

			setState(150);
			match(RPAREN);
			setState(151);
			match(COLON);
			setState(152);
			routeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteDecoratorContext extends ParserRuleContext {
		public RouteDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeDecorator; }
	 
		public RouteDecoratorContext() { }
		public void copyFrom(RouteDecoratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RouteDecoratorDefContext extends RouteDecoratorContext {
		public TerminalNode APP_ROUTE() { return getToken(FlaskParser.APP_ROUTE, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskParser.LPAREN, 0); }
		public List<TerminalNode> STRING() { return getTokens(FlaskParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FlaskParser.STRING, i);
		}
		public TerminalNode RPAREN() { return getToken(FlaskParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskParser.COMMA, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public TerminalNode LSQBRACKET() { return getToken(FlaskParser.LSQBRACKET, 0); }
		public TerminalNode RSQBRACKET() { return getToken(FlaskParser.RSQBRACKET, 0); }
		public RouteDecoratorDefContext(RouteDecoratorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterRouteDecoratorDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitRouteDecoratorDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitRouteDecoratorDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteDecoratorContext routeDecorator() throws RecognitionException {
		RouteDecoratorContext _localctx = new RouteDecoratorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_routeDecorator);
		int _la;
		try {
			_localctx = new RouteDecoratorDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(APP_ROUTE);
			setState(155);
			match(LPAREN);
			setState(156);
			match(STRING);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(157);
				match(COMMA);
				setState(158);
				match(IDENTIFIER);
				setState(159);
				match(EQUAL);
				setState(160);
				match(LSQBRACKET);
				setState(161);
				match(STRING);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(162);
					match(COMMA);
					setState(163);
					match(STRING);
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169);
				match(RSQBRACKET);
				}
			}

			setState(172);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	 
		public ParameterListContext() { }
		public void copyFrom(ParameterListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParameterListContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FlaskParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FlaskParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskParser.COMMA, i);
		}
		public ParamListContext(ParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterList);
		int _la;
		try {
			_localctx = new ParamListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(IDENTIFIER);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(175);
				match(COMMA);
				setState(176);
				match(IDENTIFIER);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RouteBodyContext extends ParserRuleContext {
		public RouteBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeBody; }
	 
		public RouteBodyContext() { }
		public void copyFrom(RouteBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RouteBodyContentContext extends RouteBodyContext {
		public List<BodyStatementContext> bodyStatement() {
			return getRuleContexts(BodyStatementContext.class);
		}
		public BodyStatementContext bodyStatement(int i) {
			return getRuleContext(BodyStatementContext.class,i);
		}
		public RouteBodyContentContext(RouteBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterRouteBodyContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitRouteBodyContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitRouteBodyContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteBodyContext routeBody() throws RecognitionException {
		RouteBodyContext _localctx = new RouteBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_routeBody);
		try {
			int _alt;
			_localctx = new RouteBodyContentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					bodyStatement();
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyStatementContext extends ParserRuleContext {
		public BodyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyStatement; }
	 
		public BodyStatementContext() { }
		public void copyFrom(BodyStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodyExpressionStatementContext extends BodyStatementContext {
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public BodyExpressionStatementContext(BodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterBodyExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitBodyExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitBodyExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodyReturnStatementContext extends BodyStatementContext {
		public TerminalNode RETURN() { return getToken(FlaskParser.RETURN, 0); }
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public BodyReturnStatementContext(BodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterBodyReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitBodyReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitBodyReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodyTemplateAssignmentContext extends BodyStatementContext {
		public TerminalNode TEMPLATE_KW() { return getToken(FlaskParser.TEMPLATE_KW, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public TerminalNode TRIPLE_QUOTE_STRING() { return getToken(FlaskParser.TRIPLE_QUOTE_STRING, 0); }
		public BodyTemplateAssignmentContext(BodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterBodyTemplateAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitBodyTemplateAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitBodyTemplateAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodyIfBlockContext extends BodyStatementContext {
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public BodyIfBlockContext(BodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterBodyIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitBodyIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitBodyIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodyVarAssignmentContext extends BodyStatementContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public BodyVarAssignmentContext(BodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterBodyVarAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitBodyVarAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitBodyVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyStatementContext bodyStatement() throws RecognitionException {
		BodyStatementContext _localctx = new BodyStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bodyStatement);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new BodyIfBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				ifBlock();
				}
				break;
			case 2:
				_localctx = new BodyTemplateAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(TEMPLATE_KW);
				setState(190);
				match(EQUAL);
				setState(191);
				match(TRIPLE_QUOTE_STRING);
				}
				break;
			case 3:
				_localctx = new BodyReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(RETURN);
				setState(193);
				pyExpression();
				}
				break;
			case 4:
				_localctx = new BodyVarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				match(IDENTIFIER);
				setState(195);
				match(EQUAL);
				setState(196);
				pyExpression();
				}
				break;
			case 5:
				_localctx = new BodyExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				pyExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockContext extends ParserRuleContext {
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
	 
		public IfBlockContext() { }
		public void copyFrom(IfBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockDefContext extends IfBlockContext {
		public TerminalNode IF() { return getToken(FlaskParser.IF, 0); }
		public List<PyExpressionContext> pyExpression() {
			return getRuleContexts(PyExpressionContext.class);
		}
		public PyExpressionContext pyExpression(int i) {
			return getRuleContext(PyExpressionContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(FlaskParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(FlaskParser.COLON, i);
		}
		public List<InnerBodyStatementContext> innerBodyStatement() {
			return getRuleContexts(InnerBodyStatementContext.class);
		}
		public InnerBodyStatementContext innerBodyStatement(int i) {
			return getRuleContext(InnerBodyStatementContext.class,i);
		}
		public List<TerminalNode> RETURN() { return getTokens(FlaskParser.RETURN); }
		public TerminalNode RETURN(int i) {
			return getToken(FlaskParser.RETURN, i);
		}
		public TerminalNode ELSE() { return getToken(FlaskParser.ELSE, 0); }
		public IfBlockDefContext(IfBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterIfBlockDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitIfBlockDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitIfBlockDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifBlock);
		int _la;
		try {
			int _alt;
			_localctx = new IfBlockDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IF);
			setState(201);
			pyExpression();
			setState(202);
			match(COLON);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(203);
					innerBodyStatement();
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(209);
				match(RETURN);
				setState(210);
				pyExpression();
				}
				break;
			}
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(213);
				match(ELSE);
				setState(214);
				match(COLON);
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(215);
						innerBodyStatement();
						}
						} 
					}
					setState(220);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(223);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(221);
					match(RETURN);
					setState(222);
					pyExpression();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InnerBodyStatementContext extends ParserRuleContext {
		public InnerBodyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerBodyStatement; }
	 
		public InnerBodyStatementContext() { }
		public void copyFrom(InnerBodyStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InnerBodyTemplateAssignmentContext extends InnerBodyStatementContext {
		public TerminalNode TEMPLATE_KW() { return getToken(FlaskParser.TEMPLATE_KW, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public TerminalNode TRIPLE_QUOTE_STRING() { return getToken(FlaskParser.TRIPLE_QUOTE_STRING, 0); }
		public InnerBodyTemplateAssignmentContext(InnerBodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterInnerBodyTemplateAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitInnerBodyTemplateAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitInnerBodyTemplateAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InnerBodyVarAssignmentContext extends InnerBodyStatementContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public InnerBodyVarAssignmentContext(InnerBodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterInnerBodyVarAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitInnerBodyVarAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitInnerBodyVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InnerBodyExpressionStatementContext extends InnerBodyStatementContext {
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public InnerBodyExpressionStatementContext(InnerBodyStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterInnerBodyExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitInnerBodyExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitInnerBodyExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerBodyStatementContext innerBodyStatement() throws RecognitionException {
		InnerBodyStatementContext _localctx = new InnerBodyStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_innerBodyStatement);
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new InnerBodyTemplateAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(TEMPLATE_KW);
				setState(228);
				match(EQUAL);
				setState(229);
				match(TRIPLE_QUOTE_STRING);
				}
				break;
			case 2:
				_localctx = new InnerBodyVarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(IDENTIFIER);
				setState(231);
				match(EQUAL);
				setState(232);
				pyExpression();
				}
				break;
			case 3:
				_localctx = new InnerBodyExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				pyExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainGuardContext extends ParserRuleContext {
		public MainGuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainGuard; }
	 
		public MainGuardContext() { }
		public void copyFrom(MainGuardContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MainGuardDefContext extends MainGuardContext {
		public TerminalNode IF() { return getToken(FlaskParser.IF, 0); }
		public TerminalNode DUNDER_NAME() { return getToken(FlaskParser.DUNDER_NAME, 0); }
		public TerminalNode EQEQ() { return getToken(FlaskParser.EQEQ, 0); }
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(FlaskParser.COLON, 0); }
		public PyExpressionContext pyExpression() {
			return getRuleContext(PyExpressionContext.class,0);
		}
		public MainGuardDefContext(MainGuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterMainGuardDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitMainGuardDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitMainGuardDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainGuardContext mainGuard() throws RecognitionException {
		MainGuardContext _localctx = new MainGuardContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mainGuard);
		try {
			_localctx = new MainGuardDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(IF);
			setState(237);
			match(DUNDER_NAME);
			setState(238);
			match(EQEQ);
			setState(239);
			match(STRING);
			setState(240);
			match(COLON);
			setState(241);
			pyExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PyExpressionContext extends ParserRuleContext {
		public List<PyAtomContext> pyAtom() {
			return getRuleContexts(PyAtomContext.class);
		}
		public PyAtomContext pyAtom(int i) {
			return getRuleContext(PyAtomContext.class,i);
		}
		public List<PyOpContext> pyOp() {
			return getRuleContexts(PyOpContext.class);
		}
		public PyOpContext pyOp(int i) {
			return getRuleContext(PyOpContext.class,i);
		}
		public PyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterPyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitPyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitPyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyExpressionContext pyExpression() throws RecognitionException {
		PyExpressionContext _localctx = new PyExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pyExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			pyAtom();
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(244);
					pyOp();
					setState(245);
					pyAtom();
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PyAtomContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(FlaskParser.NOT, 0); }
		public PyAtomContext pyAtom() {
			return getRuleContext(PyAtomContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(FlaskParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FlaskParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(FlaskParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskParser.RPAREN, 0); }
		public PyInnerContext pyInner() {
			return getRuleContext(PyInnerContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FlaskParser.DOT, 0); }
		public TerminalNode LSQBRACKET() { return getToken(FlaskParser.LSQBRACKET, 0); }
		public TerminalNode RSQBRACKET() { return getToken(FlaskParser.RSQBRACKET, 0); }
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public TerminalNode TRIPLE_QUOTE_STRING() { return getToken(FlaskParser.TRIPLE_QUOTE_STRING, 0); }
		public TerminalNode NUMBER() { return getToken(FlaskParser.NUMBER, 0); }
		public TerminalNode NONE() { return getToken(FlaskParser.NONE, 0); }
		public TerminalNode NULL() { return getToken(FlaskParser.NULL, 0); }
		public TerminalNode TRUE() { return getToken(FlaskParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FlaskParser.FALSE, 0); }
		public TerminalNode LCURLEBRACE() { return getToken(FlaskParser.LCURLEBRACE, 0); }
		public TerminalNode RCURLEBRACE() { return getToken(FlaskParser.RCURLEBRACE, 0); }
		public PyAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterPyAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitPyAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitPyAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyAtomContext pyAtom() throws RecognitionException {
		PyAtomContext _localctx = new PyAtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pyAtom);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(NOT);
				setState(253);
				pyAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(IDENTIFIER);
				setState(255);
				match(LPAREN);
				setState(257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(256);
					pyInner();
					}
					break;
				}
				setState(259);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				match(IDENTIFIER);
				setState(261);
				match(DOT);
				setState(262);
				match(IDENTIFIER);
				setState(263);
				match(LPAREN);
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(264);
					pyInner();
					}
					break;
				}
				setState(267);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(268);
				match(IDENTIFIER);
				setState(269);
				match(DOT);
				setState(270);
				match(IDENTIFIER);
				setState(271);
				match(LSQBRACKET);
				setState(272);
				pyInner();
				setState(273);
				match(RSQBRACKET);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(275);
				match(IDENTIFIER);
				setState(276);
				match(DOT);
				setState(277);
				match(IDENTIFIER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(278);
				match(IDENTIFIER);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(279);
				match(STRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(280);
				match(TRIPLE_QUOTE_STRING);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(281);
				match(NUMBER);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(282);
				match(NONE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(283);
				match(NULL);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(284);
				match(TRUE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(285);
				match(FALSE);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(286);
				match(LPAREN);
				setState(288);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(287);
					pyInner();
					}
					break;
				}
				setState(290);
				match(RPAREN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(291);
				match(LSQBRACKET);
				setState(293);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(292);
					pyInner();
					}
					break;
				}
				setState(295);
				match(RSQBRACKET);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(296);
				match(LCURLEBRACE);
				setState(298);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(297);
					pyInner();
					}
					break;
				}
				setState(300);
				match(RCURLEBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PyOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(FlaskParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FlaskParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(FlaskParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(FlaskParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(FlaskParser.PERCENT, 0); }
		public TerminalNode EQEQ() { return getToken(FlaskParser.EQEQ, 0); }
		public TerminalNode NOTEQ() { return getToken(FlaskParser.NOTEQ, 0); }
		public TerminalNode LTE() { return getToken(FlaskParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(FlaskParser.GTE, 0); }
		public TerminalNode LT() { return getToken(FlaskParser.LT, 0); }
		public TerminalNode GT() { return getToken(FlaskParser.GT, 0); }
		public TerminalNode AND() { return getToken(FlaskParser.AND, 0); }
		public TerminalNode OR() { return getToken(FlaskParser.OR, 0); }
		public TerminalNode IS() { return getToken(FlaskParser.IS, 0); }
		public TerminalNode IN() { return getToken(FlaskParser.IN, 0); }
		public TerminalNode NOT() { return getToken(FlaskParser.NOT, 0); }
		public TerminalNode COMMA() { return getToken(FlaskParser.COMMA, 0); }
		public PyOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterPyOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitPyOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitPyOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyOpContext pyOp() throws RecognitionException {
		PyOpContext _localctx = new PyOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pyOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_la = _input.LA(1);
			if ( !(((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 2113132500486017L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PyInnerContext extends ParserRuleContext {
		public List<TerminalNode> LPAREN() { return getTokens(FlaskParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(FlaskParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(FlaskParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(FlaskParser.RPAREN, i);
		}
		public List<TerminalNode> LSQBRACKET() { return getTokens(FlaskParser.LSQBRACKET); }
		public TerminalNode LSQBRACKET(int i) {
			return getToken(FlaskParser.LSQBRACKET, i);
		}
		public List<TerminalNode> RSQBRACKET() { return getTokens(FlaskParser.RSQBRACKET); }
		public TerminalNode RSQBRACKET(int i) {
			return getToken(FlaskParser.RSQBRACKET, i);
		}
		public List<TerminalNode> LCURLEBRACE() { return getTokens(FlaskParser.LCURLEBRACE); }
		public TerminalNode LCURLEBRACE(int i) {
			return getToken(FlaskParser.LCURLEBRACE, i);
		}
		public List<TerminalNode> RCURLEBRACE() { return getTokens(FlaskParser.RCURLEBRACE); }
		public TerminalNode RCURLEBRACE(int i) {
			return getToken(FlaskParser.RCURLEBRACE, i);
		}
		public List<PyInnerContext> pyInner() {
			return getRuleContexts(PyInnerContext.class);
		}
		public PyInnerContext pyInner(int i) {
			return getRuleContext(PyInnerContext.class,i);
		}
		public PyInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyInner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterPyInner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitPyInner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitPyInner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyInnerContext pyInner() throws RecognitionException {
		PyInnerContext _localctx = new PyInnerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pyInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -46179488366594L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1023L) != 0)) {
				{
				setState(321);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case APP_ROUTE:
				case DEF:
				case RETURN:
				case FROM:
				case IMPORT:
				case CLASS:
				case TEMPLATE_KW:
				case STYLES:
				case IF:
				case ELIF:
				case ELSE:
				case ENDIF:
				case FOR:
				case IN:
				case ENDFOR:
				case BLOCK:
				case ENDBLOCK:
				case EXTENDS:
				case INCLUDE:
				case SET:
				case NOT:
				case AND:
				case OR:
				case IS:
				case TRUE:
				case FALSE:
				case NONE:
				case NULL:
				case SELF_CLOSE:
				case CLOSE_TAG:
				case LT:
				case GT:
				case SLASH:
				case BLOCK_START:
				case BLOCK_END:
				case COMMENT_START:
				case COMMENT_END:
				case TEMPLATE_EXPRESSION:
				case TRIPLE_QUOTE_STRING:
				case COLON:
				case COMMA:
				case DOT:
				case SEMICOLON:
				case PIPE:
				case STAR:
				case PLUS:
				case MINUS:
				case PERCENT:
				case TILDE:
				case QUESTION_MARK:
				case AT:
				case HASH:
				case EQUAL:
				case BACKTICK:
				case EQEQ:
				case NOTEQ:
				case LTE:
				case GTE:
				case CSS_CUSTOM_PROPERTY:
				case DUNDER_NAME:
				case IDENTIFIER:
				case STRING:
				case NUMBER:
				case PY_COMMENT:
				case WS:
				case LINE_COMMENT:
				case BLOCK_COMMENT:
					{
					setState(305);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69269232549888L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case LPAREN:
					{
					setState(306);
					match(LPAREN);
					setState(308);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(307);
						pyInner();
						}
						break;
					}
					setState(310);
					match(RPAREN);
					}
					break;
				case LSQBRACKET:
					{
					setState(311);
					match(LSQBRACKET);
					setState(313);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(312);
						pyInner();
						}
						break;
					}
					setState(315);
					match(RSQBRACKET);
					}
					break;
				case LCURLEBRACE:
					{
					setState(316);
					match(LCURLEBRACE);
					setState(318);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						setState(317);
						pyInner();
						}
						break;
					}
					setState(320);
					match(RCURLEBRACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullLiteralContext extends LiteralContext {
		public TerminalNode NULL() { return getToken(FlaskParser.NULL, 0); }
		public NullLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneLiteralContext extends LiteralContext {
		public TerminalNode NONE() { return getToken(FlaskParser.NONE, 0); }
		public NoneLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterNoneLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitNoneLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitNoneLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralContext extends LiteralContext {
		public TerminalNode FALSE() { return getToken(FlaskParser.FALSE, 0); }
		public FalseLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralContext extends LiteralContext {
		public TerminalNode TRUE() { return getToken(FlaskParser.TRUE, 0); }
		public TrueLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(FlaskParser.NUMBER, 0); }
		public NumberLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
				_localctx = new NoneLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				match(NONE);
				}
				break;
			case NULL:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				match(NULL);
				}
				break;
			case TRUE:
				_localctx = new TrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(328);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				match(FALSE);
				}
				break;
			case STRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(331);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContext extends ParserRuleContext {
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
	 
		public HtmlDocumentContext() { }
		public void copyFrom(HtmlDocumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContentContext extends HtmlDocumentContext {
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public HtmlDocumentContentContext(HtmlDocumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlDocumentContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlDocumentContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlDocumentContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_htmlDocument);
		int _la;
		try {
			_localctx = new HtmlDocumentContentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LT) {
				{
				{
				setState(334);
				htmlElement();
				}
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlStandardElementContext extends HtmlElementContext {
		public StartTagContext startTag() {
			return getRuleContext(StartTagContext.class,0);
		}
		public EndTagContext endTag() {
			return getRuleContext(EndTagContext.class,0);
		}
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public HtmlStandardElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlStandardElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlStandardElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlStandardElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSelfClosingElementContext extends HtmlElementContext {
		public SelfClosingTagContext selfClosingTag() {
			return getRuleContext(SelfClosingTagContext.class,0);
		}
		public HtmlSelfClosingElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlSelfClosingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlSelfClosingElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_htmlElement);
		int _la;
		try {
			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new HtmlStandardElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				startTag();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 31)) & ~0x3f) == 0 && ((1L << (_la - 31)) & 481572323469L) != 0)) {
					{
					{
					setState(341);
					htmlContent();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(347);
				endTag();
				}
				break;
			case 2:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				selfClosingTag();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartTagContext extends ParserRuleContext {
		public StartTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTag; }
	 
		public StartTagContext() { }
		public void copyFrom(StartTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlStartTagContext extends StartTagContext {
		public TerminalNode LT() { return getToken(FlaskParser.LT, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode GT() { return getToken(FlaskParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public HtmlStartTagContext(StartTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlStartTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlStartTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlStartTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartTagContext startTag() throws RecognitionException {
		StartTagContext _localctx = new StartTagContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_startTag);
		int _la;
		try {
			_localctx = new HtmlStartTagContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(LT);
			setState(353);
			tagName();
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS || _la==IDENTIFIER) {
				{
				{
				setState(354);
				attribute();
				}
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(360);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndTagContext extends ParserRuleContext {
		public EndTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endTag; }
	 
		public EndTagContext() { }
		public void copyFrom(EndTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlEndTagContext extends EndTagContext {
		public TerminalNode CLOSE_TAG() { return getToken(FlaskParser.CLOSE_TAG, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode GT() { return getToken(FlaskParser.GT, 0); }
		public HtmlEndTagContext(EndTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlEndTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlEndTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlEndTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndTagContext endTag() throws RecognitionException {
		EndTagContext _localctx = new EndTagContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_endTag);
		try {
			_localctx = new HtmlEndTagContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(CLOSE_TAG);
			setState(363);
			tagName();
			setState(364);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagContext extends ParserRuleContext {
		public SelfClosingTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfClosingTag; }
	 
		public SelfClosingTagContext() { }
		public void copyFrom(SelfClosingTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSelfClosingTagContext extends SelfClosingTagContext {
		public TerminalNode LT() { return getToken(FlaskParser.LT, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode SELF_CLOSE() { return getToken(FlaskParser.SELF_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public HtmlSelfClosingTagContext(SelfClosingTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlSelfClosingTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlSelfClosingTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlSelfClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfClosingTagContext selfClosingTag() throws RecognitionException {
		SelfClosingTagContext _localctx = new SelfClosingTagContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_selfClosingTag);
		int _la;
		try {
			_localctx = new HtmlSelfClosingTagContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(LT);
			setState(367);
			tagName();
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS || _la==IDENTIFIER) {
				{
				{
				setState(368);
				attribute();
				}
				}
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			match(SELF_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ParserRuleContext {
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
	 
		public HtmlContentContext() { }
		public void copyFrom(HtmlContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlNestedElementContext extends HtmlContentContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlNestedElementContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlNestedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlNestedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlNestedElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlJinja2BlockContext extends HtmlContentContext {
		public Jinja2BlockContext jinja2Block() {
			return getRuleContext(Jinja2BlockContext.class,0);
		}
		public HtmlJinja2BlockContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlJinja2Block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlJinja2Block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlJinja2Block(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTemplateExpressionContext extends HtmlContentContext {
		public TerminalNode TEMPLATE_EXPRESSION() { return getToken(FlaskParser.TEMPLATE_EXPRESSION, 0); }
		public HtmlTemplateExpressionContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlTemplateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlTemplateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlTemplateExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContentContext extends HtmlContentContext {
		public List<TextTokenContext> textToken() {
			return getRuleContexts(TextTokenContext.class);
		}
		public TextTokenContext textToken(int i) {
			return getRuleContext(TextTokenContext.class,i);
		}
		public HtmlTextContentContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlTextContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlTextContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_htmlContent);
		try {
			int _alt;
			setState(384);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				_localctx = new HtmlNestedElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				htmlElement();
				}
				break;
			case TEMPLATE_EXPRESSION:
				_localctx = new HtmlTemplateExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				match(TEMPLATE_EXPRESSION);
				}
				break;
			case BLOCK_START:
				_localctx = new HtmlJinja2BlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				jinja2Block();
				}
				break;
			case SLASH:
			case COLON:
			case DOT:
			case STAR:
			case PLUS:
			case MINUS:
			case PERCENT:
			case TILDE:
			case QUESTION_MARK:
			case AT:
			case HASH:
			case EQUAL:
			case IDENTIFIER:
			case STRING:
			case NUMBER:
				_localctx = new HtmlTextContentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(380); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(379);
						textToken();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(382); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextTokenContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(FlaskParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(FlaskParser.COLON, 0); }
		public TerminalNode DOT() { return getToken(FlaskParser.DOT, 0); }
		public TerminalNode MINUS() { return getToken(FlaskParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(FlaskParser.PLUS, 0); }
		public TerminalNode SLASH() { return getToken(FlaskParser.SLASH, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public TerminalNode PERCENT() { return getToken(FlaskParser.PERCENT, 0); }
		public TerminalNode STAR() { return getToken(FlaskParser.STAR, 0); }
		public TerminalNode HASH() { return getToken(FlaskParser.HASH, 0); }
		public TerminalNode AT() { return getToken(FlaskParser.AT, 0); }
		public TerminalNode QUESTION_MARK() { return getToken(FlaskParser.QUESTION_MARK, 0); }
		public TerminalNode TILDE() { return getToken(FlaskParser.TILDE, 0); }
		public TextTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterTextToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitTextToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitTextToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextTokenContext textToken() throws RecognitionException {
		TextTokenContext _localctx = new TextTokenContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_textToken);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !(((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & 120393080833L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2BlockContext extends ParserRuleContext {
		public Jinja2BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinja2Block; }
	 
		public Jinja2BlockContext() { }
		public void copyFrom(Jinja2BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2BlockTagContext extends Jinja2BlockContext {
		public List<TerminalNode> BLOCK_START() { return getTokens(FlaskParser.BLOCK_START); }
		public TerminalNode BLOCK_START(int i) {
			return getToken(FlaskParser.BLOCK_START, i);
		}
		public TerminalNode BLOCK() { return getToken(FlaskParser.BLOCK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public List<TerminalNode> BLOCK_END() { return getTokens(FlaskParser.BLOCK_END); }
		public TerminalNode BLOCK_END(int i) {
			return getToken(FlaskParser.BLOCK_END, i);
		}
		public TerminalNode ENDBLOCK() { return getToken(FlaskParser.ENDBLOCK, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public Jinja2BlockTagContext(Jinja2BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterJinja2BlockTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitJinja2BlockTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitJinja2BlockTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2SetTagContext extends Jinja2BlockContext {
		public TerminalNode BLOCK_START() { return getToken(FlaskParser.BLOCK_START, 0); }
		public TerminalNode SET() { return getToken(FlaskParser.SET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BLOCK_END() { return getToken(FlaskParser.BLOCK_END, 0); }
		public Jinja2SetTagContext(Jinja2BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterJinja2SetTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitJinja2SetTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitJinja2SetTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2ExtendsTagContext extends Jinja2BlockContext {
		public TerminalNode BLOCK_START() { return getToken(FlaskParser.BLOCK_START, 0); }
		public TerminalNode EXTENDS() { return getToken(FlaskParser.EXTENDS, 0); }
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public TerminalNode BLOCK_END() { return getToken(FlaskParser.BLOCK_END, 0); }
		public Jinja2ExtendsTagContext(Jinja2BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterJinja2ExtendsTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitJinja2ExtendsTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitJinja2ExtendsTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2IfBlockContext extends Jinja2BlockContext {
		public List<TerminalNode> BLOCK_START() { return getTokens(FlaskParser.BLOCK_START); }
		public TerminalNode BLOCK_START(int i) {
			return getToken(FlaskParser.BLOCK_START, i);
		}
		public TerminalNode IF() { return getToken(FlaskParser.IF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> BLOCK_END() { return getTokens(FlaskParser.BLOCK_END); }
		public TerminalNode BLOCK_END(int i) {
			return getToken(FlaskParser.BLOCK_END, i);
		}
		public TerminalNode ENDIF() { return getToken(FlaskParser.ENDIF, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(FlaskParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(FlaskParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(FlaskParser.ELSE, 0); }
		public Jinja2IfBlockContext(Jinja2BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterJinja2IfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitJinja2IfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitJinja2IfBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2IncludeTagContext extends Jinja2BlockContext {
		public TerminalNode BLOCK_START() { return getToken(FlaskParser.BLOCK_START, 0); }
		public TerminalNode INCLUDE() { return getToken(FlaskParser.INCLUDE, 0); }
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public TerminalNode BLOCK_END() { return getToken(FlaskParser.BLOCK_END, 0); }
		public Jinja2IncludeTagContext(Jinja2BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterJinja2IncludeTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitJinja2IncludeTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitJinja2IncludeTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2ForBlockContext extends Jinja2BlockContext {
		public List<TerminalNode> BLOCK_START() { return getTokens(FlaskParser.BLOCK_START); }
		public TerminalNode BLOCK_START(int i) {
			return getToken(FlaskParser.BLOCK_START, i);
		}
		public TerminalNode FOR() { return getToken(FlaskParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(FlaskParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> BLOCK_END() { return getTokens(FlaskParser.BLOCK_END); }
		public TerminalNode BLOCK_END(int i) {
			return getToken(FlaskParser.BLOCK_END, i);
		}
		public TerminalNode ENDFOR() { return getToken(FlaskParser.ENDFOR, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public Jinja2ForBlockContext(Jinja2BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterJinja2ForBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitJinja2ForBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitJinja2ForBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jinja2BlockContext jinja2Block() throws RecognitionException {
		Jinja2BlockContext _localctx = new Jinja2BlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_jinja2Block);
		try {
			int _alt;
			setState(472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new Jinja2IfBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(BLOCK_START);
				setState(389);
				match(IF);
				setState(390);
				expression(0);
				setState(391);
				match(BLOCK_END);
				setState(395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(392);
						htmlContent();
						}
						} 
					}
					setState(397);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(398);
						match(BLOCK_START);
						setState(399);
						match(ELIF);
						setState(400);
						expression(0);
						setState(401);
						match(BLOCK_END);
						setState(405);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(402);
								htmlContent();
								}
								} 
							}
							setState(407);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
						}
						}
						} 
					}
					setState(412);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				}
				setState(422);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(413);
					match(BLOCK_START);
					setState(414);
					match(ELSE);
					setState(415);
					match(BLOCK_END);
					setState(419);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(416);
							htmlContent();
							}
							} 
						}
						setState(421);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					}
					}
					break;
				}
				setState(424);
				match(BLOCK_START);
				setState(425);
				match(ENDIF);
				setState(426);
				match(BLOCK_END);
				}
				break;
			case 2:
				_localctx = new Jinja2ForBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(428);
				match(BLOCK_START);
				setState(429);
				match(FOR);
				setState(430);
				match(IDENTIFIER);
				setState(431);
				match(IN);
				setState(432);
				expression(0);
				setState(433);
				match(BLOCK_END);
				setState(437);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(434);
						htmlContent();
						}
						} 
					}
					setState(439);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(440);
				match(BLOCK_START);
				setState(441);
				match(ENDFOR);
				setState(442);
				match(BLOCK_END);
				}
				break;
			case 3:
				_localctx = new Jinja2BlockTagContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(444);
				match(BLOCK_START);
				setState(445);
				match(BLOCK);
				setState(446);
				match(IDENTIFIER);
				setState(447);
				match(BLOCK_END);
				setState(451);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(448);
						htmlContent();
						}
						} 
					}
					setState(453);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				setState(454);
				match(BLOCK_START);
				setState(455);
				match(ENDBLOCK);
				setState(456);
				match(BLOCK_END);
				}
				break;
			case 4:
				_localctx = new Jinja2ExtendsTagContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(457);
				match(BLOCK_START);
				setState(458);
				match(EXTENDS);
				setState(459);
				match(STRING);
				setState(460);
				match(BLOCK_END);
				}
				break;
			case 5:
				_localctx = new Jinja2IncludeTagContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(461);
				match(BLOCK_START);
				setState(462);
				match(INCLUDE);
				setState(463);
				match(STRING);
				setState(464);
				match(BLOCK_END);
				}
				break;
			case 6:
				_localctx = new Jinja2SetTagContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(465);
				match(BLOCK_START);
				setState(466);
				match(SET);
				setState(467);
				match(IDENTIFIER);
				setState(468);
				match(EQUAL);
				setState(469);
				expression(0);
				setState(470);
				match(BLOCK_END);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
	 
		public TagNameContext() { }
		public void copyFrom(TagNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTagNameContext extends TagNameContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public HtmlTagNameContext(TagNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tagName);
		try {
			_localctx = new HtmlTagNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeBasicContext extends AttributeContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public HtmlAttributeBasicContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlAttributeBasic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlAttributeBasic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlAttributeBasic(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeClassContext extends AttributeContext {
		public TerminalNode CLASS() { return getToken(FlaskParser.CLASS, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public HtmlAttributeClassContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlAttributeClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlAttributeClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlAttributeClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_attribute);
		try {
			setState(482);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new HtmlAttributeBasicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				match(IDENTIFIER);
				setState(477);
				match(EQUAL);
				setState(478);
				attributeValue();
				}
				break;
			case CLASS:
				_localctx = new HtmlAttributeClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(479);
				match(CLASS);
				setState(480);
				match(EQUAL);
				setState(481);
				attributeValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeValueContext extends ParserRuleContext {
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
	 
		public AttributeValueContext() { }
		public void copyFrom(AttributeValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeValueContext extends AttributeValueContext {
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public HtmlAttributeValueContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterHtmlAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitHtmlAttributeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitHtmlAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_attributeValue);
		try {
			_localctx = new HtmlAttributeValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(FlaskParser.OR, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(FlaskParser.AND, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExpressionContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(FlaskParser.NUMBER, 0); }
		public NumberExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitNumberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(FlaskParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(FlaskParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQEQ() { return getToken(FlaskParser.EQEQ, 0); }
		public TerminalNode NOTEQ() { return getToken(FlaskParser.NOTEQ, 0); }
		public TerminalNode LTE() { return getToken(FlaskParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(FlaskParser.GTE, 0); }
		public TerminalNode LT() { return getToken(FlaskParser.LT, 0); }
		public TerminalNode GT() { return getToken(FlaskParser.GT, 0); }
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(487);
				match(IDENTIFIER);
				setState(488);
				match(EQUAL);
				setState(489);
				expression(8);
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(490);
				match(IDENTIFIER);
				}
				break;
			case 3:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				match(STRING);
				}
				break;
			case 4:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(492);
				match(NUMBER);
				}
				break;
			case 5:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				match(NOT);
				setState(494);
				expression(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(506);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(497);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(498);
						_la = _input.LA(1);
						if ( !(((((_la - 31)) & ~0x3f) == 0 && ((1L << (_la - 31)) & 16106127363L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(499);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(500);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(501);
						match(AND);
						setState(502);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(503);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(504);
						match(OR);
						setState(505);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssContentContext extends ParserRuleContext {
		public CssContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssContent; }
	 
		public CssContentContext() { }
		public void copyFrom(CssContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssContentRulesContext extends CssContentContext {
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public CssContentRulesContext(CssContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssContentRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssContentRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssContentRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssContentContext cssContent() throws RecognitionException {
		CssContentContext _localctx = new CssContentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_cssContent);
		int _la;
		try {
			_localctx = new CssContentRulesContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(512); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(511);
				cssRule();
				}
				}
				setState(514); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
	 
		public CssRuleContext() { }
		public void copyFrom(CssRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleDefinitionContext extends CssRuleContext {
		public CssSelectorContext cssSelector() {
			return getRuleContext(CssSelectorContext.class,0);
		}
		public TerminalNode LCURLEBRACE() { return getToken(FlaskParser.LCURLEBRACE, 0); }
		public TerminalNode RCURLEBRACE() { return getToken(FlaskParser.RCURLEBRACE, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssRuleDefinitionContext(CssRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssRuleDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssRuleDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssRuleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_cssRule);
		int _la;
		try {
			_localctx = new CssRuleDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			cssSelector();
			setState(517);
			match(LCURLEBRACE);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_CUSTOM_PROPERTY || _la==IDENTIFIER) {
				{
				{
				setState(518);
				cssDeclaration();
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(524);
			match(RCURLEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_cssSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
	 
		public CssDeclarationContext() { }
		public void copyFrom(CssDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssCustomPropertyEntryContext extends CssDeclarationContext {
		public TerminalNode CSS_CUSTOM_PROPERTY() { return getToken(FlaskParser.CSS_CUSTOM_PROPERTY, 0); }
		public TerminalNode COLON() { return getToken(FlaskParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(FlaskParser.SEMICOLON, 0); }
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public CssCustomPropertyEntryContext(CssDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssCustomPropertyEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssCustomPropertyEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssCustomPropertyEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationEntryContext extends CssDeclarationContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(FlaskParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(FlaskParser.SEMICOLON, 0); }
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public CssDeclarationEntryContext(CssDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssDeclarationEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssDeclarationEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssDeclarationEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_cssDeclaration);
		int _la;
		try {
			setState(546);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new CssDeclarationEntryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				match(IDENTIFIER);
				setState(529);
				match(COLON);
				setState(531); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(530);
					cssValue();
					}
					}
					setState(533); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0) );
				setState(535);
				match(SEMICOLON);
				}
				break;
			case CSS_CUSTOM_PROPERTY:
				_localctx = new CssCustomPropertyEntryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				match(CSS_CUSTOM_PROPERTY);
				setState(538);
				match(COLON);
				setState(540); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(539);
					cssValue();
					}
					}
					setState(542); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0) );
				setState(544);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
	 
		public CssValueContext() { }
		public void copyFrom(CssValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueStringContext extends CssValueContext {
		public TerminalNode STRING() { return getToken(FlaskParser.STRING, 0); }
		public CssValueStringContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssValueString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssValueString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssValueString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueDimensionContext extends CssValueContext {
		public TerminalNode NUMBER() { return getToken(FlaskParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public CssValueDimensionContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssValueDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssValueDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssValueDimension(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueNumberContext extends CssValueContext {
		public TerminalNode NUMBER() { return getToken(FlaskParser.NUMBER, 0); }
		public CssValueNumberContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssValueNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssValueNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssValueNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueAlphabetContext extends CssValueContext {
		public TerminalNode IDENTIFIER() { return getToken(FlaskParser.IDENTIFIER, 0); }
		public CssValueAlphabetContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).enterCssValueAlphabet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FlaskParserListener ) ((FlaskParserListener)listener).exitCssValueAlphabet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FlaskParserVisitor ) return ((FlaskParserVisitor<? extends T>)visitor).visitCssValueAlphabet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_cssValue);
		try {
			setState(553);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new CssValueStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				match(STRING);
				}
				break;
			case 2:
				_localctx = new CssValueDimensionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				match(NUMBER);
				setState(550);
				match(IDENTIFIER);
				}
				break;
			case 3:
				_localctx = new CssValueNumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(551);
				match(NUMBER);
				}
				break;
			case 4:
				_localctx = new CssValueAlphabetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(552);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001I\u022c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0001\u0000\u0005\u0000J\b\u0000\n\u0000\f\u0000M\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000Q\b\u0000\n\u0000\f\u0000T\t\u0000\u0001"+
		"\u0000\u0004\u0000W\b\u0000\u000b\u0000\f\u0000X\u0001\u0000\u0003\u0000"+
		"\\\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001f\b\u0001\n\u0001\f\u0001"+
		"i\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003x\b\u0003\n\u0003\f\u0003{\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u0083\b\u0004\n\u0004\f\u0004\u0086\t\u0004\u0003\u0004\u0088"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u0095\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a5\b\u0007\n"+
		"\u0007\f\u0007\u00a8\t\u0007\u0001\u0007\u0003\u0007\u00ab\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00b2\b\b\n\b\f\b\u00b5"+
		"\t\b\u0001\t\u0005\t\u00b8\b\t\n\t\f\t\u00bb\t\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c7"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00cd"+
		"\b\u000b\n\u000b\f\u000b\u00d0\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00d4\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d9\b"+
		"\u000b\n\u000b\f\u000b\u00dc\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00e0\b\u000b\u0003\u000b\u00e2\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00eb\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00f8\b\u000e\n\u000e\f\u000e\u00fb\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0102\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u010a\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0121"+
		"\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0126\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u012b\b\u000f\u0001\u000f"+
		"\u0003\u000f\u012e\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0135\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u013a\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u013f\b\u0011\u0001\u0011\u0005\u0011\u0142\b\u0011\n\u0011\f\u0011\u0145"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u014d\b\u0012\u0001\u0013\u0005\u0013\u0150\b\u0013"+
		"\n\u0013\f\u0013\u0153\t\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u0157"+
		"\b\u0014\n\u0014\f\u0014\u015a\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u015f\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u0164\b\u0015\n\u0015\f\u0015\u0167\t\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0172\b\u0017\n\u0017\f\u0017\u0175\t\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0004\u0018"+
		"\u017d\b\u0018\u000b\u0018\f\u0018\u017e\u0003\u0018\u0181\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u018a\b\u001a\n\u001a\f\u001a\u018d\t\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0194\b\u001a"+
		"\n\u001a\f\u001a\u0197\t\u001a\u0005\u001a\u0199\b\u001a\n\u001a\f\u001a"+
		"\u019c\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a"+
		"\u01a2\b\u001a\n\u001a\f\u001a\u01a5\t\u001a\u0003\u001a\u01a7\b\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a"+
		"\u01b4\b\u001a\n\u001a\f\u001a\u01b7\t\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u01c2\b\u001a\n\u001a\f\u001a\u01c5\t\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u01d9\b\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01e3\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01f0\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u01fb\b\u001e\n\u001e"+
		"\f\u001e\u01fe\t\u001e\u0001\u001f\u0004\u001f\u0201\b\u001f\u000b\u001f"+
		"\f\u001f\u0202\u0001 \u0001 \u0001 \u0005 \u0208\b \n \f \u020b\t \u0001"+
		" \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0004\"\u0214\b\"\u000b"+
		"\"\f\"\u0215\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0004\"\u021d\b\""+
		"\u000b\"\f\"\u021e\u0001\"\u0001\"\u0003\"\u0223\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0003#\u022a\b#\u0001#\u0000\u0001<$\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@BDF\u0000\u0004\u0006\u0000\u000e\u000e\u0015\u0018\u001f"+
		"!//36=@\u0001\u0000(-\u0005\u0000!!..003;CE\u0002\u0000\u001f =@\u0265"+
		"\u0000K\u0001\u0000\u0000\u0000\u0002_\u0001\u0000\u0000\u0000\u0004j"+
		"\u0001\u0000\u0000\u0000\u0006q\u0001\u0000\u0000\u0000\b~\u0001\u0000"+
		"\u0000\u0000\n\u008b\u0001\u0000\u0000\u0000\f\u008f\u0001\u0000\u0000"+
		"\u0000\u000e\u009a\u0001\u0000\u0000\u0000\u0010\u00ae\u0001\u0000\u0000"+
		"\u0000\u0012\u00b9\u0001\u0000\u0000\u0000\u0014\u00c6\u0001\u0000\u0000"+
		"\u0000\u0016\u00c8\u0001\u0000\u0000\u0000\u0018\u00ea\u0001\u0000\u0000"+
		"\u0000\u001a\u00ec\u0001\u0000\u0000\u0000\u001c\u00f3\u0001\u0000\u0000"+
		"\u0000\u001e\u012d\u0001\u0000\u0000\u0000 \u012f\u0001\u0000\u0000\u0000"+
		"\"\u0143\u0001\u0000\u0000\u0000$\u014c\u0001\u0000\u0000\u0000&\u0151"+
		"\u0001\u0000\u0000\u0000(\u015e\u0001\u0000\u0000\u0000*\u0160\u0001\u0000"+
		"\u0000\u0000,\u016a\u0001\u0000\u0000\u0000.\u016e\u0001\u0000\u0000\u0000"+
		"0\u0180\u0001\u0000\u0000\u00002\u0182\u0001\u0000\u0000\u00004\u01d8"+
		"\u0001\u0000\u0000\u00006\u01da\u0001\u0000\u0000\u00008\u01e2\u0001\u0000"+
		"\u0000\u0000:\u01e4\u0001\u0000\u0000\u0000<\u01ef\u0001\u0000\u0000\u0000"+
		">\u0200\u0001\u0000\u0000\u0000@\u0204\u0001\u0000\u0000\u0000B\u020e"+
		"\u0001\u0000\u0000\u0000D\u0222\u0001\u0000\u0000\u0000F\u0229\u0001\u0000"+
		"\u0000\u0000HJ\u0003\u0002\u0001\u0000IH\u0001\u0000\u0000\u0000JM\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NR\u0003\u0004\u0002"+
		"\u0000OQ\u0003\u0006\u0003\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SV\u0001"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UW\u0003\f\u0006\u0000VU\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000Z\\\u0003\u001a\r"+
		"\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]^\u0005\u0000\u0000\u0001^\u0001\u0001\u0000\u0000\u0000"+
		"_`\u0005\u0004\u0000\u0000`a\u0005C\u0000\u0000ab\u0005\u0005\u0000\u0000"+
		"bg\u0005C\u0000\u0000cd\u0005/\u0000\u0000df\u0005C\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000h\u0003\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000jk\u0005C\u0000\u0000kl\u0005;\u0000\u0000lm\u0005C\u0000"+
		"\u0000mn\u0005,\u0000\u0000no\u0005B\u0000\u0000op\u0005-\u0000\u0000"+
		"p\u0005\u0001\u0000\u0000\u0000qr\u0005C\u0000\u0000rs\u0005;\u0000\u0000"+
		"st\u0005*\u0000\u0000ty\u0003\b\u0004\u0000uv\u0005/\u0000\u0000vx\u0003"+
		"\b\u0004\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000|}\u0005+\u0000\u0000}\u0007\u0001\u0000\u0000"+
		"\u0000~\u0087\u0005(\u0000\u0000\u007f\u0084\u0003\n\u0005\u0000\u0080"+
		"\u0081\u0005/\u0000\u0000\u0081\u0083\u0003\n\u0005\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0088"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u007f"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005)\u0000\u0000\u008a\t\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005D\u0000\u0000\u008c\u008d\u0005.\u0000"+
		"\u0000\u008d\u008e\u0003\u001c\u000e\u0000\u008e\u000b\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0003\u000e\u0007\u0000\u0090\u0091\u0005\u0002\u0000"+
		"\u0000\u0091\u0092\u0005C\u0000\u0000\u0092\u0094\u0005,\u0000\u0000\u0093"+
		"\u0095\u0003\u0010\b\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0005-\u0000\u0000\u0097\u0098\u0005.\u0000\u0000\u0098\u0099\u0003\u0012"+
		"\t\u0000\u0099\r\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0001\u0000"+
		"\u0000\u009b\u009c\u0005,\u0000\u0000\u009c\u00aa\u0005D\u0000\u0000\u009d"+
		"\u009e\u0005/\u0000\u0000\u009e\u009f\u0005C\u0000\u0000\u009f\u00a0\u0005"+
		";\u0000\u0000\u00a0\u00a1\u0005*\u0000\u0000\u00a1\u00a6\u0005D\u0000"+
		"\u0000\u00a2\u00a3\u0005/\u0000\u0000\u00a3\u00a5\u0005D\u0000\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ab\u0005+\u0000\u0000\u00aa\u009d\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005-\u0000\u0000\u00ad\u000f\u0001\u0000\u0000\u0000\u00ae\u00b3\u0005"+
		"C\u0000\u0000\u00af\u00b0\u0005/\u0000\u0000\u00b0\u00b2\u0005C\u0000"+
		"\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b4\u0011\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b8\u0003\u0014\n\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u0013\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00c7\u0003\u0016\u000b\u0000"+
		"\u00bd\u00be\u0005\u0007\u0000\u0000\u00be\u00bf\u0005;\u0000\u0000\u00bf"+
		"\u00c7\u0005\'\u0000\u0000\u00c0\u00c1\u0005\u0003\u0000\u0000\u00c1\u00c7"+
		"\u0003\u001c\u000e\u0000\u00c2\u00c3\u0005C\u0000\u0000\u00c3\u00c4\u0005"+
		";\u0000\u0000\u00c4\u00c7\u0003\u001c\u000e\u0000\u00c5\u00c7\u0003\u001c"+
		"\u000e\u0000\u00c6\u00bc\u0001\u0000\u0000\u0000\u00c6\u00bd\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c0\u0001\u0000\u0000\u0000\u00c6\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u0015\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0005\t\u0000\u0000\u00c9\u00ca\u0003\u001c\u000e"+
		"\u0000\u00ca\u00ce\u0005.\u0000\u0000\u00cb\u00cd\u0003\u0018\f\u0000"+
		"\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d3\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005\u0003\u0000\u0000\u00d2\u00d4\u0003\u001c\u000e\u0000"+
		"\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u00e1\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u000b\u0000\u0000"+
		"\u00d6\u00da\u0005.\u0000\u0000\u00d7\u00d9\u0003\u0018\f\u0000\u00d8"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da"+
		"\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db"+
		"\u00df\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0005\u0003\u0000\u0000\u00de\u00e0\u0003\u001c\u000e\u0000\u00df"+
		"\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e1\u00d5\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e2\u0017\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0005\u0007\u0000\u0000\u00e4\u00e5\u0005;\u0000\u0000\u00e5\u00eb"+
		"\u0005\'\u0000\u0000\u00e6\u00e7\u0005C\u0000\u0000\u00e7\u00e8\u0005"+
		";\u0000\u0000\u00e8\u00eb\u0003\u001c\u000e\u0000\u00e9\u00eb\u0003\u001c"+
		"\u000e\u0000\u00ea\u00e3\u0001\u0000\u0000\u0000\u00ea\u00e6\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u0019\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0005\t\u0000\u0000\u00ed\u00ee\u0005B\u0000"+
		"\u0000\u00ee\u00ef\u0005=\u0000\u0000\u00ef\u00f0\u0005D\u0000\u0000\u00f0"+
		"\u00f1\u0005.\u0000\u0000\u00f1\u00f2\u0003\u001c\u000e\u0000\u00f2\u001b"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f9\u0003\u001e\u000f\u0000\u00f4\u00f5"+
		"\u0003 \u0010\u0000\u00f5\u00f6\u0003\u001e\u000f\u0000\u00f6\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f4\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001"+
		"\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fa\u001d\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0005\u0015\u0000\u0000\u00fd\u012e\u0003"+
		"\u001e\u000f\u0000\u00fe\u00ff\u0005C\u0000\u0000\u00ff\u0101\u0005,\u0000"+
		"\u0000\u0100\u0102\u0003\"\u0011\u0000\u0101\u0100\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000"+
		"\u0103\u012e\u0005-\u0000\u0000\u0104\u0105\u0005C\u0000\u0000\u0105\u0106"+
		"\u00050\u0000\u0000\u0106\u0107\u0005C\u0000\u0000\u0107\u0109\u0005,"+
		"\u0000\u0000\u0108\u010a\u0003\"\u0011\u0000\u0109\u0108\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000"+
		"\u0000\u010b\u012e\u0005-\u0000\u0000\u010c\u010d\u0005C\u0000\u0000\u010d"+
		"\u010e\u00050\u0000\u0000\u010e\u010f\u0005C\u0000\u0000\u010f\u0110\u0005"+
		"*\u0000\u0000\u0110\u0111\u0003\"\u0011\u0000\u0111\u0112\u0005+\u0000"+
		"\u0000\u0112\u012e\u0001\u0000\u0000\u0000\u0113\u0114\u0005C\u0000\u0000"+
		"\u0114\u0115\u00050\u0000\u0000\u0115\u012e\u0005C\u0000\u0000\u0116\u012e"+
		"\u0005C\u0000\u0000\u0117\u012e\u0005D\u0000\u0000\u0118\u012e\u0005\'"+
		"\u0000\u0000\u0119\u012e\u0005E\u0000\u0000\u011a\u012e\u0005\u001b\u0000"+
		"\u0000\u011b\u012e\u0005\u001c\u0000\u0000\u011c\u012e\u0005\u0019\u0000"+
		"\u0000\u011d\u012e\u0005\u001a\u0000\u0000\u011e\u0120\u0005,\u0000\u0000"+
		"\u011f\u0121\u0003\"\u0011\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u012e\u0005-\u0000\u0000\u0123\u0125\u0005*\u0000\u0000\u0124\u0126\u0003"+
		"\"\u0011\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u012e\u0005+\u0000"+
		"\u0000\u0128\u012a\u0005(\u0000\u0000\u0129\u012b\u0003\"\u0011\u0000"+
		"\u012a\u0129\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012e\u0005)\u0000\u0000\u012d"+
		"\u00fc\u0001\u0000\u0000\u0000\u012d\u00fe\u0001\u0000\u0000\u0000\u012d"+
		"\u0104\u0001\u0000\u0000\u0000\u012d\u010c\u0001\u0000\u0000\u0000\u012d"+
		"\u0113\u0001\u0000\u0000\u0000\u012d\u0116\u0001\u0000\u0000\u0000\u012d"+
		"\u0117\u0001\u0000\u0000\u0000\u012d\u0118\u0001\u0000\u0000\u0000\u012d"+
		"\u0119\u0001\u0000\u0000\u0000\u012d\u011a\u0001\u0000\u0000\u0000\u012d"+
		"\u011b\u0001\u0000\u0000\u0000\u012d\u011c\u0001\u0000\u0000\u0000\u012d"+
		"\u011d\u0001\u0000\u0000\u0000\u012d\u011e\u0001\u0000\u0000\u0000\u012d"+
		"\u0123\u0001\u0000\u0000\u0000\u012d\u0128\u0001\u0000\u0000\u0000\u012e"+
		"\u001f\u0001\u0000\u0000\u0000\u012f\u0130\u0007\u0000\u0000\u0000\u0130"+
		"!\u0001\u0000\u0000\u0000\u0131\u0142\b\u0001\u0000\u0000\u0132\u0134"+
		"\u0005,\u0000\u0000\u0133\u0135\u0003\"\u0011\u0000\u0134\u0133\u0001"+
		"\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0001"+
		"\u0000\u0000\u0000\u0136\u0142\u0005-\u0000\u0000\u0137\u0139\u0005*\u0000"+
		"\u0000\u0138\u013a\u0003\"\u0011\u0000\u0139\u0138\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000"+
		"\u013b\u0142\u0005+\u0000\u0000\u013c\u013e\u0005(\u0000\u0000\u013d\u013f"+
		"\u0003\"\u0011\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013e\u013f\u0001"+
		"\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0142\u0005"+
		")\u0000\u0000\u0141\u0131\u0001\u0000\u0000\u0000\u0141\u0132\u0001\u0000"+
		"\u0000\u0000\u0141\u0137\u0001\u0000\u0000\u0000\u0141\u013c\u0001\u0000"+
		"\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144#\u0001\u0000\u0000"+
		"\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u014d\u0005\u001b\u0000"+
		"\u0000\u0147\u014d\u0005\u001c\u0000\u0000\u0148\u014d\u0005\u0019\u0000"+
		"\u0000\u0149\u014d\u0005\u001a\u0000\u0000\u014a\u014d\u0005D\u0000\u0000"+
		"\u014b\u014d\u0005E\u0000\u0000\u014c\u0146\u0001\u0000\u0000\u0000\u014c"+
		"\u0147\u0001\u0000\u0000\u0000\u014c\u0148\u0001\u0000\u0000\u0000\u014c"+
		"\u0149\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c"+
		"\u014b\u0001\u0000\u0000\u0000\u014d%\u0001\u0000\u0000\u0000\u014e\u0150"+
		"\u0003(\u0014\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u0150\u0153\u0001"+
		"\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001"+
		"\u0000\u0000\u0000\u0152\'\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000"+
		"\u0000\u0000\u0154\u0158\u0003*\u0015\u0000\u0155\u0157\u00030\u0018\u0000"+
		"\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000"+
		"\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000"+
		"\u0159\u015b\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0003,\u0016\u0000\u015c\u015f\u0001\u0000\u0000\u0000\u015d"+
		"\u015f\u0003.\u0017\u0000\u015e\u0154\u0001\u0000\u0000\u0000\u015e\u015d"+
		"\u0001\u0000\u0000\u0000\u015f)\u0001\u0000\u0000\u0000\u0160\u0161\u0005"+
		"\u001f\u0000\u0000\u0161\u0165\u00036\u001b\u0000\u0162\u0164\u00038\u001c"+
		"\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0164\u0167\u0001\u0000\u0000"+
		"\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000"+
		"\u0000\u0166\u0168\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000"+
		"\u0000\u0168\u0169\u0005 \u0000\u0000\u0169+\u0001\u0000\u0000\u0000\u016a"+
		"\u016b\u0005\u001e\u0000\u0000\u016b\u016c\u00036\u001b\u0000\u016c\u016d"+
		"\u0005 \u0000\u0000\u016d-\u0001\u0000\u0000\u0000\u016e\u016f\u0005\u001f"+
		"\u0000\u0000\u016f\u0173\u00036\u001b\u0000\u0170\u0172\u00038\u001c\u0000"+
		"\u0171\u0170\u0001\u0000\u0000\u0000\u0172\u0175\u0001\u0000\u0000\u0000"+
		"\u0173\u0171\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000"+
		"\u0174\u0176\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000"+
		"\u0176\u0177\u0005\u001d\u0000\u0000\u0177/\u0001\u0000\u0000\u0000\u0178"+
		"\u0181\u0003(\u0014\u0000\u0179\u0181\u0005&\u0000\u0000\u017a\u0181\u0003"+
		"4\u001a\u0000\u017b\u017d\u00032\u0019\u0000\u017c\u017b\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000"+
		"\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u0181\u0001\u0000\u0000"+
		"\u0000\u0180\u0178\u0001\u0000\u0000\u0000\u0180\u0179\u0001\u0000\u0000"+
		"\u0000\u0180\u017a\u0001\u0000\u0000\u0000\u0180\u017c\u0001\u0000\u0000"+
		"\u0000\u01811\u0001\u0000\u0000\u0000\u0182\u0183\u0007\u0002\u0000\u0000"+
		"\u01833\u0001\u0000\u0000\u0000\u0184\u0185\u0005\"\u0000\u0000\u0185"+
		"\u0186\u0005\t\u0000\u0000\u0186\u0187\u0003<\u001e\u0000\u0187\u018b"+
		"\u0005#\u0000\u0000\u0188\u018a\u00030\u0018\u0000\u0189\u0188\u0001\u0000"+
		"\u0000\u0000\u018a\u018d\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u019a\u0001\u0000"+
		"\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u018f\u0005\"\u0000"+
		"\u0000\u018f\u0190\u0005\n\u0000\u0000\u0190\u0191\u0003<\u001e\u0000"+
		"\u0191\u0195\u0005#\u0000\u0000\u0192\u0194\u00030\u0018\u0000\u0193\u0192"+
		"\u0001\u0000\u0000\u0000\u0194\u0197\u0001\u0000\u0000\u0000\u0195\u0193"+
		"\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0199"+
		"\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0198\u018e"+
		"\u0001\u0000\u0000\u0000\u0199\u019c\u0001\u0000\u0000\u0000\u019a\u0198"+
		"\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b\u01a6"+
		"\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019d\u019e"+
		"\u0005\"\u0000\u0000\u019e\u019f\u0005\u000b\u0000\u0000\u019f\u01a3\u0005"+
		"#\u0000\u0000\u01a0\u01a2\u00030\u0018\u0000\u01a1\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a5\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a7\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u019d\u0001\u0000\u0000"+
		"\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000"+
		"\u0000\u01a8\u01a9\u0005\"\u0000\u0000\u01a9\u01aa\u0005\f\u0000\u0000"+
		"\u01aa\u01ab\u0005#\u0000\u0000\u01ab\u01d9\u0001\u0000\u0000\u0000\u01ac"+
		"\u01ad\u0005\"\u0000\u0000\u01ad\u01ae\u0005\r\u0000\u0000\u01ae\u01af"+
		"\u0005C\u0000\u0000\u01af\u01b0\u0005\u000e\u0000\u0000\u01b0\u01b1\u0003"+
		"<\u001e\u0000\u01b1\u01b5\u0005#\u0000\u0000\u01b2\u01b4\u00030\u0018"+
		"\u0000\u01b3\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b8\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\u0005\"\u0000\u0000\u01b9\u01ba\u0005\u000f\u0000\u0000"+
		"\u01ba\u01bb\u0005#\u0000\u0000\u01bb\u01d9\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bd\u0005\"\u0000\u0000\u01bd\u01be\u0005\u0010\u0000\u0000\u01be\u01bf"+
		"\u0005C\u0000\u0000\u01bf\u01c3\u0005#\u0000\u0000\u01c0\u01c2\u00030"+
		"\u0018\u0000\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c2\u01c5\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c6\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000"+
		"\u0000\u0000\u01c6\u01c7\u0005\"\u0000\u0000\u01c7\u01c8\u0005\u0011\u0000"+
		"\u0000\u01c8\u01d9\u0005#\u0000\u0000\u01c9\u01ca\u0005\"\u0000\u0000"+
		"\u01ca\u01cb\u0005\u0012\u0000\u0000\u01cb\u01cc\u0005D\u0000\u0000\u01cc"+
		"\u01d9\u0005#\u0000\u0000\u01cd\u01ce\u0005\"\u0000\u0000\u01ce\u01cf"+
		"\u0005\u0013\u0000\u0000\u01cf\u01d0\u0005D\u0000\u0000\u01d0\u01d9\u0005"+
		"#\u0000\u0000\u01d1\u01d2\u0005\"\u0000\u0000\u01d2\u01d3\u0005\u0014"+
		"\u0000\u0000\u01d3\u01d4\u0005C\u0000\u0000\u01d4\u01d5\u0005;\u0000\u0000"+
		"\u01d5\u01d6\u0003<\u001e\u0000\u01d6\u01d7\u0005#\u0000\u0000\u01d7\u01d9"+
		"\u0001\u0000\u0000\u0000\u01d8\u0184\u0001\u0000\u0000\u0000\u01d8\u01ac"+
		"\u0001\u0000\u0000\u0000\u01d8\u01bc\u0001\u0000\u0000\u0000\u01d8\u01c9"+
		"\u0001\u0000\u0000\u0000\u01d8\u01cd\u0001\u0000\u0000\u0000\u01d8\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d95\u0001\u0000\u0000\u0000\u01da\u01db\u0005"+
		"C\u0000\u0000\u01db7\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005C\u0000"+
		"\u0000\u01dd\u01de\u0005;\u0000\u0000\u01de\u01e3\u0003:\u001d\u0000\u01df"+
		"\u01e0\u0005\u0006\u0000\u0000\u01e0\u01e1\u0005;\u0000\u0000\u01e1\u01e3"+
		"\u0003:\u001d\u0000\u01e2\u01dc\u0001\u0000\u0000\u0000\u01e2\u01df\u0001"+
		"\u0000\u0000\u0000\u01e39\u0001\u0000\u0000\u0000\u01e4\u01e5\u0005D\u0000"+
		"\u0000\u01e5;\u0001\u0000\u0000\u0000\u01e6\u01e7\u0006\u001e\uffff\uffff"+
		"\u0000\u01e7\u01e8\u0005C\u0000\u0000\u01e8\u01e9\u0005;\u0000\u0000\u01e9"+
		"\u01f0\u0003<\u001e\b\u01ea\u01f0\u0005C\u0000\u0000\u01eb\u01f0\u0005"+
		"D\u0000\u0000\u01ec\u01f0\u0005E\u0000\u0000\u01ed\u01ee\u0005\u0015\u0000"+
		"\u0000\u01ee\u01f0\u0003<\u001e\u0003\u01ef\u01e6\u0001\u0000\u0000\u0000"+
		"\u01ef\u01ea\u0001\u0000\u0000\u0000\u01ef\u01eb\u0001\u0000\u0000\u0000"+
		"\u01ef\u01ec\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000"+
		"\u01f0\u01fc\u0001\u0000\u0000\u0000\u01f1\u01f2\n\u0004\u0000\u0000\u01f2"+
		"\u01f3\u0007\u0003\u0000\u0000\u01f3\u01fb\u0003<\u001e\u0005\u01f4\u01f5"+
		"\n\u0002\u0000\u0000\u01f5\u01f6\u0005\u0016\u0000\u0000\u01f6\u01fb\u0003"+
		"<\u001e\u0003\u01f7\u01f8\n\u0001\u0000\u0000\u01f8\u01f9\u0005\u0017"+
		"\u0000\u0000\u01f9\u01fb\u0003<\u001e\u0002\u01fa\u01f1\u0001\u0000\u0000"+
		"\u0000\u01fa\u01f4\u0001\u0000\u0000\u0000\u01fa\u01f7\u0001\u0000\u0000"+
		"\u0000\u01fb\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000"+
		"\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd=\u0001\u0000\u0000\u0000"+
		"\u01fe\u01fc\u0001\u0000\u0000\u0000\u01ff\u0201\u0003@ \u0000\u0200\u01ff"+
		"\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000\u0000\u0000\u0202\u0200"+
		"\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203?\u0001"+
		"\u0000\u0000\u0000\u0204\u0205\u0003B!\u0000\u0205\u0209\u0005(\u0000"+
		"\u0000\u0206\u0208\u0003D\"\u0000\u0207\u0206\u0001\u0000\u0000\u0000"+
		"\u0208\u020b\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000\u0000"+
		"\u0209\u020a\u0001\u0000\u0000\u0000\u020a\u020c\u0001\u0000\u0000\u0000"+
		"\u020b\u0209\u0001\u0000\u0000\u0000\u020c\u020d\u0005)\u0000\u0000\u020d"+
		"A\u0001\u0000\u0000\u0000\u020e\u020f\u0005C\u0000\u0000\u020fC\u0001"+
		"\u0000\u0000\u0000\u0210\u0211\u0005C\u0000\u0000\u0211\u0213\u0005.\u0000"+
		"\u0000\u0212\u0214\u0003F#\u0000\u0213\u0212\u0001\u0000\u0000\u0000\u0214"+
		"\u0215\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0215"+
		"\u0216\u0001\u0000\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u00051\u0000\u0000\u0218\u0223\u0001\u0000\u0000\u0000\u0219\u021a"+
		"\u0005A\u0000\u0000\u021a\u021c\u0005.\u0000\u0000\u021b\u021d\u0003F"+
		"#\u0000\u021c\u021b\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000"+
		"\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000"+
		"\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220\u0221\u00051\u0000\u0000"+
		"\u0221\u0223\u0001\u0000\u0000\u0000\u0222\u0210\u0001\u0000\u0000\u0000"+
		"\u0222\u0219\u0001\u0000\u0000\u0000\u0223E\u0001\u0000\u0000\u0000\u0224"+
		"\u022a\u0005D\u0000\u0000\u0225\u0226\u0005E\u0000\u0000\u0226\u022a\u0005"+
		"C\u0000\u0000\u0227\u022a\u0005E\u0000\u0000\u0228\u022a\u0005C\u0000"+
		"\u0000\u0229\u0224\u0001\u0000\u0000\u0000\u0229\u0225\u0001\u0000\u0000"+
		"\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u0229\u0228\u0001\u0000\u0000"+
		"\u0000\u022aG\u0001\u0000\u0000\u0000:KRX[gy\u0084\u0087\u0094\u00a6\u00aa"+
		"\u00b3\u00b9\u00c6\u00ce\u00d3\u00da\u00df\u00e1\u00ea\u00f9\u0101\u0109"+
		"\u0120\u0125\u012a\u012d\u0134\u0139\u013e\u0141\u0143\u014c\u0151\u0158"+
		"\u015e\u0165\u0173\u017e\u0180\u018b\u0195\u019a\u01a3\u01a6\u01b5\u01c3"+
		"\u01d8\u01e2\u01ef\u01fa\u01fc\u0202\u0209\u0215\u021e\u0222\u0229";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}