package AutomaticDoor;

public class ClosedState implements DoorState {
    public static String state = "Closed";

    public void buttonClicked(Door door) {
        Thread temp = new Thread(() ->
        {
            door.setDoorState(new OpeningState(door));
            System.out.println("Current door status  " + door.getState());


        });
        //   temp.setDaemon(true);
        temp.start();
    }

    public String getState() {
        return state;
    }
}
