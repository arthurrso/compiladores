package GOType;import java.io.*;
import java.util.*;

public class GoParameterDecl
{
	public LinkedList<String> identifierList;
	public GoType type;

	public GoParameterDecl( LinkedList<String> identifierList, GoType type)
	{
		this.identifierList = identifierList;
		this.type = type;
		// gen();
	}
	public GoParameterDecl(GoType type)
	{
		this.identifierList = null;
		this.type = type;
		// gen();
	}

	public void gen()
	{
		System.out.println("Inside GoParameterDecl");
		if ( type != null )
		{
			type.gen();
		}
		if(identifierList!=null)
		for(int i=0; i< identifierList.size();++i)
		{
			System.out.println("Inside GoParameterDecl");
			 System.out.println(identifierList.get(i));

		}	
	}
}