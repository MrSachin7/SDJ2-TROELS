package AutomaticDoor;

public class OpenState implements DoorState {
    public static String state ="Open";
    public void buttonClicked(Door door) {
        Thread temp = new Thread(()->
        {

                door.setDoorState(new ClosingState(door));
            System.out.println("Current door status   "+door.getState());


        });
        //temp.setDaemon(true);
        temp.start();
    }

    public  String getState() {
        return state;
    }
}
