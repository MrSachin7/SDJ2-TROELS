package PhoneClasses;

public interface PhoneState
{
void onReceiveTextMessage(String txt, Phone phone);
void onReceiveCall(Phone phone);
void onVolumeButtonUp(Phone phone);
void onVolumeButtonDown(Phone phone);
}
