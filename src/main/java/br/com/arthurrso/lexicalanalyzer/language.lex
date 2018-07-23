package br.com.arthurrso.lexicalanalyzer;

import static br.com.arthurrso.lexicalanalyzer.Token.*;

%%

%public
%class Lexical
%type Token
%line
%column


DIGIT = [0-9]
LETTER = [a-zA-Z_]
STRING = \~{LETTER}+\~
INTEGER = {DIGIT}+
VARIABLE = @{LETTER}+
ASSIGNMENT = \${LETTER}+
FUNCTION = &{LETTER}+
FUNCTION_PARAMS = \^{LETTER}+ 
CALL_FUNCTION = %{LETTER}+

%{
public String lexeme;
%}

IGNORE = [\n|\s|\t\r]

%%

/* Comentarios */
( "//" | "/*" | "*/")     {lexeme = yytext(); return COMENTARIO;}

/* Palavras */
( break | default | func |  interface | select
| case |  defer | go | map | struct
| chan |  else |  goto |  package | switch
| const | fallthrough | if | range | type
| continue | for | import | return | var ) {lexeme = yytext(); return PALAVRA;}


/* Booleanos */
(true | false)      {lexeme=yytext(); return BOOLEANO;}

/* Operadores */
( "&" |  "&=" |  "&&" | "==" | "!=" | "(" | ")"
| "|" | "|=" |  "||" | "<" | "<=" | "[" | "]"
| "^" |  "^=" |  "<-" | ">" |  ">=" | "{" | "}"
| "<<" | "<<=" | "++" | "=" |  ":=" | "," | ";"
| "%" | ">>" | "%=" | ">>=" | "!" |  "..."| "." | ":"
| "&^" | "&^=") {lexeme = yytext(); return OPERADOR;}


("+" | "+=" | "-" | "*" | "/" | "--" | "-=" | "*=" | "/=") {lexeme = yytext(); return OPERADOR_ARIT;}

/* NUMBER*/

( uint8      
| uint16 | uint32     
| uint64 | int8       
| int16 | int32      
| int64 | float32    
| float64 | complex64  
| complex128 | byte
| rune ) {lexeme = yytext(); return NUMBER;}
    
{LETTER}({LETTER}|{DIGIT})* {lexeme=yytext(); return ID;}
 ("(-"{DIGIT}+")")|{DIGIT}+ {lexeme=yytext(); return NUMERO;}