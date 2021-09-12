package RadiatorClasses;

public class OffState implements RadiatorState
{
  private static int POWER =0;

  @Override public void turnDown(Radiator radiator)
  {

  }

  @Override public void turnUp(Radiator radiator)
  {
radiator.setPowerState(new Power1State());
    System.out.println("The new power :"+ radiator.getPower());
  }

  @Override public  int getPower()
  {
    return POWER;
  }
}
