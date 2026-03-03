parser grammar FlaskParser;

options { tokenVocab=FlaskLexer; }

// ─── Application Root ──────────────────────────────────────────────────────
application
    : importStatement* appDeclaration globalAssignment* routeDefinition+ mainGuard? EOF
                                                                    #applicationRoot
    ;

// ─── Import Statement: from flask import Flask, render_template ────────────
importStatement
    : FROM IDENTIFIER IMPORT IDENTIFIER (COMMA IDENTIFIER)*        #importDef
    ;

// ─── App Declaration: app = Flask(__name__) ────────────────────────────────
appDeclaration
    : IDENTIFIER EQUAL IDENTIFIER LPAREN DUNDER_NAME RPAREN        #appDef
    ;

// ─── Global Variable: products_data = [...] ────────────────────────────────
globalAssignment
    : IDENTIFIER EQUAL LSQBRACKET dictLiteral (COMMA dictLiteral)* RSQBRACKET  #globalListDef
    ;

dictLiteral
    : LCURLEBRACE (dictEntry (COMMA dictEntry)*)? RCURLEBRACE       #dictDef
    ;

dictEntry
    : STRING COLON pyExpression                                     #dictEntryDef
    ;

// ─── Route Definition ─────────────────────────────────────────────────────
routeDefinition
    : routeDecorator DEF IDENTIFIER LPAREN parameterList? RPAREN COLON routeBody
                                                                    #routeDef
    ;

routeDecorator
    : APP_ROUTE LPAREN STRING (COMMA IDENTIFIER EQUAL LSQBRACKET STRING (COMMA STRING)* RSQBRACKET)? RPAREN
                                                                    #routeDecoratorDef
    ;

parameterList
    : IDENTIFIER (COMMA IDENTIFIER)*                                #paramList
    ;

// ─── Route Body ───────────────────────────────────────────────────────────
routeBody
    : bodyStatement*                                                #routeBodyContent
    ;

bodyStatement
    : ifBlock                                                       #bodyIfBlock
    | TEMPLATE_KW EQUAL TRIPLE_QUOTE_STRING                         #bodyTemplateAssignment
    | RETURN pyExpression                                           #bodyReturnStatement
    | IDENTIFIER EQUAL pyExpression                                 #bodyVarAssignment
    | pyExpression                                                  #bodyExpressionStatement
    ;

// ─── If Block (ends at first return) ───────────────────────────────────────
ifBlock
    : IF pyExpression COLON innerBodyStatement* RETURN pyExpression  #ifBlockDef
    ;

// ─── Inner Body Statement (used inside if-blocks; no RETURN to prevent greedy overrun) ─
innerBodyStatement
    : TEMPLATE_KW EQUAL TRIPLE_QUOTE_STRING                         #innerBodyTemplateAssignment
    | IDENTIFIER EQUAL pyExpression                                 #innerBodyVarAssignment
    | pyExpression                                                  #innerBodyExpressionStatement
    ;

// ─── Main Guard: if __name__ == "__main__": app.run(debug=True) ───────────
mainGuard
    : IF DUNDER_NAME EQEQ STRING COLON pyExpression                #mainGuardDef
    ;

// ─── Python Expression (flexible, handles any expression) ─────────────────
pyExpression
    : pyAtom (pyOp pyAtom)*
    ;

pyAtom
    : NOT pyAtom
    | IDENTIFIER LPAREN pyInner? RPAREN
    | IDENTIFIER DOT IDENTIFIER LPAREN pyInner? RPAREN
    | IDENTIFIER DOT IDENTIFIER LSQBRACKET pyInner RSQBRACKET
    | IDENTIFIER DOT IDENTIFIER
    | IDENTIFIER
    | STRING
    | TRIPLE_QUOTE_STRING
    | NUMBER
    | NONE | NULL | TRUE | FALSE
    | LPAREN pyInner? RPAREN
    | LSQBRACKET pyInner? RSQBRACKET
    | LCURLEBRACE pyInner? RCURLEBRACE
    ;

pyOp
    : PLUS | MINUS | STAR | SLASH | PERCENT
    | EQEQ | NOTEQ | LTE | GTE | LT | GT
    | AND | OR | IS | IN | NOT
    | COMMA
    ;

// ─── Matches anything with balanced brackets (for function args, etc.) ────
pyInner
    : ( ~(LPAREN | RPAREN | LSQBRACKET | RSQBRACKET | LCURLEBRACE | RCURLEBRACE)
      | LPAREN pyInner? RPAREN
      | LSQBRACKET pyInner? RSQBRACKET
      | LCURLEBRACE pyInner? RCURLEBRACE
      )*
    ;

// ─── Literals ────────────────────────────────────────────────────────────
literal
    : NONE          #noneLiteral
    | NULL          #nullLiteral
    | TRUE          #trueLiteral
    | FALSE         #falseLiteral
    | STRING        #stringLiteral
    | NUMBER        #numberLiteral
    ;

// ═══════════════════════════════════════════════════════════════════════════
// HTML/CSS/Jinja2 Rules (for parsing template content in the visitor)
// ═══════════════════════════════════════════════════════════════════════════

htmlDocument
    : htmlElement*                                                  #htmlDocumentContent
    ;

htmlElement
    : startTag htmlContent* endTag                                  #htmlStandardElement
    | selfClosingTag                                                #htmlSelfClosingElement
    ;

startTag       : LT tagName attribute* GT                          #htmlStartTag ;
endTag         : CLOSE_TAG tagName GT                               #htmlEndTag ;
selfClosingTag : LT tagName attribute* SELF_CLOSE                   #htmlSelfClosingTag ;

htmlContent
    : htmlElement                                                   #htmlNestedElement
    | TEMPLATE_EXPRESSION                                           #htmlTemplateExpression
    | jinja2Block                                                   #htmlJinja2Block
    | textToken+                                                    #htmlTextContent
    ;

textToken
    : IDENTIFIER | NUMBER | STRING | COLON | DOT | MINUS | PLUS | SLASH
    | EQUAL | PERCENT | STAR | HASH | AT | QUESTION_MARK | TILDE
    ;

jinja2Block
    : BLOCK_START IF expression BLOCK_END htmlContent*
      (BLOCK_START ELIF expression BLOCK_END htmlContent*)*
      (BLOCK_START ELSE BLOCK_END htmlContent*)?
      BLOCK_START ENDIF BLOCK_END                                   #jinja2IfBlock
    | BLOCK_START FOR IDENTIFIER IN expression BLOCK_END
      htmlContent* BLOCK_START ENDFOR BLOCK_END                     #jinja2ForBlock
    | BLOCK_START BLOCK IDENTIFIER BLOCK_END
      htmlContent* BLOCK_START ENDBLOCK BLOCK_END                   #jinja2BlockTag
    | BLOCK_START EXTENDS STRING BLOCK_END                          #jinja2ExtendsTag
    | BLOCK_START INCLUDE STRING BLOCK_END                          #jinja2IncludeTag
    | BLOCK_START SET IDENTIFIER EQUAL expression BLOCK_END         #jinja2SetTag
    ;

tagName        : IDENTIFIER                                        #htmlTagName ;

attribute
    : IDENTIFIER EQUAL attributeValue                               #htmlAttributeBasic
    | CLASS EQUAL attributeValue                                    #htmlAttributeClass
    ;

attributeValue : STRING                                             #htmlAttributeValue ;

expression
    : IDENTIFIER EQUAL expression                                   #assignmentExpression
    | IDENTIFIER                                                    #identifierExpression
    | STRING                                                        #stringExpression
    | NUMBER                                                        #numberExpression
    | expression (EQEQ | NOTEQ | LTE | GTE | LT | GT) expression  #comparisonExpression
    | NOT expression                                                #notExpression
    | expression AND expression                                     #andExpression
    | expression OR expression                                      #orExpression
    ;

// ─── CSS Rules ───────────────────────────────────────────────────────────
cssContent     : cssRule+                                           #cssContentRules ;
cssRule        : cssSelector LCURLEBRACE cssDeclaration* RCURLEBRACE #cssRuleDefinition ;
cssSelector    : IDENTIFIER ;

cssDeclaration
    : IDENTIFIER COLON cssValue+ SEMICOLON                          #cssDeclarationEntry
    | CSS_CUSTOM_PROPERTY COLON cssValue+ SEMICOLON                 #cssCustomPropertyEntry
    ;

cssValue
    : STRING         #cssValueString
    | NUMBER IDENTIFIER #cssValueDimension
    | NUMBER         #cssValueNumber
    | IDENTIFIER     #cssValueAlphabet
    ;
