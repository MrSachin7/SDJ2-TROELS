package PhoneClasses;



public class Phone
{
  private PhoneState currentState;
  private int currentVolume;

  public Phone()
  {
    currentState= new SoundState();
  }

  public void receiveMessage(String txt)
  {
    currentState.onReceiveTextMessage(txt, this);
  }

  public void receiveCall()
  {
    currentState.onReceiveCall(this);
  }

  public void volumeButtonUp()
  {
    currentState.onVolumeButtonUp(this);
  }

  public void volumeButtonDown()
  {
    currentState.onVolumeButtonDown(this);
  }

  public void goToSilent()
  {
    currentState = new SilentState();
  }

  public void goToVibrate()
  {
    currentState = new VibrateState();
  }

  public void goToSound()
  {
    currentState = new SoundState();
  }

  void turnVolumeUp()
  {
    currentVolume++;
  }

  void turnVolumeDown()
  {
    currentVolume--;
  }

  void playRingTone()
  {
    System.out.println("Jingle Bells Jingle Bells");
  }

  void vibrate()
  {
    System.out.println("VRRR VRRRR Vibrating");
  }

  void lightUpScreen()
  {
    System.out.println("The screen is light up");
  }

  void beepBeep()
  {
    System.out.println("BEEP BEEP ");
  }

  int getVolume()
  {
    return currentVolume;
  }

  void setState(PhoneState state)
  {
    currentState = state;
  }

}
