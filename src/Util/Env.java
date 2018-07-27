package Util;

import java.io.*;
import java.util.*;

import GOType.GoConstants; 

public class Env
{
    public Hashtable table;

    public static Env global_env;

    public Env prev;
    public Env parent;
    public boolean ifinfunc;
    public int global_offset;
    public String envName;
    public static Map indexSym = new HashMap();
    public int incr_global_offset;

    public Env(Env p,String name)
    {
      table = new Hashtable();
      prev = p;
      ifinfunc = false;
      global_offset = 0;
      parent = prev;  // we are sure we are not in function
      envName = name;
      incr_global_offset=0;
      indexSym.put(envName,this);
    }
    public Env(Env p, boolean val,String name)
    {
      table = new Hashtable();
      prev = p;
      global_offset = 0;
      ifinfunc = val;
      if ( ifinfunc == true )
      {
        parent = global_env;
      }
      else
      {
        parent = prev;
      }
      envName = name;
      indexSym.put(envName,this);
      incr_global_offset=0;
      
    }
    public int get_real_offset(String s)//finds offset within a function
    {
      for(Env e=this; e!=null;e=e.parent)
      {
        SymbolTableEntry found = (SymbolTableEntry)(e.table.get(s));
        if(found!=null)
        {

          System.out.println("@#@#@: "+s+" has found offset: "+String.valueOf(found.offset)+" and  + e.incr_global_offset: "+ + e.incr_global_offset+" in ENV: "+e.envName);
          // e.print_this_symTable();
          return found.offset + e.incr_global_offset;
        }
      }
      System.out.println("ERROR: undefined: "+s);
      return -1;
    }

    public void put(String s, SymbolTableEntry sym) 
    {
        // need to check that s is not a reserved keyword before putting in symbol table
        if ( GoConstants.checkIfKeyword(s) == true )
        {
            System.out.println("ERROR: syntax error: unexpected "+s);
        }
        if( table.put(s,sym) != null )
        {
            System.out.println("ERROR: "+s+" redeclared in this block");
        }

    }

    public SymbolTableEntry get(String s)
    {
      for(Env e=this; e!=null;e=e.parent)
      {
        SymbolTableEntry found = (SymbolTableEntry)(e.table.get(s));
        if(found!=null)
          return found;
      }
      System.out.println("ERROR: undefined: "+s);
      return null;
    }

    public SymbolTableEntry getFromThisEnv(String s)
    {
      Env e=this;
      SymbolTableEntry found = (SymbolTableEntry)(e.table.get(s));
      if(found!=null)
        return found;
      // System.out.println("ERROR: undefined: "+s);
      return null;
    }

    public SymbolTableEntry getQuiet(String s) 
    {
      for(Env e=this; e!=null;e=e.parent)
      {
        SymbolTableEntry found = (SymbolTableEntry)(e.table.get(s));
        if(found!=null)
          return found;
      }
      return null; // doesn't produces println
    }

    public SymbolTableEntry getLabel(String s)  
    /* just created to avoid that println of get function */
    {
      for(Env e=this; e!=null;e=e.parent)
      {
        SymbolTableEntry found1 = (SymbolTableEntry)(e.table.get(s));
        if(found1!=null)
          return found1;
      }
      return null;
    }

    public String getEnvName_fromSymbolTableEntry(String s)
    {
      for(Env e=this; e!=null;e=e.parent)
      {
        SymbolTableEntry found1 = (SymbolTableEntry)(e.table.get(s));
        if(found1!=null)
          return e.envName;
      }
      return null;
    }


    public SymbolTableEntry getFromParent(String s)
    {
      Env e = this.parent;
      SymbolTableEntry found2 = (SymbolTableEntry)(e.table.get(s));
      if( found2 != null )
        return found2;
      else
        return null;
    }

    public void removeFromParent(String s)
    {
      Env e = this.parent;
      SymbolTableEntry found3 = (SymbolTableEntry)(e.table.get(s));
      if( found3 != null )
        e.table.remove(s);
      else
      {
        System.out.println("ERROR: Deleting non existing label "+s);
        // return null;
      }
      return; 
    }

    public void removeFromCurrent(String s)
    {/**/
      SymbolTableEntry found = (SymbolTableEntry)(this.table.get(s));
      if( found != null )
        this.table.remove(s);
      else
        System.out.println("ERROR: "+ s+" not found in SymbolTable to delete");
    }

    public void update(String deleted, SymbolTableEntry sym)
    {
        this.table.remove(deleted);
        // System.out.println(deleted+" DELETED");
        // System.out.println("Symbol table entry "+deleted+" to delete");

        if(this.table.get(deleted)!=null)
          System.out.println("ERROR: "+ deleted+" not found in this table while updating");

        if( this.table.put(deleted,sym) != null )
        {
            System.out.println(deleted+" redeclared");
        }
        else
        {
          // System.out.println("Symbol table entry updated successsfully");
        }

    }

    public void updateInEnv_whereVarActuallyIs(String deleted, SymbolTableEntry sym)
    {
        String envName_where_deleted_is = getEnvName_fromSymbolTableEntry(deleted);

        // all update should happen in this envName_where_deleted_is

        Env env_of_deleted = (Env)(Env.indexSym.get(envName_where_deleted_is));

        env_of_deleted.table.remove(deleted);
        // System.out.println(deleted+" DELETED");
        // System.out.println("Symbol table entry "+deleted+" to delete");

        if(env_of_deleted.table.get(deleted)!=null)
          System.out.println("ERROR: "+ deleted+" not found in this table while updating");

        if( env_of_deleted.table.put(deleted,sym) != null )
        {
            System.out.println(deleted+" redeclared");
        }
        else
        {
          // System.out.println("Symbol table entry updated successsfully");
        }

    }


    public String get_name()
    {
      return envName;
    }

    // public int getDepth() 
    // // returns the depth of the symbolTable from the global symbol table
    // {
    //   int depth = 0;
    //   for ( Env e = this; e != null; e = e.parent )
    //   {
    //     depth++;
    //   }
    //   return depth;
    // }


    public Env get_prev()
    {
      return this.prev;
    }
    public Env get_parent()
    {
      return this.parent;
    }

    public void print_this_symTable()
    {
      System.out.println("\n"+"PRINTING ENV:::: "+this.envName+"\n");
      Set set = this.table.entrySet();
      Iterator it = set.iterator();
      while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        System.out.println(entry.getKey() + " : " + ((SymbolTableEntry)entry.getValue()).printOb());
      }
    }



}