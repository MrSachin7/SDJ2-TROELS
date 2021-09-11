package RadiatorClasses;

public class Radiator
{
  private RadiatorState currentState;

  public void turnUp()
  {
    currentState.turnUp(this);
  }

  public void turnDown()
  {
    currentState.turnDown(this);
  }
  public void getPower()
  {
    currentState.getPower();
  }
  void setPowerState(RadiatorState state)
  {
    currentState=state;
  }
}
