package GOType;
import java.io.*;
import java.util.*;

public class GoIndex
{
	public GoExpr expr;
	public GoIndex(GoExpr expr)
	{
		this.expr = expr;
		// gen();
	}
	public void gen()
	{
		System.out.println("Inside GoIndex");
		System.out.println("[");
		expr.gen();
		System.out.println("]");
	}

}
