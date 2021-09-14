package AutomaticDoor;

public class OpenState implements DoorState {
    public static String state ="Open";
    public void buttonClicked(Door door) {

                door.setDoorState(new ClosingState(door));
            System.out.println("Current door status   "+door.getState());



    }

    public  String getState() {
        return state;
    }
}
