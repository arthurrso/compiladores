package GOType;
import java.io.*;
import java.util.*;

public class GoIfStmt
{
	public GoExpr expr;
	public GoIfStmt recIf;
	public boolean elseFlag;
	public GoIfStmt(GoExpr expr, GoIfStmt ifstmt, boolean flag)
	{
		this.expr = expr;
		this.recIf = ifstmt;
		this.elseFlag = flag;
		// gen();
	}
	GoIfStmt(GoExpr expr, GoIfStmt ifstmt)
	{
		this.expr = expr;
		this.recIf = ifstmt;
		this.elseFlag = false;
		// gen();
	}
	public GoIfStmt(GoExpr expr, boolean flag)
	{
		this.expr = expr;
		this.elseFlag = flag;
		// gen();
	}
	public GoIfStmt(GoExpr expr)
	{
		this.expr = expr;
		this.elseFlag = false;
		// gen();
	}

	public void gen()
	{
		System.out.println("Inside GoIfStmt");
		

		if (expr!=null) 
		{
			expr.gen();	
		}

		if (elseFlag) {
			System.out.println("Else is present with the if statement");
		}
		
		if(recIf!=null)
		{
			recIf.gen();
		}

		
	}
}