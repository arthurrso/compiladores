package Util;import java.io.*;
import java.util.*;

import GOType.GoConstants;
public class Tac
{
	public String res;
	public String op1;
	public String op2;
	public String opr;

	public Tac()
	{
		res=null;
		op1=null;
		op2=null;
		opr=null;

	}
	Tac(String r, String op, String o1, String o2)
	{
		res=r;
		op1=o1;
		op2=o2;
		opr=op;
	}

	

	public int push_empty(String newval)
	{
		if(op1==null)
			op1=newval;
		else if(op2==null)
			op2 = newval;
		else
			return -1;
		return 0;
	}
	public String get_filled()
	{
		if(op1==null)
			return op2;
		else if(op2==null)
			return op1;
		// else
			return null;
		// return 0;
	}
	public void print_tac()
	{

		// System.out.println("****************TAC HERE***************");
		/*if(res.equals("<BLOCK START>"))
			System.out.println("");*/
		System.out.print(res);


		if ( op1 == null && op2 == null && opr == null )
		{
			System.out.println();
			return;
		}
		if ( opr == null )
		{
			System.out.print(" =");
		}
		else if ( opr.matches("env<([0-9])*>") ||  opr == "goto" || GoConstants.checkIfTacReserved(res) )
		{
			 // do nothing
		}
		else
		{
			System.out.print(" =");	// since opr is not null
		}
		
		if ( op1 != null )
		{
			System.out.print(" "+op1);	
		}
		if ( opr != null && opr != "=" )
		{
			System.out.print(" "+opr);
		}
		if ( op2 != null )
			System.out.print(" "+op2);

		System.out.println();
		// System.out.println("****************TAC GOING***************");
	}

	public void print_tac_machine()
  	{

    // System.out.println("****************TAC HERE***************");
	    System.out.print(res);
	    if ( op1 == null && op2 == null && opr == null )
	    {
	      System.out.println();
	      return;
	    }
	    
	    /*if ( opr == null )
	    {
	      System.out.print(" =");
	    }
	    else if (  opr == "goto" || res == "push" || res == "call" || res == "import" || res == "package" )
	    {
	       // do nothing
	    }
	    else
	    {
	      System.out.print(" ="); // since opr is not null
	    }*/
	    
	    if ( op1 != null )
	    {
	      System.out.print(" "+op1);  
	    }
	    if ( opr != null && opr != "=" )
	    {
	      System.out.print(" "+opr);
	    }
	    if ( op2 != null )
	      System.out.print(", "+op2);

	    System.out.println();
	    // System.out.println("****************TAC GOING***************");
  	}
}