package Util;import java.io.*;
import java.util.*;
public class Stack
{	
	public Env symtable;
	public String envName;
	public int offset;
	public int stack_ebp;
	public int stack_esp;

	Stack(Env sym_table,int offset_size,int ebp, int esp)
	{
		symtable = sym_table;
		envName = sym_table.get_name();
		offset = offset_size;

		stack_esp=esp;
		stack_ebp=ebp;
	}
	



}