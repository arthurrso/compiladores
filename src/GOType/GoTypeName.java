package GOType;public class GoTypeName
{
	public String typeName;
	public GoTypeName(String typeName)
	{
		this.typeName = typeName;
	}
	public void gen()
	{
		System.out.println("Inside GoTypeName"+this.typeName);
	}
}