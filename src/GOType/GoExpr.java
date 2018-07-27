package GOType;
import java.util.*;

/*public enum UnOp 
{
    "+", "-",  "!", "^", "*", "&"
}

public enum BinOp
{
	"||",
	"&&",
	"==", "!=", "<", "<=", ">", ">=",
	"+", "-", "|", "^",
	"*", "/", "%", "<<", ">>", "&", "&^"
}*/

public class GoExpr
{
	public GoExpr expr;
	// public GoExprUnn exprUnn;
	public GoExpr expr2;
	public GoUnaryExpr unaryExpr; 
	public int index;

	GoExpr(GoExpr expr, GoUnaryExpr unaryExpr, int index)
	{
		this.expr = expr;
		this.expr2 = null;
		this.unaryExpr = unaryExpr;
		this.index = index;
		// gen();
	}
	public GoExpr( GoUnaryExpr unaryExpr, int index)
	{
		this.expr = null;
		this.expr2 = null;
		this.unaryExpr = unaryExpr;
		this.index = index;
		// gen();
	}
	public GoExpr( GoExpr expr, GoExpr expr2, int index)
	{
		this.unaryExpr = null;
		this.expr = expr;
		this.expr2 = expr2;
		this.index = index;
		// gen();
	}
	public void gen()
	{
		if ( unaryExpr == null )
		{
			System.out.println("@@@@@");
		}
		else
		{
			unaryExpr.gen();
		}
		if ( expr == null )
		{
			System.out.println("#####");
		}
		else
		{
			expr.gen();
		}
		if ( expr2 == null )
		{
			System.out.println("#####");
		}
		else
		{
			expr2.gen();
		}		
	}
	public String get_type()
	{
		if ( unaryExpr == null && expr2 == null && expr == null )
		{
			// System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZz");
		}

		if ( unaryExpr == null )
		{
			// System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  1");
			if ( expr2 == null )
			{
				// System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  2");
				return expr.get_type();
			}
			else if ( expr == null )
			{
				// System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  3");
				return expr2.get_type();
			}
			else if ( expr != null && expr2 != null )
			{
				String a1 = expr.get_type();
				String a2 = expr2.get_type();

				if ( a1.equals(a2) == true )
				{
					return a1;
				}
				else
				{
					return a1+":"+a2;
					// System.out.println("ERROR: "+a1+" type does not match "+a2+" type");
				}
			}
			else
			{
				// System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  4");
				return "CRAP";
			}
				
		}
		// System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ  5");
		return unaryExpr.get_type();
	}
	public String get_identifier()
	{
		if ( unaryExpr != null && unaryExpr.get_identifier() != null )
			return unaryExpr.get_identifier();

		if ( expr != null && expr.get_identifier() != null )
			return expr.get_identifier();

		if ( expr2 != null && expr2.get_identifier() != null )
			return expr2.get_identifier(); 

		return "CRAP2";
	}
	
}