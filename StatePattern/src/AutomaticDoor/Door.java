package AutomaticDoor;

public class Door {
    private DoorState doorState;

    public Door() {
        if (doorState == null) {
            doorState = new ClosedState();
        }
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
    }
    public void buttonIsClicked()
    {
        doorState.buttonClicked(this);
    }
    public String getState()
    {
        return doorState.getState();
    }
}
