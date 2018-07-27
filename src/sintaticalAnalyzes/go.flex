package lexicalAnalyzes;

import java.io.*; 
import java_cup.runtime.*;

import java.lang.System;

%%

%public

%cup 

/*%implements java_cup.runtime.Scanner
%function next_token
%type java_cup.runtime.Symbol
%eofval{
  return new java_cup.runtime.Symbol(new Symbol(sym.EOF);
%eofval}
%eofclose*/

%line
%column
%type java_cup.runtime.Symbol
%unicode

%eofval{ 
    return symbol(sym.EOF) ;
%eofval}


%{
/* To create a new java_cup.runtime.Symbol with information about
the current symbol, the symbol will have no value in this
case. */
private Symbol symbol(int type) {
 // System.out.println("return "+type);
 return new Symbol(type, yyline, yycolumn);
}
/* Also creates a new java_cup.runtime.Symbol with information
about the current symbol, but this object has a value. */
private Symbol symbol(int type, Object value) {
 // System.out.println("return "+type);
 return new Symbol(type, yyline, yycolumn, value);
}
%}


%{

   StringBuffer token_stream = new StringBuffer();
   StringBuffer code_stream = new StringBuffer();
   public void append_tokens_to_file()
   {
      /*if(code_stream.length() == 0)
      {
        code_stream.append("\n");
        return;
      }
      String content = code_stream.toString() + "   //  "+ token_stream.toString()+"\n";
      System.out.print(content);
      
      try
      {
        File file = new File("output.go");
   
        // if file doesnt exists, then create it
        if (!file.exists()) 
        {
          file.createNewFile();
        }
   
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
        code_stream.setLength(0);
        token_stream.setLength(0);
      }
      catch (IOException e) 
      {
        e.printStackTrace();
      }*/
   }
   public void append_code(String code)
   {
      //code_stream.append(code);
   }
   public void append_token(String token_type)
   {
     //token_stream.append(token_type + " ");
   }
   public Symbol gprint (int type) 
   {
      int line_no = yyline+1;
   		switch (type)
   		{
   			case 1:
          append_token("Identifier");
          //return symbol(sym.identifier);
   				//System.out.print("Identifier_"+yytext()+" \n");
   				break;
   			case 2:
          append_token("Keyword");
   				//System.out.print("Keyword \n");
   				break;
   			case 3:
          append_token("O&D");  // fine graining it...
   				//System.out.print("O&D_"+yytext()+"\n");

          /*switch (yytext())
          {
            // "==" | "!=" | "<" | "<=" | ">" | ">="
            case "==":
              return symbol(sym.equal_equal_op);
            case "!=":
              return symbol(sym.not_equal_op);
            case "<":
              return symbol(sym.less_op);
            case "<=":
              return symbol(sym.less_equal_op);
            case ">":
              return symbol(sym.greater_op);
            case ">=":
              return symbol(sym.greater_equal_op);

            // "+" | "-" | "|" | "^"
            case "+":
              return symbol(sym.plus_op);
            case "-":
              return symbol(sym.minus_op);
            case "|":
              return symbol(sym.pipe_op);
            case "^":
              return symbol(sym.pow_op);
            case "?":
              return symbol(sym.inter_op);

            // "*" | "/" | "%" | "<<" | ">>" | "&" | "&^"
            case "*":
              return symbol(sym.star_op);
            case "/":
              return symbol(sym.div_op);
            case "%":
              return symbol(sym.mod_op);
            case "<<":
              return symbol(sym.left_shift_op);
            case ">>":
              return symbol(sym.right_shift_op);
            case "&":
              return symbol(sym.amp_op);
            case "&^":
              return symbol(sym.amp_pow_op);

            // "" | "-" | "!" | "^" | "*" | "&" | "<-"
            case "!":
              return symbol(sym.not_op);
            case "<-":
              return symbol(sym.chan_op);

            // && | ||
            case "&&":
              return symbol(sym.and_op);
            case "||":
              return symbol(sym.or_op);

            // DELIMITERS AND SPECIAL TOKENS
            case "(":
              return symbol(sym.open_brac);
            case ")":
              return symbol(sym.close_brac);
            case "[":
              return symbol(sym.open_square_brac);
            case "]":
              return symbol(sym.close_square_brac);
            case "{":
              return symbol(sym.open_curly_brac);
            case "}":
              return symbol(sym.close_curly_brac);

            case "++":
              return symbol(sym.inc_op);
            case ":=":
              return symbol(sym.short_ass);
            case ",":
              return symbol(sym.comma);
            case ";":
              return symbol(sym.semicolon);
            case "--":
              return symbol(sym.dec_op);

            case "...":
              return symbol(sym.tri_dot);
            case ".":
              return symbol(sym.dot);
            case ":":
              return symbol(sym.colon);
            // Added on 10th March 2015
            case "=":
              return symbol(sym.equal);

          }*/
   				break;

   			case 41:
          append_token("int_lit");
          //return symbol(sym.int_lit);
   				//System.out.print("BasicLit_"+yytext()+" \n");
   				break;
        case 42:
          append_token("float_lit");
          //return symbol(sym.float_lit);
          //System.out.print("BasicLit_"+yytext()+" \n");
          break;
        case 43:
          append_token("imaginary_lit");
          //return symbol(sym.imaginary_lit);
          //System.out.print("BasicLit_"+yytext()+" \n");
          break;
        case 44:
          append_token("rune_lit");
          //return symbol(sym.rune_lit);
          //System.out.print("BasicLit_"+yytext()+" \n");
          break;
        case 45:
          append_token("string_lit");
          //return symbol(sym.string_lit);
          //System.out.print("BasicLit_"+yytext()+" \n");
          break;

        case 5:
          append_token("Type");
          //return symbol(sym.Type;
          //System.out.print("Type_"+yytext()+" \n");
          break;
        case 6:
          append_token("Constant");
          //return symbol(sym.Constant;
          //System.out.print("Constant_"+yytext()+"\n");
          break;
        case 7:
            append_token("Zero_value");
            //return symbol(sym.Zero_value;
            //System.out.print("Zero_value"+"\n");
        case 8:
            append_token("Function");
            //return symbol(sym.Function;
            //System.out.print("Function_"+yytext()+"\n");
            break;
        case 9:
            //append_token("WHITE SPACES");
            break;//pseudo-case for whitespace
        case -2:
            System.out.println("ERROR: Numeric Literal followed by letter at line "+line_no);
            break;
   			default:
            System.out.println("ERROR");
   				  System.out.print("ERROR \n");
            return symbol(sym.error);
   		}
      append_code(yytext());
   		return symbol(sym.EOF);
  }
%}

identifier = {letter} ( {letter} | {unicode_digit} )*

illegal_identifier = {unicode_digit} ( {letter} | {unicode_digit} )*

letter        = {unicode_letter} | "_"
decimal_digit = [0-9]
octal_digit   = [0-7]
hex_digit     = [0-9] | [A-F] | [a-f]

newline        = \n
unicode_char   = [^\n]
unicode_char_dash   = [^"\""\n\\]

unicode_letter = [:letter:]
unicode_digit  = [:digit:]

int_lit     = {decimal_lit} | {octal_lit} | {hex_lit}
decimal_lit = [1-9] {decimal_digit}*
octal_lit   = "0"  {octal_digit}*
hex_lit     = "0" ( "x" | "X" ) {hex_digit} {hex_digit}*

float_lit = {decimals} "." {decimals}? {exponent}? | {decimals} {exponent} | "." {decimals} {exponent}?
decimals  = {decimal_digit}  {decimal_digit}*
/* ##################################### why not digit+ ########################################################### */
exponent  = ( "e" | "E" ) ("+" | "-")? {decimals}

imaginary_lit = ({decimals} | {float_lit}) "i"

rune_lit         = "'" ( {unicode_value} | {byte_value} ) "'"
unicode_value    = {unicode_char} | {little_u_value} | {big_u_value} | {escaped_char}
unicode_value_dash    = {unicode_char_dash} | {little_u_value} | {big_u_value} | {escaped_char}
byte_value       = {octal_byte_value} | {hex_byte_value}
octal_byte_value = "\\" {octal_digit} {octal_digit} {octal_digit}
hex_byte_value   = "\\" "x" {hex_digit} {hex_digit}
little_u_value   = "\\" "u" {hex_digit} {hex_digit} {hex_digit} {hex_digit}
big_u_value      = "\\" "U" {hex_digit} {hex_digit} {hex_digit} {hex_digit}
                          {hex_digit} {hex_digit} {hex_digit} {hex_digit}
escaped_char     = "\\" ( "a" | "b" | "f" | "n" | "r" | "t" | "v" | "\\" | "'" | "\"" )
/* ##################################### weird quotes up and down here ########################################################### */

string_lit             = {raw_string_lit} | {interpreted_string_lit}
raw_string_lit         = "'" ( {unicode_char} | {newline} )* "'" /////////////ticks were here
interpreted_string_lit = "\"" ( {unicode_value_dash} | {byte_value}  )* "\""

/* $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ NOT IN GO SPECIFICATIONS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = {GeneralComment} | {LineComment}

GeneralComment   = "/*"([^*]|\*+[^*/])*\*+"/"
// Comment can be the last line of the file, without line terminator.
LineComment     = "//" {InputCharacter}* {LineTerminator}?

/* LAST MOMENT ADDITIONS */



%%

/*-----------------------------------------------------------  KEYWORDS --------------------------------------------------------  */

<YYINITIAL> { 
"func" {  return symbol(sym.funcd); }
"break" { return symbol(sym.breakd); }
"default" return symbol(sym.defaultd); }
"interface" { return symbol(sym.interfaced); }
"select" { return symbol(sym.select); }
"case" { return symbol(sym.cased); }
"defer" { return symbol(sym.defer); }
"go" { return symbol(sym.go); }
"map" { return symbol(sym.map); }
"struct" { return symbol(sym.struct); }
"chan" { return symbol(sym.chan); }
"else" { return symbol(sym.elsed); }
"goto" { return symbol(sym.gotod); }
"package" { return symbol(sym.packaged); }  // notice the little devil !!!
"switch" { return symbol(sym.switchd); }
"const" { return symbol(sym.constd); }
"fallthrough" { return symbol(sym.fallthrough); }
"if" { return symbol(sym.ifd); }
"range" { return symbol(sym.range); }
"type" { return symbol(sym.type); }
"continue" { return symbol(sym.continued); }
"for" { return symbol(sym.ford); }
"import" { return symbol(sym.importd); }
"return" { return symbol(sym.returnd); }
"var" { return symbol(sym.var); }

/********************************************PREDEFINED TYPES*****************************************/
/*"bool" |
"byte" |
"complex64" |
"complex128" |
"error" |
"float32" |
"float64" |
"int" |
"int8" |
"int16" |
"int32" |
"int64" |
"rune" |
"string" |
"uint" |
"uint8" |
"uint16" |
"uint32" |
"uint64" |
"uintptr" { gprint(5);}*/

/********************************************PREDEFINED CONSTANTS *****************************************/

/*"true"|
"false"|
"iota" { gprint(6);}

"nil" { gprint(7);}

"append" |
"cap" |
"close" |
"complex" |
"copy" |
"delete" |
"imag" |
"len" |
"make" |
"new" |
"panic" |
"print" |
"println" |
"real" |
"recover" { gprint(8);}*/

}



/*  ----------------------------------------------------- IDENTIFIERS & LITERALS --------------------------------------------------  */

<YYINITIAL> {
  {identifier} { return symbol(sym.identifier, yytext()); }// gprint(1); }
  {int_lit} { return symbol(sym.int_lit, yytext()); }//gprint(41); } 
  {float_lit} { return symbol(sym.float_lit, yytext()); }//gprint(42); } 
  {imaginary_lit} { return symbol(sym.imaginary_lit, yytext()); }//gprint(43); }  
  {rune_lit} { return symbol(sym.rune_lit, yytext()); }//gprint(44); } 
  {string_lit} { return symbol(sym.string_lit, yytext()); }//gprint(45); }
}

/*  -----------------------------------------------------OPERATORS & DELIMITERS --------------------------------------------------  */

<YYINITIAL> { 
"+" {return symbol(sym.plus_op);}
"?" {return symbol(sym.inter_op);}
"&" {return symbol(sym.amp_op);}
//"+=" |  // would be dealt in the parser as assign_op
//"&=" |
"&&" {return symbol(sym.and_op);}
"==" {return symbol(sym.equal_equal_op);}
"!=" {return symbol(sym.not_equal_op);}
"(" {return symbol(sym.open_brac);}
")" {return symbol(sym.close_brac);}
"-" {return symbol(sym.minus_op);}
"|" {return symbol(sym.pipe_op);}
//"-=" |
//"|=" |
"||" {return symbol(sym.or_op);}
"<" {return symbol(sym.less_op);}
"<=" {return symbol(sym.less_equal_op);}
"[" {return symbol(sym.open_square_brac);}
"]" {return symbol(sym.close_square_brac);}
"*" {return symbol(sym.star_op);}
"^" {return symbol(sym.pow_op);}
//"*=" |
//"^=" |
"<-" {return symbol(sym.chan_op);}
">" {return symbol(sym.greater_op);}
">=" {return symbol(sym.greater_equal_op);}
"{" {return symbol(sym.open_curly_brac);}
"}" {return symbol(sym.close_curly_brac);}
"/" {return symbol(sym.div_op);}
"<<" {return symbol(sym.left_shift_op);}
//"/=" |
//"<<=" |
"++" {return symbol(sym.inc_op);}
"=" {return symbol(sym.equal);}
":="  {return symbol(sym.short_ass);}
"," {return symbol(sym.comma);}
";" {return symbol(sym.semicolon);}
"%" {return symbol(sym.mod_op);}
">>" {return symbol(sym.right_shift_op);}
//"%=" |
//">>=" |
"--"  {return symbol(sym.dec_op);}
"!" {return symbol(sym.not_op);}
"..." {return symbol(sym.tri_dot);}
"." {return symbol(sym.dot);}
":" {return symbol(sym.colon);}
//"&^=" |
"&^" {return symbol(sym.amp_pow_op);}
"?" {return symbol(sym.inter);}
}

/*  ----------------------------------------------------- SKIP CHARACTERS --------------------------------------------------  */

<YYINITIAL> { 
  {Comment}                      { /* ignore */ }
  /*\n                             {append_tokens_to_file();}*/
  {WhiteSpace}                   { /* ignore */ gprint(9); }
  /* error fallback */
  {illegal_identifier}           { gprint(-2); }
  [^]                            { gprint(-1);/*Illegeal Character*/ }

}

