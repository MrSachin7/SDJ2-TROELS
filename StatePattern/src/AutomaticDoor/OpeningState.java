package AutomaticDoor;

public class OpeningState implements DoorState {
    public static String state = "Opening";

    public OpeningState(Door door)
    {
        Thread temp = new Thread(() ->
        {

            try {

                Thread.sleep(5000);
                door.setDoorState(new OpenState());
                System.out.println("Current door status  " + door.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        temp.start();
    }

    @Override
    public void buttonClicked(Door door) {

    }

    public String getState() {
        return state;
    }
}
