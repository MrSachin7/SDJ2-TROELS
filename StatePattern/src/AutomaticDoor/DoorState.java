package AutomaticDoor;

public interface DoorState
{
    void buttonClicked(Door door);
    String getState();
}
