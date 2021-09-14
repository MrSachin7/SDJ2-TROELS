package RadiatorClasses;

public class Power3State implements RadiatorState
{
  public static int POWER = 3;
  private Thread temp;

  public Power3State(Radiator radiator)
  {
     temp = new Thread(() -> {
      try
      {
        Thread.sleep(10000);
        radiator.turnDown();   // The radiator is turned down after 10 seconds since the thread is called in the constructor.
      }
      catch (InterruptedException e)
      {
         // System.out.println("Sleep interrrupted sucessfully");
          e.printStackTrace();
      }
    });
temp.setDaemon(true);
    temp.start();
  }

  @Override public void turnUp(Radiator radiator)
  {
                                   // The turn up doesnt make sense here because the state is already at max
  }

  @Override public void turnDown(Radiator radiator)
  {
    temp.interrupt();
    radiator.setPowerState(new Power2State());
    System.out.println("The new power :"+ radiator.getPower());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
