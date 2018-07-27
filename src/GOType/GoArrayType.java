package GOType;
public class GoArrayType
{
	public Integer arrayLength;
	public GoType type;
	public GoArrayType(Integer arrayLength, GoType type)
	{
		this.arrayLength = arrayLength;
		this.type = type;
		// gen();
	}
	public void gen()
	{
		// if ( arrayLength == null )
		// {
			System.out.println("@@@@@");
		// }
		// else
		// {
			System.out.println(arrayLength);
			// arrayLength.gen();
		// }
		if ( type == null )
		{
			System.out.println("@@@@@");
		}
		else
		{
			type.gen();
		}
	}
	public int get_array_length()
	{
		return ((Integer)arrayLength).intValue();
	}

	public String get_type()
	{
		// returns the datatype of array
		return type.get_type();
	}
}