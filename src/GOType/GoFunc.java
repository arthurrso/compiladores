package GOType;
public class GoFunc
{
  public GoBlock block;
  public GoSignature signature;

  GoFunc( GoBlock bl, GoSignature si)
  {
    this.block = bl;
    this.signature = si;
  }
  public void gen()
  {
    System.out.println("Inside GoFunc");
    block.gen();
    signature.gen();
  }


}