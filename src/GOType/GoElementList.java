package GOType;
import java.io.*;
import java.util.*;

public class GoElementList
{
	public LinkedList<GoElement> eleList;
	public GoElementList(LinkedList<GoElement> eleList)
	{
		this.eleList = eleList;
		// gen();
	}
	public void gen()
	{
		for ( int i = 0; i < eleList.size(); i++ )
		{
			(eleList.get(i)).gen();
		}
	}
}