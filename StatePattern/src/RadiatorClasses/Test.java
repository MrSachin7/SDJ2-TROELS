package RadiatorClasses;

public class Test
{
  public static void main(String[] args)
  {
    Radiator radiator = new Radiator();
    radiator.turnUp();
    radiator.turnUp();
    radiator.turnUp();
    try
    {
      Thread.sleep(5000);
      radiator.turnDown();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }


  }


}
