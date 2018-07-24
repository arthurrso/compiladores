package br.com.arthurrso.lexicalanalyzer;


import java_cup.runtime.*;
import java_cup.runtime.Sym;

%%

%cup
%cupsym Sym
%public
%class Lexical
%line
%column


%{
  StringBuilder string = new StringBuilder();  

  private Symbol Symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol Symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}


/* Definicao de palavras/strings, digitos/numeros e espacos
    em branco para utilizacao das regras mais abaixo */ 
StringCharacter = [^\r\n\"\\]
LineTerminator = \r|\n|\r\n

WHITE={LineTerminator} | [ \t\f]
Identifier = [:jletter:][:jletterdigit:]*

comentario = "/*" [^*] ~"*/" | "/*" "*"+ "/" | "//" [^\r\n]* {LineTerminator}? |  "/*" "*"+ [^/*] ~"*/"

decIntLiteral = 0 | [1-9][0-9]*
decLongLiteral    = {decIntLiteral} [lL]
hexIntLiteral = 0 [xX] 0* [0-9a-fA-F] {1,8}
hexLongLiteral    = 0 [xX] 0* [0-9a-fA-F] {1,16} [lL]
octIntLiteral = 0+ [1-3]? [0-7] {1,15}
octLongLiteral    = 0+ 1? [0-7] {1,21} [lL]

floatLiteral  = ([0-9]+ \. [0-9]*
		|\. [0-9]+
		|[0-9]+) [eE] [+-]? [0-9]+?

%state STRING


%%

/* Simbolos terminais que serao utilizados pelo analisador
   sintatico (CUP) */

<YYINITIAL> {
  
  /* palavras reservadas de java*/
  "class"         {return Symbol(Sym.CLASS, new String(yytext()));}
  "extends"       {return Symbol(Sym.EXTENDS, new String(yytext()));}
  "implements"    {return Symbol(Sym.IMPLEMENTS, new String(yytext()));}
  "interface"     {return Symbol(Sym.INTERFACE, new String(yytext()));}
  "new"           {return Symbol(Sym.NEW, new String(yytext()));}
  "break"         {return Symbol(Sym.BREAK, new String(yytext()));}
  "case"          {return Symbol(Sym.CASE, new String(yytext()));}
  "continue"      {return Symbol(Sym.CONTINUE, new String(yytext()));}
  "default"       {return Symbol(Sym.DEFAULT, new String(yytext()));}
  "do"            {return Symbol(Sym.DO, new String(yytext()));}
  "if"            {return Symbol(Sym.IF, new String(yytext()));}
  "else"          {return Symbol(Sym.ELSE, new String(yytext()));}
  "for"           {return Symbol(Sym.FOR, new String(yytext()));}
  "return"        {return Symbol(Sym.RETURN, new String(yytext()));}
  "switch"        {return Symbol(Sym.SWITCH, new String(yytext()));}
  "while"         {return Symbol(Sym.WHILE, new String(yytext()));}
  "try"           {return Symbol(Sym.TRY, new String(yytext()));}
  "catch"         {return Symbol(Sym.CATCH, new String(yytext()));}
  "finally"       {return Symbol(Sym.FINALLY, new String(yytext()));}
  "throw"         {return Symbol(Sym.THROW, new String(yytext()));}
  "import"        {return Symbol(Sym.IMPORT, new String(yytext()));}
  "package"       {return Symbol(Sym.PACKAGE, new String(yytext()));}
  "byte"          {return Symbol(Sym.BYTE, new String(yytext()));}
  
  "abstract"      {return Symbol(Sym.ABSTRACT, new String(yytext()));}
  "final"         {return Symbol(Sym.FINAL, new String(yytext()));}
  "native"        {return Symbol(Sym.NATIVE, new String(yytext()));}
  "synchronized"  {return Symbol(Sym.SYNCHRONIZED, new String(yytext()));}
  "transient"     {return Symbol(Sym.TRANSIENT, new String(yytext()));}
  "volatile"      {return Symbol(Sym.VOLATILE, new String(yytext()));}
  "strictfp"      {return Symbol(Sym.STRICTFP, new String(yytext()));}
  "public"        {return Symbol(Sym.PUBLIC, new String(yytext()));}
  "protected"     {return Symbol(Sym.PROTECTED, new String(yytext()));}
  "private"       {return Symbol(Sym.PRIVATE, new String(yytext()));}
  "static"        { return Symbol(Sym.STATIC, new String(yytext()));}
  "void"          {return Symbol(Sym.VOID, new String(yytext()));}

  "null"          {return Symbol(Sym.NULL, new String(yytext())); }  
  "super"         {return Symbol(Sym.SUPER, new String(yytext())); }
  "this"          {return Symbol(Sym.THIS, new String(yytext())); }
  "instanceof"    {return Symbol(Sym.INSTANCEOF, new String(yytext())); }


/* Tipos primitivos de java */
  "boolean"       {return Symbol(Sym.BOOLEAN, new String(yytext())); }
  "byte"          {return Symbol(Sym.BYTE, new String(yytext())); }
  "char"          {return Symbol(Sym.CHAR, new String(yytext())); }
  "short"         {return Symbol(Sym.SHORT, new String(yytext())); }
  "int"           {return Symbol(Sym.INT, new String(yytext())); }
  "float"         {return Symbol(Sym.FLOAT, new String(yytext())); }
  "long"          {return Symbol(Sym.LONG, new String(yytext())); }
  "double"        {return Symbol(Sym.DOUBLE, new String(yytext()));}
  "String"        {return Symbol(Sym.STRING, new String(yytext()));}
  
  /* Literais booleanos */
  
  "true"          {return Symbol(Sym.TRUE, new String(yytext()));}
  "false"         {return Symbol(Sym.FALSE, new String(yytext()));}
 
 
 /* Separadores */
  "("             {return Symbol(Sym.LPAREN, new String(yytext()));}
  ")"             {return Symbol(Sym.RPAREN, new String(yytext()));}
  "{"             {return Symbol(Sym.LBRACE, new String(yytext()));}
  "}"             {return Symbol(Sym.RBRACE, new String(yytext()));}
  "["             {return Symbol(Sym.LBRACK, new String(yytext()));}
  "]"             {return Symbol(Sym.RBRACK, new String(yytext()));}
  ";"             {return Symbol(Sym.SEMICOLON, new String(yytext()));}
  ","             {return Symbol(Sym.COMMA, new String(yytext()));}
  "."             {return Symbol(Sym.DOT, new String(yytext()));}
 
 /* operadores relacionais e booleanos */
  "="             {return Symbol(Sym.EQUAL, new String(yytext())); }
  ">"             {return Symbol(Sym.GREATER, new String(yytext())); }
  "<"             {return Symbol(Sym.LESS, new String(yytext())); }
  "!"             {return Symbol(Sym.NOT, new String(yytext())); }
  "~"             {return Symbol(Sym.BITNOT, new String(yytext())); }
  "?"             {return Symbol(Sym.QUESTION, new String(yytext())); }
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
  ">>>"           {return Symbol(Sym.URSHIFT, new String(yytext())); }
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

  {decIntLiteral}           { return Symbol(Sym.INTEGER_LITERAL, new String(yytext())); }
  {decLongLiteral}          { return Symbol(Sym.INTEGER_LITERAL, new String(yytext())); }
  {hexIntLiteral}           { return Symbol(Sym.INTEGER_LITERAL, new String(yytext())); }
  {hexLongLiteral}          { return Symbol(Sym.INTEGER_LITERAL, new String(yytext())); }
  {octIntLiteral}           { return Symbol(Sym.INTEGER_LITERAL, new String(yytext())); }
  {octLongLiteral}          { return Symbol(Sym.INTEGER_LITERAL, new String(yytext())); }
  {floatLiteral}            { return Symbol(Sym.FLOAT_LITERAL, new String(yytext()));}
  {floatLiteral}[fF]        { return Symbol(Sym.FLOAT_LITERAL, new String(yytext())); }  
  {floatLiteral}[dD]        { return Symbol(Sym.FLOAT_LITERAL, new String(yytext())); }  

  /* Definicao de espaco em branco, id, numero e comentario */

  {WHITE}      {/*Ignore*/}
  {comentario} {/*Ignore*/}
  {Identifier} {return Symbol(Sym.ID, new String(yytext()));} 
}


<STRING>{
  \"                             { yybegin(YYINITIAL);
                                   return Symbol(Sym.STRING_LITERAL, new String(yytext())); }
  
  {StringCharacter}+             { string.append( yytext() ); }
  
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }

  \\.                            { throw new RuntimeException(
                                  "Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException(
                                       "Unterminated string at end of line"); }  
}

[^]              { throw new RuntimeException("Illegal character \""+yytext()+
                             "\" at line "+yyline+", column "+yycolumn); }