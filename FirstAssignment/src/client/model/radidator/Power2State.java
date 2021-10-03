package client.model.radidator;

public class Power2State implements RadiatorState
{
  public static int POWER=2;
  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
    System.out.println("The new power :"+ radiator.getPower());
  }

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power3State(radiator));
    System.out.println("The new power :"+ radiator.getPower());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
