package GOType;
import java.io.*;
import java.util.*;

public class GoPrimaryExpr
{
	public Object obj1;		// Operand,  PrimaryExpr
	public Object obj2;		// Selector, Index
	/*GoPrimaryExpr(GoPrimaryExpr primaryExpr, GoOperand operand)
	{
		this.obj1 = primaryExpr;
		this.obj2 = operand;
	}*/
	GoPrimaryExpr(GoPrimaryExpr primaryExpr, GoSelector selector)
	{
		this.obj1 = primaryExpr;
		this.obj2 = selector;
		// gen();
	}
	public GoPrimaryExpr(GoPrimaryExpr primaryExpr, GoIndex index)
	{
		this.obj1 = primaryExpr;
		this.obj2 = index;
		// gen();
	}
	public GoPrimaryExpr(GoOperand operand)
	{
		this.obj1 = operand;
		this.obj2 = null;
		// gen();
	}
	/*GoPrimaryExpr(GoSelector selector)
	{
		this.obj1 = null;
		this.obj2 = selector;
	}
	GoPrimaryExpr(GoIndex index)
	{
		this.obj1 = null;
		this.obj2 = index;
	}*/
	public void gen()
	{
		if ( obj1 != null && obj1 instanceof GoPrimaryExpr )
		{
			((GoPrimaryExpr)obj1).gen();
		}
		else if ( obj1 != null &&  obj1 instanceof GoOperand )
		{
			((GoOperand)obj1).gen();
		}

		if ( obj2 instanceof GoSelector )
		{
			((GoSelector)obj2).gen();
		}
		else if ( obj2 instanceof GoIndex )
		{
			((GoIndex)obj2).gen();
		}
	}
	public String get_type()
	{
		if(obj1 instanceof GoPrimaryExpr)
		{
			// System.out.println( " In PrimaryExpr.java GoPrimaryExpr.get_type "+((GoPrimaryExpr)obj1).get_type() );
			return ((GoPrimaryExpr)obj1).get_type();
		}
		else if( obj1 instanceof GoOperand)
		{
			// System.out.println( " In PrimaryExpr.java GoOperand.get_type "+((GoOperand)obj1).get_type() );
			return ((GoOperand)obj1).get_type();
		}
		// System.out.println( " In PrimaryExpr.java null.get_type "+"null");
		return null;

	}
	public String get_identifier()
	{
		if(obj1 instanceof GoPrimaryExpr)
		{
			if(obj2!=null && obj2 instanceof GoIndex)
				return ((GoPrimaryExpr)obj1).get_identifier();//+"["+ ((GoIndex)this.obj2).expr.index +"]"; //Send identifierName[expr.index]
		}
		else if( obj1 instanceof GoOperand)
		{
			return ((GoOperand)obj1).get_identifier();
		}
		return null;
	}
}