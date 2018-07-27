package GOType;
import java.io.*;
import java.util.*;

public class GoForStmt
{
	public String forStart;
	public String forBlock;
	public String update;
	public String outOfFor;

	GoForStmt()
	{
		// gen();
	}
	public GoForStmt(String start, String up, String block, String out)
	{
		this.forStart = start;
		this.forBlock = block;
		this.outOfFor = out;
		this.update = up;
	}

	public void gen()
	{
		System.out.println("Inside GoForStmt");
		System.out.println(forStart+" "+update+" "+forBlock+" "+outOfFor);
		
	
	}
}