package GOType;import java.io.*;
import java.util.*;
public class GoSignature
{
	public LinkedList<GoParameterDecl> parameters;
	public Object obj;// return type: can be GoType or LinkedList<GoParameterDecl> or null

	public GoSignature( LinkedList<GoParameterDecl> parameters, GoType type )
	{
		this.parameters = parameters;
		this.obj = type;
		// gen();
	}
	public GoSignature( LinkedList<GoParameterDecl> parameters1, LinkedList<GoParameterDecl> parameters2 )
	{
		this.parameters = parameters1;
		this.obj = parameters2;
		// gen();
	}
	public GoSignature( LinkedList<GoParameterDecl> parameters )
	{
		this.parameters = parameters;
		this.obj = null;
		// gen();
	}
	public void gen()
	{
		System.out.println("Inside GoSignature");
		for(int i=0;i<parameters.size();++i)
		{
			parameters.get(i).gen();
		}
		if ( obj == null )
		{

		}
		else if ( obj instanceof LinkedList )
		{
			for(int i=0;i<parameters.size();++i)
			{
				parameters.get(i).gen();
			}
		}
		else if ( obj instanceof GoType )	// caught a basic literal
		{
				((GoType)obj).gen();
		}
		
	}
	
}