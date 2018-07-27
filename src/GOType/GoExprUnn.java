package GOType;
import java.io.*;
import java.util.*;

public class GoExprUnn 
{
	public GoUnaryExpr unaryExpr;
	public String binOp;
	public GoExprUnn exprUnn;
	GoExprUnn(GoUnaryExpr unaryExpr, String binOp, GoExprUnn exprUnn)
	{
		this.unaryExpr = unaryExpr;
		this.binOp = binOp;
		this.exprUnn = exprUnn;
		// gen();
		
	}
	GoExprUnn()
	{
		this.unaryExpr = null;
		// this.binOp = null;
		this.exprUnn = null;
		// gen();
	}
	public void gen()
	{
		if ( unaryExpr != null )
		{
			System.out.println(binOp);
			unaryExpr.gen();
			if ( exprUnn != null )
				exprUnn.gen();
		}
	}
}