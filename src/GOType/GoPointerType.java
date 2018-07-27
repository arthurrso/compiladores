package GOType;
import java.io.*;
import java.util.*;

public class GoPointerType extends GoType
{
	public GoPointerType(GoType type)
	{
		super();
		// if(type.obj instanceof GoTypeName)
			// super(  type.obj instanceof GoTypeName ? (GoTypeName )type.obj : (GoTypeLit )type.obj  );
			// super((GoTypeName)type.obj);
		// else 
			// super((GoTypeLit)type.obj);
		this.obj = type.obj;
		// gen();
	}
	public void gen()
	{
		System.out.println("Inside GoPointerType");
		System.out.print("*");
		super.gen();
	}
}