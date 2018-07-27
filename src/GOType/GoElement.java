package GOType;
import java.io.*;
import java.util.*;

public class GoElement
{
	public GoValue val;
	public Object obj;	// Expression, identifier, NULL
	GoElement(GoValue val, GoExpr expr)
	{
		this.val = val;
		this.obj = expr;
		// gen();
	}
	GoElement(GoValue val, String id)
	{
		this.val = val;
		this.obj = id;
		// gen();
	}
	public GoElement(GoValue val)
	{
		this.val = val;
		this.obj = null;
		// gen();
	}
	public void gen()
	{
		val.gen();
		if ( obj == null )
		{
			// do nothing
		}
		else if ( obj instanceof String )	// got an identifier
		{
			System.out.println("Inside GoElement "+obj);
		}
		else
		{
			((GoExpr)obj).gen();
		}
	}
}