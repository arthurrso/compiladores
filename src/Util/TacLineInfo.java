package Util;import java.io.*;
import java.util.*;
public class TacLineInfo
{	
	public Tac line;
	public Map line_info;

	public TacLineInfo()
	{
		line_info = new HashMap();
		line = null;
	}
	TacLineInfo(Tac line)
	{
		this.line = line;
		line_info = new HashMap();
	}
}