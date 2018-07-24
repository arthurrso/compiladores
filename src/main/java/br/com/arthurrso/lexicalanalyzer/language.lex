package br.com.arthurrso.lexicalanalyzer;


import java_cup.runtime.*;

%%

%cup
%public
%class Lexical
%line
%column


DIGIT = [0-9]
LETTER = [a-zA-Z_]
COMMENT = \|\|.*\n
STRING = \~{LETTER}+\~
INTEGER = {DIGIT}+
VARIABLE = @{LETTER}+
ASSIGNMENT = \${LETTER}+
FUNCTION = &{LETTER}+
FUNCTION_PARAMS = \^{LETTER}+ 
CALL_FUNCTION = %{LETTER}+
IGNORE = [\n|\s|\t\r]

%{
  StringBuilder string = new StringBuilder();  

  private Symbol Symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol Symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}


%state STRING


%%

/* Simbolos terminais que serao utilizados pelo analisador
   sintatico (CUP) */

<YYINITIAL> {
  
  /* palavras reservadas da linguagem GO */

  "break"       {return Symbol(Sym.BREAK, new String(yytext()));}
  "case"       {return Symbol(Sym.CASE, new String(yytext()));}
  "chan"      {return Symbol(Sym.CHAN, new String(yytext()));}
  "const"         {return Symbol(Sym.CONST, new String(yytext()));}
  "continue"        {return Symbol(Sym.CONTINUE, new String(yytext()));}
  "default"  {return Symbol(Sym.DEFAULT, new String(yytext()));}
  "defer"     {return Symbol(Sym.DEFER, new String(yytext()));}
  "else"      {return Symbol(Sym.ELSE, new String(yytext()));}
  "fallthrough"      {return Symbol(Sym.FALLTHROUGH, new String(yytext()));}
  "for"        {return Symbol(Sym.FOR, new String(yytext()));}
  "func"     {return Symbol(Sym.FUNC, new String(yytext()));}
  "go"       {return Symbol(Sym.GO, new String(yytext()));}
  "goto"        { return Symbol(Sym.GOTO, new String(yytext()));}
  "if"          {return Symbol(Sym.IF, new String(yytext()));}
  "import"          {return Symbol(Sym.IMPORT, new String(yytext()));}
  "interface"          {return Symbol(Sym.INTERFACE, new String(yytext()));}
  "map"          {return Symbol(Sym.MAP, new String(yytext()));}
  "package"          {return Symbol(Sym.PACKAGE, new String(yytext()));}
  "range"          {return Symbol(Sym.RANGE, new String(yytext()));}
  "return"          {return Symbol(Sym.RETURN, new String(yytext()));}
  "select"          {return Symbol(Sym.SELECT, new String(yytext()));}
  "struct"          {return Symbol(Sym.STRUCT, new String(yytext()));}
  "switch"          {return Symbol(Sym.SWITCH, new String(yytext()));}
  "type"          {return Symbol(Sym.TYPE, new String(yytext()));}
  "var"          {return Symbol(Sym.VAR, new String(yytext()));}

/* Literais booleanos */
  
  "true"          {return Symbol(Sym.TRUE, new String(yytext()));}
  "false"         {return Symbol(Sym.FALSE, new String(yytext()));}
  
 /* operadores relacionais e booleanos */
  "="             {return Symbol(Sym.EQUAL, new String(yytext())); }
  ">"             {return Symbol(Sym.GREATER, new String(yytext())); }
  "<"             {return Symbol(Sym.LESS, new String(yytext())); }
  "!"             {return Symbol(Sym.NOT, new String(yytext())); }
  ":"             {return Symbol(Sym.COLON, new String(yytext())); }
  "=="            {return Symbol(Sym.EQEQ, new String(yytext())); }
  "<="            {return Symbol(Sym.LTEQ, new String(yytext())); }
  ">="            {return Symbol(Sym.GTEQ, new String(yytext())); }
  "!="            {return Symbol(Sym.NOTEQ, new String(yytext())); }
  "&&"            {return Symbol(Sym.ANDAND, new String(yytext())); }
  "||"            {return Symbol(Sym.OROR, new String(yytext())); }
  "++"            {return Symbol(Sym.PLUSPLUS, new String(yytext())); }
  "--"            {return Symbol(Sym.MINUSMINUS, new String(yytext())); }
  "+"             {return Symbol(Sym.PLUS, new String(yytext())); }
  "-"             {return Symbol(Sym.MINUS, new String(yytext())); }
  "*"             {return Symbol(Sym.MULT, new String(yytext())); }
  "/"             {return Symbol(Sym.DIV, new String(yytext())); }
  "&"             {return Symbol(Sym.AND, new String(yytext())); }
  "|"             {return Symbol(Sym.OR, new String(yytext())); }
  "^"             {return Symbol(Sym.XOR, new String(yytext())); }
  "%"             {return Symbol(Sym.MOD, new String(yytext())); }
  "<<"            {return Symbol(Sym.LSHIFT, new String(yytext())); }
  ">>"            {return Symbol(Sym.RSHIFT, new String(yytext())); }
  "+="            {return Symbol(Sym.PLUSEQ, new String(yytext())); }
  "-="            {return Symbol(Sym.MINUSEQ, new String(yytext())); }
  "*="            {return Symbol(Sym.MULTEQ, new String(yytext())); }
  "/="            {return Symbol(Sym.DIVEQ, new String(yytext())); }
  "&="            {return Symbol(Sym.ANDEQ, new String(yytext())); }
  "|="            {return Symbol(Sym.OREQ, new String(yytext())); }
  "^="            {return Symbol(Sym.XOREQ, new String(yytext())); }
  "%="            {return Symbol(Sym.MODEQ, new String(yytext())); }
  "<<="           {return Symbol(Sym.LSHIFTEQ, new String(yytext())); }
  ">>="           {return Symbol(Sym.RSHIFTEQ, new String(yytext())); }
  "..."           {return Symbol(Sym.ELLIPSIS, new String(yytext())); }
  "&^="           {return Symbol(Sym.ANDNOTEQ, new String(yytext())); }
  "&^"           {return Symbol(Sym.ANDNOT, new String(yytext())); }
  ";"           {return Symbol(Sym.SEMICOLON, new String(yytext())); }
  ":="           {return Symbol(Sym.SHORTDECLARATION, new String(yytext())); }
  "<-"           {return Symbol(Sym.RECIEVER, new String(yytext())); }
  ","             {return Symbol(Sym.COMMA, new String(yytext()));}
  "."             {return Symbol(Sym.DOT, new String(yytext()));}
  "("             {return Symbol(Sym.LPAREN, new String(yytext()));}
  ")"             {return Symbol(Sym.RPAREN, new String(yytext()));}
  "{"             {return Symbol(Sym.LBRACE, new String(yytext()));}
  "}"             {return Symbol(Sym.RBRACE, new String(yytext()));}
  "["             {return Symbol(Sym.LBRACK, new String(yytext()));}
  "]"             {return Symbol(Sym.RBRACK, new String(yytext()));}

/* Tipos primitivos da linguagem GO */
  "bool"       {return Symbol(Sym.BOOLEAN, new String(yytext())); }
  "byte"          {return Symbol(Sym.BYTE, new String(yytext())); }
  "error"          {return Symbol(Sym.ERROR, new String(yytext())); }
  "int"           {return Symbol(Sym.INT, new String(yytext())); }
  "string"        {return Symbol(Sym.STRING, new String(yytext()));}
  "rune"        {return Symbol(Sym.RUNE, new String(yytext()));}
    

  /* Definicao de espaco em branco, id, numero e comentario */

  {IGNORE}        {}
  {COMMENT}       {}
  {VARIABLE}      {return new Symbol(Sym.VARIABLE); }
  {FUNCTION_PARAMS}   {return new Symbol(Sym.FUNCTION_PARAMS); }
  {FUNCTION}      {return new Symbol(Sym.FUNCTION); }
  {INTEGER}       {return new Symbol(Sym.INTEGER); }  
  {ASSIGNMENT}    {return new Symbol(Sym.ASSIGNMENT); }
  {CALL_FUNCTION} {return new Symbol(Sym.CALL_FUNCTION); }
  
 }

<<EOF>> { return new Symbol( Sym.EOF ); }


[^] { throw new Error("Illegal character: "+yytext()+" at line "+(yyline+1)+", column "+(yycolumn+1) ); }