package GOType;import java.io.*;
import java.util.*;

public class GoSelector
{
	public String id;
	GoSelector(String id)
	{
		this.id = id;
		// gen();
	}
	public void gen()
	{
		System.out.println("Inside GoSelector ");
		System.out.println("."+id);
	}
}