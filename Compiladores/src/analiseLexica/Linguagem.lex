0package analiseLexica;

%%

%{

private void imprimir(String descricao, String lexema) {
    System.out.println(lexema + " - " + descricao);
}

%}

%class AnalisadorLexico
%type void

SOMA = "+"
SUBTRACAO = "-"
MULTIPLICACAO = "*"
DIVISAO = "/"
RESTO = "%"

IDENTIFICADOR = "main"
AND = "&"
OR = "|"
XOR = "^"
SHIFT_LEFT = "<<"
SHIFT_RIGHT = ">>"
AND_NOT = "&^"

ATRIBUICAO_SOMA = "+="
ATRIBUICAO_SUB = "-="
ATRIBUICAO_MULT = "*="
ATRIBUICAO_DIV = "/="
ATRIBUICAO_RESTO = "%="

ATRIBUICAO_AND = "&="
ATRIBUICAO_OR = "|="
ATRIBUICAO_XOR = "^="
ATRIBUICAO_SL = "<<="
ATRIBUICAO_SR = ">>="
ATRICUICAO_AND_NOT = "&^="

LAND = "&&"
LOR = "||"
ARROW = "<-"
INC = "++"
DEC = "--"

IGUAL = "=="
MAIOR_QUE = ">"
MENOR_QUE = "<"
ATRIBUICAO = "="
NOT = "!"

DIFERENTE = "!="
MENOR_IGUAL = "<="
MAIOR_IGUAL = ">="
DEFINE = ":="
ELLIPSIS = "..."

PARENESQ = "("
PARENDIR = ")"
CHAVEESQ = "["
CHAVEDIR = "]"
COLCHESQ = "{"
COLCHDIR = "}"
VIRGULA = ","
PONTO = "."
DOISPONTOS = ":"
PONTOVIRGULA = ";"
APOSTROFO = "`"
ASPAS = """

BREAK = "break"
CASE = "case"
CHAN = "chan"
CONST = "const"
CONTINUE = "continue"

DEFAULT = "default"
DEFER = "defer"
ELSE = "else"
FALLTHROUGH = "fallthrough"
FOR = "for"

FUNC = "func"
GO = "go"
GOTO = "goto"
IF = "if"
IMPORT = "import"

INTERFACE = "interface"
MAP = "map"
PACKAGE = "package"
RANGE = "range"
RETURN = "return"

SELECT = "select"
STRUCT = "struct"
SWITCH = "switch"
TYPE = "type"
VAR = "var"

TIPOBOOL = "bool"
TIPOINT = "int"
TIPOINT8 = "int8"
TIPOINT16 = "int16"
TIPOINT32 = "int32"
TIPOINT64 = "int64"
TIPOUINT = "uint"
TIPOUINT8 = "uint8"
TIPOUINT16 = "uint16"
TIPOUINT32 = "uint32"
TIPOUINT64 = "uint64"
TIPOUINTPTR = "uintptr"
TIPOFLOAT32 = "float32"
TIPOFLOAT64 = "float64"
TIPOCOMPLEX64 = "complex64"
TIPOCOMPLEX128 = "complex128"
TIPOSTRING = "string"
POINTER = "Pointer"
UNTYPEDBOOL = "untyped bool"
UNTYPEDINT = "untyped int"
UNTYPEDRUNE = "untyped rune"
UNTYPEDFLOAT = "untyped float"
UNTYPEDCOMPLEX = "untyped complex"
UNTYPEDSTRING = "untyped string"
UNTYPEDNIL = "untyped nil"

FORMATSTRING  = "%s"
FORMATINTEGER = "%d"
FORMATFLOAT = "%f"
FORMATBOOL = "%t"
FORMATDEFAULT = "%v"
FORMATVALOR = "%#v"
FORMATTYPE = "%T"
FORMATPERCENT  = "%%"
FORMATPOINTER = "%p"
FORMATUNDEFINED = "%x"

INICIOCOMENT = "/*"
FINALCOMENT = "*/"
EOF = "EOF"

BRANCO = [\n| |\t|\r]
BOOL = (true|false)
INTEIRO = [+-]?[1-9][0-9]*
FLOAT = [+-]?(0|[1-9]*[.])?[0-9]+
ID = [_|a-z|A-Z][a-z|A-Z|0-9|_]*

%%
{SOMA}                         { imprimir("Operador de soma", yytext()); }
{SUBTRACAO}                         { imprimir("Operador de subtracao", yytext()); }
{MULTIPLICACAO}                         { imprimir("Operador de multiplicacao", yytext()); }
{DIVISAO}                         { imprimir("Operador de divisao", yytext()); }
{RESTO}                         { imprimir("Operador de resto", yytext()); }

{IDENTIFICADOR}                     { imprimir("Identificador de main", yytext()); }
{AND}                     { imprimir("Operador and", yytext()); }
{OR}                     { imprimir("Operador or", yytext()); }
{XOR}                     { imprimir("Operador xor", yytext()); }
{SHIFT_LEFT}                     { imprimir("Operador shift left", yytext()); }
{SHIFT_RIGHT}                     { imprimir("Operador shift right", yytext()); }
{AND_NOT}                     { imprimir("Operador and not", yytext()); }

{ATRIBUICAO_SOMA}                     { imprimir("Atribuicao de soma", yytext()); }
{ATRIBUICAO_SUB}                     { imprimir("Atribuicao de subtracao", yytext()); }
{ATRIBUICAO_MULT}                     { imprimir("Atribuicao de multiplicacao", yytext()); }
{ATRIBUICAO_DIV}                     { imprimir("Atribuicao de divisao", yytext()); }
{ATRIBUICAO_RESTO}                     { imprimir("Atribuicao de resto", yytext()); }

{ATRIBUICAO_AND}                     { imprimir("Atribuicao de and", yytext()); }
{ATRIBUICAO_OR}                     { imprimir("Atribuicao de or", yytext()); }
{ATRIBUICAO_XOR}                     { imprimir("Atribuicao de xor", yytext()); }
{ATRIBUICAO_SL}                     { imprimir("Atribuicao de sl", yytext()); }
{ATRIBUICAO_SR}                     { imprimir("Atribuicao de sr", yytext()); }
{ATRICUICAO_AND_NOT}                     { imprimir("Atribuicao de and not", yytext()); }

{LAND}                     { imprimir("Opeerador land", yytext()); }
{LOR}                     { imprimir("Operador lor", yytext()); }
{ARROW}                     { imprimir("Operador arrow", yytext()); }
{INC}                     { imprimir("Operador de incremento", yytext()); }
{DEC}                     { imprimir("Operador de decremento", yytext()); }

{IGUAL}                     { imprimir("Operador de igualdade", yytext()); }
{MAIOR_QUE}                     { imprimir("Operador de maior que", yytext()); }
{MENOR_QUE}                     { imprimir("Operador de menor que", yytext()); }
{ATRIBUICAO}                     { imprimir("Operador de atribuicao", yytext()); }
{NOT}                     { imprimir("Operador de negacao", yytext()); }

{DIFERENTE}                     { imprimir("Operador de diferente", yytext()); }
{MENOR_IGUAL}                     { imprimir("Operador de menor igual", yytext()); }
{MAIOR_IGUAL}                     { imprimir("Operador de maior igual", yytext()); }
{DEFINE}                     { imprimir("Operador de define", yytext()); }
{ELLIPSIS}                     { imprimir("Operador de elipse", yytext()); }

{PARENESQ}                     { imprimir("Caractere parentese esquerdo", yytext()); }
{PARENDIR}                     { imprimir("Caractere parentese direito", yytext()); }
{CHAVEESQ}                     { imprimir("Caractere chave esquerda", yytext()); }
{CHAVEDIR}                     { imprimir("Caractere chave direita", yytext()); }
{COLCHESQ}                     { imprimir("Caractere colchete esquerdo", yytext()); }
{COLCHDIR}                     { imprimir("Caractere colchete direito", yytext()); }
{VIRGULA}                     { imprimir("Caractere virgula", yytext()); }
{PONTO}                     { imprimir("Caractere ponto", yytext()); }
{DOISPONTOS}                     { imprimir("Caractere dois pontos", yytext()); }
{PONTOVIRGULA}                     { imprimir("Caractere ponto e virgula", yytext()); }
{APOSTROFO}                     { imprimir("Caractere apostrofo", yytext()); }
{ASPAS}                     { imprimir("Caractere aspas", yytext()); }

{BREAK}                     { imprimir("Palavra reservada break", yytext()); }
{CASE}                     { imprimir("Palavra reservada case", yytext()); }
{CHAN}                     { imprimir("Palavra reservada chan", yytext()); }
{CONST}                     { imprimir("Palavra reservada const", yytext()); }
{CONTINUE}                     { imprimir("Palavra reservada continue", yytext()); }

{DEFAULT}                     { imprimir("Palavra reservada default", yytext()); }
{DEFER}                     { imprimir("Palavra reservada defer", yytext()); }
{ELSE}                     { imprimir("Palavra reservada else", yytext()); }
{FALLTHROUGH}                     { imprimir("Palavra reservada fallthrough", yytext()); }
{FOR}                     { imprimir("Palavra reservada for", yytext()); }

{FUNC}                     { imprimir("Palavra reservada func", yytext()); }
{GO}                     { imprimir("Palavra reservada go", yytext()); }
{GOTO}                     { imprimir("Palavra reservada goto", yytext()); }
{IF}                     { imprimir("Palavra reservada if", yytext()); }
{IMPORT}                     { imprimir("Palavra reservada import", yytext()); }

{INTERFACE}                     { imprimir("Palavra reservada interface", yytext()); }
{MAP}                     { imprimir("Palavra reservada map", yytext()); }
{PACKAGE}                     { imprimir("Palavra reservada package", yytext()); }
{RANGE}                     { imprimir("Palavra reservada range", yytext()); }
{RETURN}                     { imprimir("Palavra reservada return", yytext()); }

{SELECT}                     { imprimir("Palavra reservada select", yytext()); }
{STRUCT}                     { imprimir("Palavra reservada struct", yytext()); }
{SWITCH}                     { imprimir("Palavra reservada switch", yytext()); }
{TYPE}                     { imprimir("Palavra reservada type", yytext()); }
{VAR}                     { imprimir("Palavra reservada var", yytext()); }

{TIPOBOOL} = "bool"                     { imprimir("Tipo de variável bool", yytext()); }
{TIPOINT} = "int"                     { imprimir("Tipo de variável int", yytext()); }
{TIPOINT8} = "int8"                     { imprimir("Tipo de variável int 8bits", yytext()); }
{TIPOINT16} = "int16"                     { imprimir("Tipo de variável int 16bits", yytext()); }
{TIPOINT32} = "int32"                     { imprimir("Tipo de variável int 32bits", yytext()); }
{TIPOINT64} = "int64"                     { imprimir("Tipo de variável int 64bits", yytext()); }
{TIPOUINT} = "uint"                     { imprimir("Tipo de variável int não-definido", yytext()); }
{TIPOUINT8} = "uint8"                     { imprimir("Tipo de variável int não-definido de 8bits", yytext()); }
{TIPOUINT16} = "uint16"                     { imprimir("Tipo de variável int não-definido de 16bits", yytext()); }
{TIPOUINT32} = "uint32"                     { imprimir("Tipo de variável int não-definido de 32bits", yytext()); }
{TIPOUINT64} = "uint64"                     { imprimir("Tipo de variável int não-definido de 64bits", yytext()); }
{TIPOUINTPTR} = "uintptr"                     { imprimir("Tipo de variável int ", yytext()); }
{TIPOFLOAT32} = "float32"                     { imprimir("Tipo de variável float 32bits", yytext()); }
{TIPOFLOAT64} = "float64"                     { imprimir("Tipo de variável float 64bits", yytext()); }
{TIPOCOMPLEX64} = "complex64"                     { imprimir("Tipo de variável numero complexo de 64bits", yytext()); }
{TIPOCOMPLEX128} = "complex128"                     { imprimir("Tipo de variável numero complexo de 128bits", yytext()); }
{TIPOSTRING} = "string"                     { imprimir("Tipo de variável string", yytext()); }
{POINTER} = "Pointer"                     { imprimir("Tipo de variável apontador", yytext()); }
{UNTYPEDBOOL} = "untyped bool"                     { imprimir("Tipo de variável untyped bool", yytext()); }
{UNTYPEDINT} = "untyped int"                     { imprimir("Tipo de variável untyped int", yytext()); }
{UNTYPEDRUNE} = "untyped rune"                     { imprimir("Tipo de variável untyped rune", yytext()); }
{UNTYPEDFLOAT} = "untyped float"                     { imprimir("Tipo de variável untyped float", yytext()); }
{UNTYPEDCOMPLEX} = "untyped complex"                     { imprimir("Tipo de variável untyped complex", yytext()); }
{UNTYPEDSTRING} = "untyped string"                     { imprimir("Tipo de variável untyped string", yytext()); }
{UNTYPEDNIL} = "untyped nil"                     { imprimir("Tipo de variável untyped nil", yytext()); }

{FORMATSTRING}  = "%s"                     { imprimir("Forrmato string", yytext()); }
{FORMATINTEGER} = "%d"                     { imprimir("Forrmato inteiro", yytext()); }
{FORMATFLOAT} = "%f"                     { imprimir("Forrmato float", yytext()); }
{FORMATBOOL} = "%t"                     { imprimir("Forrmato boolean", yytext()); }
{FORMATDEFAULT} = "%v"                     { imprimir("Forrmato default", yytext()); }
{FORMATVALOR} = "%#v"                     { imprimir("Forrmato valor", yytext()); }
{FORMATTYPE} = "%T"                     { imprimir("Forrmato tipo generico", yytext()); }
{FORMATPERCENT}  = "%%"                     { imprimir("Forrmato porcento", yytext()); }
{FORMATPOINTER} = "%p"                     { imprimir("Forrmato apontador", yytext()); }
{FORMATUNDEFINED} = "%x"                     { imprimir("Forrmato indefinido", yytext()); }

{INICIOCOMENT} = "/*"                     { imprimir("Inicio do comentario", yytext()); }
{FINALCOMENT} = "*/"                     { imprimir("Final do comentario", yytext()); }
{EOF} = "EOF"                     { imprimir("Palavra reservada EOF var", yytext()); }

{INTEIRO}                     { imprimir("Número Inteiro", yytext()); }
{FLOAT}                     { imprimir("Número Float", yytext()); }
{BOOL}                     { imprimir("Valor boolean", yytext()); }
{BRANCO}                     { imprimir("Espaço em branco", yytext()); }
{ID}                         { imprimir("Identificador", yytext()); }

. { throw new RuntimeException("Caractere inválido " + yytext()); }