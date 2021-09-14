package AutomaticDoor;

public class ClosedState implements DoorState {
    public static String state = "Closed";

    public void buttonClicked(Door door) {

            door.setDoorState(new OpeningState(door));
            System.out.println("Current door status  " + door.getState());



    }

    public String getState() {
        return state;
    }
}
