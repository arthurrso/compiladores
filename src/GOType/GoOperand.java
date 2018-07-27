package GOType;import java.io.*;
import java.util.*;

public class GoOperand
{
	public Object obj;	// can be ArrayType, TypeName, BasicLit, Expression
	public GoLiteralValue litVal;	// comes only with ArrayType and TypeName
	public String type;
	public GoOperand(GoArrayType arrayType, GoLiteralValue litVal)
	{
		this.obj = arrayType;
		this.litVal = litVal;
		this.type = ((GoTypeName)(arrayType.type.obj)).typeName;
		// System.out.println( "Creating operand with datatype1 "+type );
		// gen();
	}
	GoOperand(GoTypeName typeName, GoLiteralValue litVal)
	{
		this.obj = typeName;
		this.litVal = litVal;
		this.type =  typeName.typeName;
		// System.out.println( "Creating operand with datatype2 "+type );

		// gen();
	}
	public GoOperand(String basicLit,String type)
	{
		this.obj = basicLit;
		this.litVal = null;
		this.type = type;
		// System.out.println( "Creating operand with datatype3 "+type );

		// gen();
	}
	public GoOperand(GoTypeName typeName)
	{
		this.obj = typeName;
		this.litVal = null;
		this.type = typeName.typeName;
		// System.out.println( "Creating operand with datatype4 "+type );

		// gen();
	}
	public GoOperand(GoExpr expr)
	{
		this.obj = expr;
		this.litVal = null;
		this.type= expr.get_type();
		// System.out.println( "Creating operand with datatype5 "+type );

		// gen();
	}
	public void gen()
	{
		if ( obj instanceof String )	// caught a basic literal
		{
			System.out.println("Inside BasicLit "+obj);
		}
		else if ( obj instanceof GoArrayType )
		{
			((GoArrayType)obj).gen();
		}
		else if ( obj instanceof GoTypeName )
		{
			((GoTypeName)obj).gen();
		}
		else if ( obj instanceof GoExpr )
		{
			((GoExpr)obj).gen();
		}

		if ( litVal != null) 
		{
			litVal.gen();
		}
	}
	public String get_type()
	{
		return this.type;	
	}
	public String get_identifier()
	{
		if ( obj instanceof GoTypeName )
		{
			return ((GoTypeName)obj).typeName;
		}
		else if ( obj instanceof GoExpr )
		{
			// ((GoExpr)obj).gen();
			return ((GoExpr)obj).get_identifier();
		}
		return null;
	}

}