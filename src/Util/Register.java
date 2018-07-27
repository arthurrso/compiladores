package Util;import java.io.*;
import java.util.*;
public class Register
{
	public String name;
	public LinkedList<Map> regDescriptor;
	// public LinkedList<String> regDescriptor;
	public Register(String name)
	{
		this.name = name;
		// regDescriptor = new LinkedList<String>(); 
		regDescriptor = new LinkedList<Map>(); //"var:symboltable"
	}
	public boolean if_var_in_reg(String var)
	{
		//var is var name
		// if(regDescriptor.indexOf(var)!=-1)
			// return true;
		for (int i = 0;i<regDescriptor.size() ;++i ) 
		{
			if(regDescriptor.get(i).get(var)!=null)
				return true;	
		}
		return false;
	}
	public boolean is_descriptor_empty()
	{
		return (regDescriptor.size()==0)?true:false;
	}
	public int spill_cost(Tac line)
	{
		int sp_cost= 0;
		for(int i=0;i<regDescriptor.size();++i)
		{
			String temp_var =  "";//= regDescriptor.get(i);
			for ( Object key : regDescriptor.get(i).keySet() ) 
			{	
				if(!temp_var.equals(""))
					System.out.println("ERROR: In Register.java; loop ran 2 times");

				temp_var = (String)key;

			}
			Env symboltable = (Env)regDescriptor.get(i).get(temp_var) ;
			SymbolTableEntry s = symboltable.get(temp_var);
			
			if( s.addressDescriptor.size()>1 && s.addressDescriptor.contains(this.name)==true)
			{
				System.out.println(temp_var+"already has "+s.addressDescriptor.size()+" copies. No need to spill");
				continue;
			}
			if( temp_var == line.res && line.res != line.op2 && line.res != line.op1 )
			{
				System.out.println(temp_var+" used both in lhs and rhs .No need to spill");
				continue;
			}
			if( s.next_use == -1 )
			{
				System.out.println(temp_var+" has next_use = "+s.next_use+" .No need to spill");
				continue;
			}
			sp_cost+=1;
		}
		return sp_cost;
	}

	public void remove_from_regdesc(String id)
	{
		for(int i=0;i<regDescriptor.size();++i)
		{
			if(regDescriptor.get(i).get(id)!=null)
			{
				regDescriptor.remove(i);
				return;
			}
		}
		System.out.println("ERROR: In Register.java; deleting non existent id "+id);

	}

	public void add_to_regdesc(Map reg_map)
	{
		String temp_var=null;
		for ( Object key : reg_map.keySet() ) 
		{	
			if(temp_var!=null)
				System.out.println("ERROR: In Register.java; loop ran 2 times in add_to_regdesc");

			temp_var = (String)key;

		}
		if(temp_var!=null)
		{
			// System.out.println("adding "+temp_var+" to reg "+this.name+ " in add_to_regdesc");

			for(int i=0;i<regDescriptor.size();++i)
			{
				if(regDescriptor.get(i).get(temp_var)!=null)
				{
					// System.out.println("ALREADY THERE "+temp_var+" to reg "+this.name+ " in add_to_regdesc");

					return;
				}
			}
			regDescriptor.add(reg_map);
		}
		else
		{
			System.out.println("ERROR: Map not sent properly to add_to_regdesc");
		}
	}
	public void print_reg()
	{
		System.out.println("***** REGISTER "+name+" *****");
		String temp_var=null;

		for(int i=0;i<regDescriptor.size();++i)
		{
			for ( Object key : regDescriptor.get(i).keySet() ) 
			{	
				/*if(!temp_var.equals(""))
					System.out.println("ERROR: In Register.java; loop ran 2 times in add_to_regdesc");
*/
				temp_var = (String)key;
				System.out.println("KEY : "+temp_var);


			}

		}
	}

	public LinkedList<Tac> spill(String dont_remove)
	{
		LinkedList<Tac> x86_array = new LinkedList<Tac>(); 
		// this.print_reg();
		// System.out.println("register "+this.name+" has "+dont_remove+" in dont_remove size of regDescriptor: "+regDescriptor.size());

		LinkedList<String> remove_vars = new LinkedList<String>();

		for(int i=0;i<regDescriptor.size();i++)
		{
			// System.out.println("#######ITERATION "+i+"in "+this.name);
			String temp_var =  "";//= regDescriptor.get(i);
			for ( Object key : regDescriptor.get(i).keySet() ) 
			{	
				if(!temp_var.equals(""))
					System.out.println("ERROR: In Register.java; loop ran 2 times");

				temp_var = (String)key;

			}
			// System.out.println("register "+this.name+" has "+temp_var+" in regdescriiptor");

			if(!dont_remove.equals("") && temp_var.equals(dont_remove))//we don't want to spill the entry of the caller
			{
				System.out.println("register "+this.name+" has "+dont_remove+" in dont_remove"+" which is "+temp_var);

				continue;
			}
			Env symboltable = (Env)regDescriptor.get(i).get(temp_var) ;
			SymbolTableEntry s = new SymbolTableEntry(); 
			s = symboltable.get(temp_var);

			s.print_addrDesc(temp_var+" before ");

			//Remove from addressdescriiptor, write mem to store reg into memory
			if(s.removeFromAddressDesc(this.name,temp_var)==false)
			{
				System.out.println("ERROR: Unable to remove register "+this.name+" from "+temp_var+" in addressdescriiptor");
			}
			else
			{
				System.out.println("SUCCESS: removed register "+this.name+" from "+temp_var+" while spilling inside env "+symboltable.envName);
			}
			//removed successfully
			s.print_addrDesc(temp_var+" after ");
			s.add_to_addrdesc("[ebp-"+symboltable.get_real_offset(temp_var)+"]",temp_var);
			symboltable.updateInEnv_whereVarActuallyIs(temp_var, s);	// we have to remove from original symbol table rather than from an instance of its copy

			// clear this temp_var from this register's regDescriptor

			// DDDDDDDDDDDDDDDDDOOOOOOOOOOOOOOOOOONNNNNNNNNNNNNNNNNNNNNNNTTTTTTTTTTTTTTTTTTTT REMOVE !!!!!!!!!!!!
			// ITERATION COUNT GETS DAMAGED
			remove_vars.add(temp_var);
			


			System.out.print("SPILLING   ");
			symboltable.get(temp_var).print_addrDesc(temp_var);
			//Assuming that esp=offset 0 of this symbol table, now this 
			// symbol_table will be same throughout the simple block

			Tac new_entry = new Tac();
			new_entry.res="mov";
			new_entry.op1 = "[ebp-"+symboltable.get_real_offset(temp_var)+"]";
			new_entry.op2 = this.name;
			x86_array.add(new_entry);

		}

		for ( int i = 0; i < remove_vars.size(); i++)
		{
			this.remove_from_regdesc(remove_vars.get(i));
		}


		return x86_array;
	}
}