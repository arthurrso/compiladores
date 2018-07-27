package GOType;import java.io.*;
import java.util.*;

public class GoUnaryExpr
{
	public Object obj;  // UnaryExpr, PrimaryExpr
	public String unOp;
	public int index;
	public GoUnaryExpr(GoUnaryExpr unaryExpr, String unOp, int i)
	{
		this.obj = unaryExpr;
		this.unOp = unOp;
		index=i;
		// gen();
	}
	public GoUnaryExpr(GoPrimaryExpr primaryExpr,int i)
	{
		this.obj = primaryExpr;
		index=i;
		// this.unOp = null;
		// gen();
	}
	public void gen()
	{
		System.out.println("Inside GoUnaryExpr");
		System.out.println(unOp);
		if ( obj instanceof GoUnaryExpr )	// caught a basic literal
		{
			if ( obj != null )
				((GoUnaryExpr)obj).gen();
		}
		else if ( obj instanceof GoPrimaryExpr )
		{
			if ( obj != null )
				((GoPrimaryExpr)obj).gen();
		}
	}
	public String get_type()
	{
		if( obj instanceof GoUnaryExpr)
		{
			return ((GoUnaryExpr)obj).get_type();
		}
		else if ( obj instanceof GoPrimaryExpr )
		{
			return ((GoPrimaryExpr)obj).get_type();
		}
		return null;
		// return "int";
	}
	public String get_identifier()
	{
		if( obj instanceof GoUnaryExpr)
		{
			return ((GoUnaryExpr)obj).get_identifier();
		}
		else if ( obj instanceof GoPrimaryExpr )
		{
			return ((GoPrimaryExpr)obj).get_identifier();
		}
		return null;
	}
}