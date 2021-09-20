package model.radidator;

public class Power1State implements RadiatorState
{
  public static int POWER=1;
  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
    System.out.println("The new power :"+ radiator.getPower());
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new OffState());
    System.out.println("The new power :"+ radiator.getPower());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
