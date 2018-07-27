package Util;import java.io.*;
import java.util.*;

import GOType.GoArrayType;
import GOType.GoConstants;
import GOType.GoPointerType;
import GOType.GoSignature;
import GOType.GoType;
import GOType.GoTypeLit;
import GOType.GoTypeName;

public class SymbolTableEntry
{
	
    public Object dataType;
    public String parsedDataType;
    public Boolean isConst;
    int offset;
    public int size;
    public Boolean isArray;
    
    public Boolean live;
    public int next_use;

    public LinkedList<String> addressDescriptor;
    public SymbolTableEntry()
    {
        this.dataType = "Bhoot";
        this.parsedDataType = "Bhoot";
        this.isConst = true;
        // this.var1 = "Bhoot";
        this.size = 0;
        this.isArray = false;

        live =true;
        next_use = -1;
        addressDescriptor = new LinkedList<String>();
    }
    public SymbolTableEntry(String data_type, int global_offset)
    {
        this.parsedDataType = data_type;
        this.size = get_default_size();
        this.isConst = false;
        this.dataType = parsedDataType;
        this.isArray = false;
        next_use = -1;
        live = true;
        this.offset = global_offset;
        addressDescriptor = new LinkedList<String>();

    }

    public SymbolTableEntry(int quad_index, String condCheck)
    {
        this.dataType = "While";    //  while dataType stores both forStart and outOfFor at the end
        this.parsedDataType = condCheck;    // parsed datatype stores condCheck or forStart
        this.isConst = true;
        // this.var1 = "Bhoot";
        this.size = quad_index;
        this.isArray = false;

        live =true;
        next_use = -1;
        addressDescriptor = new LinkedList<String>();

    }

	public SymbolTableEntry ( Object dataType, Boolean isConst, int global_offset)
	{
        live =true;
        next_use = -1;
        addressDescriptor = new LinkedList<String>();

        this.dataType = dataType;
        this.isConst = isConst;
        this.isArray = false;
        this.offset = global_offset;
        if( dataType instanceof GoTypeName )
            parsedDataType = ((GoTypeName)dataType).typeName;
        else if( dataType instanceof GoTypeLit)
        {
            
            GoTypeLit typelit = (GoTypeLit)dataType;

            if(typelit.obj == null)
            {
               System.out.println("ERROR: NULL dataType found at SymbolTableEntry") ;
            }
            else 
            {
                if(typelit.obj instanceof GoArrayType)
                 {

                   if(((GoArrayType)(typelit.obj)).type.obj instanceof GoTypeName)
                   {
                        parsedDataType =  ((GoTypeName)((GoArrayType)(typelit.obj)).type.obj).typeName;  
                   }
                   else if ( ((GoArrayType)(typelit.obj)).type.obj instanceof GoTypeLit )
                   {
                        if( ((GoTypeLit)(((GoArrayType)(typelit.obj)).type.obj)).obj instanceof GoPointerType )
                            System.out.println("ERROR: HERE IN SymbolTableEntry");
                            // parsedDataType =  (GoTypeName)((GoPointerType)( (GoTypeLit)(((GoArrayType)(typelit.obj)).type.obj)).obj).typeName;  
                        else
                        {
                            System.out.println("ERROR: Unsupported construct");
                        }
                   }
                   else
                    {
                        System.out.println("ERROR: Unsupported construct 2");
                    } 

                 }  

                else if(typelit.obj instanceof GoPointerType)
                    parsedDataType =  ((GoTypeName)((GoPointerType)(typelit.obj)).obj).typeName;  
                
                else if(typelit.obj instanceof GoSignature)
                {
                    GoSignature sign =  (GoSignature)typelit.obj;
                    if(sign.obj==null)
                    {
                        System.out.println("ERROR1: NULL dataType found at SymbolTableEntry") ;
                    }
                    else if( sign.obj instanceof GoType )
                        parsedDataType =  ((GoTypeName)((GoType)sign.obj).obj).typeName;
                    else if( sign.obj instanceof LinkedList )
                    {
                        System.out.println("Main hun yahan");
                        //TODO handle Parameters Parameters case
                    }
                    //NULL case for signature already handled above 

                }   
            } 
            

        }
        else if( dataType instanceof GoSignature)
        {/**/
            // System.out.println("Func Signature Recieved in SymbolTableEntry");
            parsedDataType = "bool";
        }
        else
        {
            System.out.println("ERROR: Invalid DataType sent");
        }
      
        switch (parsedDataType) 
        {
            case "bool":
                size = 1;
                // var1 = new Bool((boolean)value);
                break;
            case "byte":
                size = 1;
                // var1 = new Byte((byte)value);
                break;
            case "int":
                size = 4;
                // var1 = new Int((int)value);
                break;
            case "int8":
                size = 1;

                // var1 = new Int8((byte)value);
                break;
            case "int16":
                size = 2;
                // var1 = new Int16((short)value);
                break;
            case "int32":
                size = 4;
                // var1 = new Int32((int)value);
                break;
            case "int64":
                size = 8;
                // var1 = new Int64((long)value);
                break;
            case "uint8":
                size = 1;
                // var1 = new Uint8((byte)value);
                break;
            case "uint16":
                size = 2;
                // var1 = new Uint16((short)value);
                break;
            case "uint32":
                size = 4;
                // var1 = new Uint32((int)value);
                break;
            case "uint64":
                size = 8;
                // var1 = new Uint64((long)value);
                break;
            case "complex64":
                size = 8;
                // var1 = new Complex64((String)value);
                break;
            case "complex128":
                size = 16;
                // var1 = new Complex128((String)value);
                break;
            case "float32":
                size = 4;
                // var1 = new Float32((float)value);
                break;
            case "float64":
                size = 8;
                // var1 = new Float64((double)value);
                break;
            case "uintptr":
                size = 4;
                // var1 = new Uintptr((int)value);
                break;
            case "string":
                size = 4;
                // var1 = new GoString((String)value);
                break;
            default:
                // System.out.println("ERROR: INVALID TYPE "+parsedDataType);
                size=-1;
        }
        // }
		
	}
    public void add_to_addrdesc(String location, String name)
    {
            // System.out.print("is it empty ");
            // this.print_addrDesc();

         if((this.addressDescriptor).contains(location)==false)
         {
              this.addressDescriptor.addFirst(location);
              // System.out.print("REG added ");
              // this.print_addrDesc();
         }
          else
          {
            System.out.println("WARNING: "+location+" already added ");
            System.out.println("PRINTING TO CONFIRM");
            this.print_addrDesc(name);
          }
    }
    public boolean is_empty_addrDesc()
    {
        if(addressDescriptor.size()==0)
            return true;
        return false;
    }
    public void fix_reg_addrDesc(String dont_delete_reg, Map global_registers, String id) // id is variable whose entries are to be removed from regs. (id is key of this SymbolTableEntry)
    {
        for(int i=0;i<addressDescriptor.size();++i)
        {
            String loc = addressDescriptor.get(i);
            if ( loc.equals(dont_delete_reg) )
            {
                continue;
            }

            if (GoConstants.checkIfRegister(loc)==true) // remove this var from those regs
            {
                Register reg = (Register)global_registers.get(loc);
                reg.remove_from_regdesc(id);
            }            

        }
        this.addressDescriptor.clear();
        // this.addressDescriptor.add(dont_delete_reg);
        // ^  DONE UNIVERSALLY
    }


    public String get_prev_register()
    {
        for(int i=0;i<addressDescriptor.size();++i)
        {
            String temp = addressDescriptor.get(i);
            if(GoConstants.checkIfRegister(temp))
                return temp;
        }
        return null;
    }
    public boolean removeFromAddressDesc(String name,String var_name)
    {
        System.out.println("*******DELETING "+name+" from "+var_name);
        // return false;
        return this.addressDescriptor.remove(name);
    }
    
    public void print_addrDesc(String id)
    {
        System.out.print("Var: "+id+" ");
        for(int i=0;i<addressDescriptor.size();++i)
        {
            String temp = addressDescriptor.get(i);
            System.out.print("reg: "+temp+" ");
        } 
        System.out.println();
    }

   /* SymbolTableEntry ( Object dataType, Boolean isConst)
    {
        
       this.dataType = dataType;
        this.isConst = isConst;
        if( dataType instanceof GoTypeName )
            parsedDataType = ((GoTypeName)dataType).typeName;
        else if( dataType instanceof GoTypeLit)
        {
            
            GoTypeLit typelit = (GoTypeLit)dataType;

            if(typelit.obj == null)
            {
               System.out.println("ERROR: NULL dataType found at SymbolTableEntry") ;
            }
            else 
            {
                if(typelit.obj instanceof GoArrayType)
                 {

                   if(((GoArrayType)(typelit.obj)).type.obj instanceof GoTypeName)
                   {
                        parsedDataType =  ((GoTypeName)((GoArrayType)(typelit.obj)).type.obj).typeName;  
                   }
                   else if ( ((GoArrayType)(typelit.obj)).type.obj instanceof GoTypeLit )
                   {
                        if( ((GoTypeLit)(((GoArrayType)(typelit.obj)).type.obj)).obj instanceof GoPointerType )
                            System.out.println("ERROR: HERE IN SymbolTableEntry");
                            // parsedDataType =  (GoTypeName)((GoPointerType)( (GoTypeLit)(((GoArrayType)(typelit.obj)).type.obj)).obj).typeName;  
                        else
                        {
                            System.out.println("ERROR: Unsupported construct");
                        }
                   }
                   else
                    {
                        System.out.println("ERROR: Unsupported construct 2");
                    } 

                 }  

                else if(typelit.obj instanceof GoPointerType)
                    parsedDataType =  ((GoTypeName)((GoPointerType)(typelit.obj)).obj).typeName;  
                
                else if(typelit.obj instanceof GoSignature)
                {
                    GoSignature sign =  (GoSignature)typelit.obj;
                    if(sign.obj==null)
                    {
                        System.out.println("ERROR1: NULL dataType found at SymbolTableEntry") ;
                    }
                    else if( sign.obj instanceof GoType )
                        parsedDataType =  ((GoTypeName)((GoType)sign.obj).obj).typeName;
                    else if( sign.obj instanceof LinkedList )
                    {
                        System.out.println("Main hun yahan");
                        //TODO handle Parameters Parameters case
                    }
                    //NULL case for signature already handled above 

                }   
            } 
            

        }
        else
        {
            System.out.println("ERROR: Invalid DataType sent");
        }
        switch (parsedDataType) {
            case "bool":
                var1 = new Bool(false);
                break;
            case "byte":
                var1 = new Byte((byte)0);
                break;
            case "int":
                var1 = new Int(0);
                break;
            case "int8":
                var1 = new Int8((byte)0);
                break;
            case "int16":
                var1 = new Int16((short)0);
                break;
            case "int32":
                var1 = new Int32(0);
                break;
            case "int64":
                var1 = new Int64((long)0);
                break;
            case "uint8":
                var1 = new Uint8((byte)0);
                break;
            case "uint16":
                var1 = new Uint16((short)0);
                break;
            case "uint32":
                var1 = new Uint32(0);
                break;
            case "uint64":
                var1 = new Uint64((long)0);
                break;
            case "complex64":
                var1 = new Complex64("0.0+0.0i");
                break;
            case "complex128":
                var1 = new Complex128("0.0+0.0i");
                break;
            case "float32":
                var1 = new Float32((float)0.0);
                break;
            case "float64":
                var1 = new Float64(0.0);
                break;
            case "uintptr":
                var1 = new Uintptr(0);
                break;
            case "string":
                var1 = new GoString("");
                break;
            // case "GoExpr":
            //     var1 = new GoExpr((GoExpr));
            //     break;
            default:
                System.out.println("ERROR: INVALID TYPE +++"+parsedDataType);
        }
    }
*/
    public String printOb()
    {
        return "offset: "+this.offset+" parsedDataType: "+this.parsedDataType + " size: "+this.size+" default size: "+this.get_default_size()+" isArray: "+isArray;
    }

    public int get_default_size()
    {

        switch (this.parsedDataType) 
        {
            case "bool":
                return 1;
                // var1 = new Bool((boolean)value);
            case "byte":
                return 1;
                // var1 = new Byte((byte)value);
            case "int":
                return 4;
                // var1 = new Int((int)value);
            case "int8":
                return 1;
            case "int16":
                return 2;
                // var1 = new Int16((short)value);
            case "int32":
                return 4;
                // var1 = new Int32((int)value);
            case "int64":
                return 8;
                // var1 = new Int64((long)value);
            case "uint8":
                return 1;
                // var1 = new Uint8((byte)value);
            case "uint16":
                return 2;
                // var1 = new Uint16((short)value);
            case "uint32":
                return 4;
                // var1 = new Uint32((int)value);
            case "uint64":
                return 8;
                // var1 = new Uint64((long)value);
            case "complex64":
                return 8;
                // var1 = new Complex64((String)value);
            case "complex128":
                return 16;
                // var1 = new Complex128((String)value);
            case "float32":
                return 4;
                // var1 = new Float32((float)value);
            case "float64":
                return 8;
                // var1 = new Float64((double)value);
            case "uintptr":
                return 4;
                // var1 = new Uintptr((int)value);
            case "string":
                return 4;
                // var1 = new GoString((String)value);
            default:
                // System.out.println("ERROR: INVALID TYPE "+parsedDataType);
            return -1;
        }
    }

    public String get_default_value(String type)
    {
        String var1=null;
         switch (type) {
                case "bool":
                    var1 = "false";
                    break;
                case "byte":
                    var1 = "0";
                    break;
                case "int":
                    var1 = "0";
                    break;
                case "int8":
                    var1 ="0";
                    break;
                case "int16":
                    var1 = "0";
                    break;
                case "int32":
                    var1 = "0";
                    break;
                case "int64":
                    var1 = "0";
                    break;
                case "uint8":
                    var1 = "0";
                    break;
                case "uint16":
                    var1 = "0";
                    break;
                case "uint32":
                    var1 = "0";
                    break;
                case "uint64":
                    var1 = "0";
                    break;
                case "complex64":
                    var1 = "0.0+0.0i";
                    break;
                case "complex128":
                    var1 = "0.0+0.0i";
                    break;
                case "float32":
                    var1 = "0.0";
                    break;
                case "float64":
                    var1 = "0.0";
                    break;
                case "uintptr":
                    var1 = "0";
                    break;
                case "string":
                    var1 = "";
                    break;
                // case "GoExpr":
                //     var1 = new GoExpr((GoExpr));
                //     break;
                default:
                    // System.out.println("ERROR: INVALID TYPE +++"+type);

            }
            return var1;    
    }

}


/*
abstract class Type {
    public int size;
}

class Bool extends Type {
    public boolean value;
    Bool(boolean val)
    {
    	this.size = 1;
    	this.value = val;
    }
    public String toString()
    {
        return Boolean.toString(value);
    }
}

class GoByte extends Type {
    public byte value;
    GoByte(byte val)
    {
    	this.size = 8;
    	this.value = val;
    }
    public String toString()
    {
        return Byte.toString(value);
    }
}

class Uintptr extends Type {
    public int value;	// value contains the memory location of the pointed to variable. SO hence we need to store only the 32 /64 bit

    Uintptr(int val)
    {
    	this.size = 32;
    	this.value = val;
    }
    public String toString()
    {
        return Integer.toString(value);
    }
}

class Int extends Type {
    public int value;
    Int(int val)
    {
    	this.size = 32;
    	this.value = val;
    }
    public String toString()
    {
        return Integer.toString(value);
    }
}

class Int8 extends Type {
    public byte value;
    Int8(byte val)
    {
    	this.size = 8;
    	this.value = val;
    }
    public String toString()
    {
        return Byte.toString(value);
    }
}

class Int16 extends Type {
    public short value;
    Int16(short val)
    {
    	this.size = 16;
    	this.value = val;
    }
    public String toString()
    {
        return Short.toString(value);
    }
}

class Int32 extends Type {
    public int value;
    Int32(int val)
    {
    	this.size = 32;
    	this.value = val;
    }
    public String toString()
    {
        return Integer.toString(value);
    }
}

class Int64 extends Type {
    public long value;
    Int64(long val)
    {
    	this.size = 64;
    	this.value = val;
    }
    public String toString()
    {
        return Long.toString(value);
    }
}

class Uint8 extends Type {
    public byte value;
    Uint8(byte val)
    {
    	this.size = 8;
    	this.value = val;
    }
    public String toString()
    {
        return Byte.toString(value);
    }
}

class Uint16 extends Type {
    public short value;
    Uint16(short val)
    {
    	this.size = 16;
    	this.value = val;
    }
    public String toString()
    {
        return Short.toString(value);
    }
}

class Uint32 extends Type {
    public int value;
    Uint32(int val)
    {
    	this.size = 32;
    	this.value = val;
    }
    public String toString()
    {
        return Integer.toString(value);
    }
}

class Uint64 extends Type {
    public long value;
    Uint64(long val)
    {
    	this.size = 64;
    	this.value = val;
    }
    public String toString()
    {
        return Long.toString(value);
    }
}

class Float32 extends Type {
    public float value;
    Float32(float val)
    {
    	this.size = 32;
    	this.value = val;
    }
    public String toString()
    {
        return Float.toString(value);
    }
}

class Float64 extends Type {
    public double value;
    Float64(double val)
    {
    	this.size = 64;
    	this.value = val;
    }
    public String toString()
    {
        return Double.toString(value);
    }
}

class Complex64 extends Type {
    public float realValue;
    public float imagValue;
    public String value;
    Complex64(String val)
    {
    	this.size = 64;
    	this.value = val;
    }
    public String toString()
    {
        return value;
    }
}

class Complex128 extends Type {
    public double realValue;
    public double imagValue;
    public String value;
    Complex128(String val)
    {
    	this.size = 128;
    	this.value = val;
    }
    public String toString()
    {
        return value;
    }
}

class GoString extends Type {
    public String value;
    GoString(String val)
    {
    	this.size = (val.length()+1)*8;
    	this.value = val;
    }
    public String toString()
    {
        return value;
    }
}*/