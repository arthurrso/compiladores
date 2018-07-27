package GOType;
import java.util.*;
public class GoFunc_call
{
	public GoTypeName typeName;//can be GoType or LinkedList<GoParameterDecl> or null
	public LinkedList<GoExpr>  exprList;//optional


	public GoFunc_call(  GoTypeName typeName, LinkedList<GoExpr> exprList )
	{
		this.typeName = typeName;
		this.exprList= exprList;
		// gen();
	}
	public GoFunc_call(  GoTypeName typeName )
	{
		this.typeName = typeName;
		this.exprList= null;
		// gen();
	}
	public void gen()
	{
		System.out.println("Inside GoFunc_call");
		if( exprList!=null)
		{
			for (int i=0; i<exprList.size();++i ) 
			{
				exprList.get(i).gen();
			}			
		}
		if(typeName != null)
		{
			typeName.gen();
		}
	}
	
}