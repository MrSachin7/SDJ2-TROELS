package AutomaticDoor;

public class Test {
    public static void main(String[] args) {
        Door door = new Door();
        door.setDoorState(new ClosingState(door));
        door.buttonIsClicked();
       try {
            Thread.sleep(6000);
            door.buttonIsClicked();
            Thread.sleep(1000);
            door.buttonIsClicked();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
