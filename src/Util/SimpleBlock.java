package Util;import java.io.*;
import java.util.*;
public class SimpleBlock
{
	public String label_name;
	public String symbolTable_name;
	public LinkedList <TacLineInfo> lines;
	public SimpleBlock(String ln, String sn, LinkedList<TacLineInfo> ls)
	{
		label_name = ln;
		symbolTable_name = sn;
		lines = ls;
	}
	public void print_block()
	{
		System.out.println("********* "+ label_name +" *******");
		for(int i=0;i<lines.size();++i)
		{
			TacLineInfo temp = lines.get(i);
			// System.out.print(i+"\t");
			temp.line.print_tac();

			if( temp.line.res != null && temp.line_info.get(temp.line.res)!=null ) 
			{
				System.out.println(temp.line.res+"( LIVE : "+String.valueOf((Boolean)((Map)(temp.line_info.get(temp.line.res))).get("live"))+" | NEXT_USE :"+String.valueOf((int)((Map)(temp.line_info.get(temp.line.res))).get("next_use"))+" )");
			}
			if( temp.line.op1 != null && temp.line_info.get(temp.line.op1)!=null ) 
			{
				System.out.println(temp.line.op1+"( LIVE : "+String.valueOf((Boolean)((Map)(temp.line_info.get(temp.line.op1))).get("live"))+" | NEXT_USE :"+String.valueOf((int)((Map)(temp.line_info.get(temp.line.op1))).get("next_use"))+" )");
			}
			if( temp.line.op2 != null && temp.line_info.get(temp.line.op2)!=null ) 
			{
				System.out.println(temp.line.op2+"( LIVE : "+String.valueOf((Boolean)((Map)(temp.line_info.get(temp.line.op2))).get("live"))+" | NEXT_USE :"+String.valueOf((int)((Map)(temp.line_info.get(temp.line.op2))).get("next_use"))+" )");
			}
		}
	}
}