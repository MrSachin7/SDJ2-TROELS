package AutomaticDoor;

public class ClosingState implements DoorState {
    public static String state ="Closing";

    Thread temp;
    public ClosingState(Door door)
    {
        temp = new Thread(() ->
        {

            try {

                Thread.sleep(3000);
                door.setDoorState(new ClosedState());
                System.out.println("Current door status  "+door.getState());
            } catch (InterruptedException e) {
                System.out.println("The door has been sent to the opening state");
            }
        });
        temp.start();
    }
    @Override
    public void buttonClicked(Door door) {
        temp.interrupt();
        door.setDoorState(new OpeningState(door));

    }

    public  String getState() {
        return state;
    }
}
