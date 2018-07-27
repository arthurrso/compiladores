package GOType;
import java.io.*;
import java.util.*; 

public class GoConstants
{
	public static List<String> GODATATYPES = Arrays.asList("uint", "uint8", "uint16", "uint32", "uint64",
						"int",		"int8",		"int16",		"int32", 	"int64",
						"float32",	"float64", 	"complex64",	"complex128",
						"byte",		"rune",		"bool",			",uintptr",
						"string"
		);

	public static List<String> GONUMERICTYPES = Arrays.asList("uint", "uint8", "uint16", "uint32", "uint64",
						"int",		"int8",		"int16",		"int32", 	"int64",
						"float32",	"float64", 	"complex64",	"complex128",
						"byte"
		);

	public static List<String> GOINTEGRALNUMERICTYPES = Arrays.asList("uint", "uint8", "uint16", "uint32", "uint64",
						"int",		"int8",		"int16",		"int32", 	"int64"
		);

	public static List<String> GOKEYWORDS = Arrays.asList( "break", "default", "func", "interface",
						"select",  		"case",     "defer",        "go",
				      	"map",     		"struct",   "chan",		    "else",
		      	        "goto",    		"package",  "switch",       "const",
	      	            "fallthrough",  "if",       "range",	    "type",
						"continue",		"for",      "import",       "return",  
						"var",			"error");

	public static List<String> GOCONSTANTS = Arrays.asList("true", "false", "iota", "nil");

	public static List<String> GOFUNCTIONS = Arrays.asList("append", "cap", "close", "complex", 
						"copy", 	"delete", 	"imag", 	"len",
						"make", 	"new", 		"panic", 	"print", 
						"println", 	"real", 	"recover");

	public static List<String> THREEACRESERVED = Arrays.asList("ret","goto","push","import","package","call");
	public static List<String> REGISTERNAMES = Arrays.asList("eax","ebx","ecx","edx","edi","esi");//,"esp","ebp");
	public static boolean checkIfRegister(String s)
	{
		if(REGISTERNAMES.contains(s))
			return true;
		return false;
	}
	
	public static boolean checkIfTacReserved(String s)
	{
		if( THREEACRESERVED.contains(s))
			return true;
		return false;
	}
	public static boolean checkIfKeyword(String s)
	{
		// returns true if s is a reserved keyword
		// if ( GODATATYPES.contains(s) )
		// 	return true;
		if(THREEACRESERVED.contains(s))
			return true;
		
		if ( GOKEYWORDS.contains(s) )
			return true;

		// if ( GOCONSTANTS.contains(s) )
		// 	return true;

		if ( GOFUNCTIONS.contains(s) )
			return true;

		return false;
	}

	public static boolean checkIfNumeric(String s)
	{

		if ( GONUMERICTYPES.contains(s) )
			return true;

		return false;
	}

	public static boolean checkIfIntegralNumeric(String s)
	{

		if ( GOINTEGRALNUMERICTYPES.contains(s) )
			return true;

		return false;
	}
	
}
