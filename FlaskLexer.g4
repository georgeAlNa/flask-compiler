lexer grammar FlaskLexer;

// ─── Flask Decorator ────────────────────────────────────────────────────────
APP_ROUTE    : '@app.route';

// ─── Python Keywords ────────────────────────────────────────────────────────
DEF          : 'def';
RETURN       : 'return';
FROM         : 'from';
IMPORT       : 'import';
CLASS        : 'class';

// ─── Template/Styles Keywords ───────────────────────────────────────────────
TEMPLATE_KW  : 'template';
STYLES       : 'styles';

// ─── Jinja2 Control Keywords ────────────────────────────────────────────────
IF           : 'if';
ELIF         : 'elif';
ELSE         : 'else';
ENDIF        : 'endif';
FOR          : 'for';
IN           : 'in';
ENDFOR       : 'endfor';
BLOCK        : 'block';
ENDBLOCK     : 'endblock';
EXTENDS      : 'extends';
INCLUDE      : 'include';
SET          : 'set';
NOT          : 'not';
AND          : 'and';
OR           : 'or';
IS           : 'is';
TRUE         : 'true' | 'True';
FALSE        : 'false' | 'False';
NONE         : 'none' | 'None';
NULL         : 'null';

// ─── HTML Tag Tokens ────────────────────────────────────────────────────────
SELF_CLOSE   : '/>';
CLOSE_TAG    : '</';
LT           : '<';
GT           : '>';
SLASH        : '/';

// ─── Jinja2 Structural ─────────────────────────────────────────────────────
BLOCK_START  : '{%';
BLOCK_END    : '%}';
COMMENT_START: '{#';
COMMENT_END  : '#}';
TEMPLATE_EXPRESSION : '{{' .*? '}}';

// ─── Triple-Quoted String (must come before STRING) ─────────────────────────
TRIPLE_QUOTE_STRING : '"""' .*? '"""';

// ─── General Structural ────────────────────────────────────────────────────
LCURLEBRACE  : '{';
RCURLEBRACE  : '}';
LSQBRACKET   : '[';
RSQBRACKET   : ']';
LPAREN       : '(';
RPAREN       : ')';
COLON        : ':';
COMMA        : ',';
DOT          : '.';
SEMICOLON    : ';';
PIPE         : '|';
STAR         : '*';
PLUS         : '+';
MINUS        : '-';
PERCENT      : '%';
TILDE        : '~';
QUESTION_MARK: '?';
AT           : '@';
HASH         : '#';
EQUAL        : '=';
BACKTICK     : '`';

// ─── Operators ─────────────────────────────────────────────────────────────
EQEQ         : '==';
NOTEQ        : '!=';
LTE          : '<=';
GTE          : '>=';

// ─── CSS Tokens (only those that don't conflict with Python) ───────────────
CSS_CUSTOM_PROPERTY : '--' [a-zA-Z_][a-zA-Z0-9_\-]*;

// ─── Python Dunder Identifier (must come before IDENTIFIER) ────────────────
DUNDER_NAME  : '__' [a-zA-Z_][a-zA-Z0-9_]* '__';

// ─── General ───────────────────────────────────────────────────────────────
IDENTIFIER   : [a-zA-Z_][a-zA-Z0-9_]*;
STRING       : '"' (~["\\\r\n])* '"' | '\'' (~['\\\r\n])* '\'';
NUMBER       : [0-9]+ ('.' [0-9]+)?;

// ─── Whitespace & Comments ─────────────────────────────────────────────────
PY_COMMENT   : '#' ~[\r\n]* -> skip;
WS           : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
