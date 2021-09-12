package PhoneClasses;

public class VibrateState implements PhoneState
{
  @Override public void onReceiveTextMessage(String txt, Phone phone)
  {
    phone.vibrate();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.vibrate();
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    int vol= phone.getVolume();
    if (vol>1)
    {
      phone.turnVolumeDown();
    }
    else
    {
      phone.setState(new SilentState());
    }
  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    int vol= phone.getVolume();
    if (vol<100)
    {
      phone.turnVolumeUp();
    }
  }
}
