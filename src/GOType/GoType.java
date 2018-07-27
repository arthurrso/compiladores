package GOType;import java.io.*;
import java.util.*;

public class GoType
{
	// public GoTypeName typeName;
	public Object obj;
	public GoType(GoTypeName typeName)
	{
		this.obj = typeName;
		// gen();
	}
	public GoType(GoTypeLit typeLit)
	{
		this.obj =typeLit ;
		// gen();
	}
	GoType()
	{
		this.obj = null;
		// gen();
	}
	public void gen()
	{
		System.out.println("in GoType.");
		if( obj instanceof GoTypeLit )
			((GoTypeLit)obj).gen();
		else if ( obj instanceof GoTypeName)
			((GoTypeName)obj).gen();
	}

	public String get_type()	
	{
		String parsedDataType = "CRAP";
		Object dataType = obj;
		// returns the real data type as a string 
		if( dataType instanceof GoTypeName )
		{
            parsedDataType = ((GoTypeName)dataType).typeName; 
		}
        else if( dataType instanceof GoTypeLit)
        {
            
            GoTypeLit typelit = (GoTypeLit)dataType;

            if(typelit.obj == null)
            {
               System.out.println("ERROR: NULL dataType found at GoType") ;
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
                            System.out.println("ERROR: HERE IN GoType");
                            // parsedDataType =  (GoTypeName)((GoPointerType)( (GoTypeLit)(((GoArrayType)(typelit.obj)).type.obj)).obj).typeName;  
                        else
                        {
                            System.out.println("ERROR: Unsupported construct GoType");
                        }
                   }
                   else
                    {
                        System.out.println("ERROR: Unsupported construct 2 GoType");
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
            System.out.println("ERROR: Invalid DataType sent in GoType");
        }
        return parsedDataType;
	}

}