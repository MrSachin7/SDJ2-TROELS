public class Test
{
  public static void main(String[] args)
  {
    MyFunction myFunction =(string1,string2)->{
      System.out.println(string1+" + "+string2);
    };
    myFunction.add("Hello","World");
  }
}
