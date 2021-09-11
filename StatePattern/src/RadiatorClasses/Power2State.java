package RadiatorClasses;

public class Power2State implements RadiatorState
{
  public static int POWER=2;
  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
