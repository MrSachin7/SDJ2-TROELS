import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener {
    private int ticketNumber;
    private WaitingRoomInterface waitingRoom;

    public Patient(int ticketNumber, WaitingRoomInterface waitingRoom) {
        this.waitingRoom = waitingRoom;
        this.ticketNumber = ticketNumber;
        System.out.println(this+ "enters the room");
        waitingRoom.addPropertyChangeListener("Counter increased", this);
    }



    @Override
    public String toString() {
        return "Patient " + ticketNumber;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int counter = (int) evt.getNewValue();
        System.out.println(this + " looks up");
        if (counter == ticketNumber) {
           waitingRoom.removePropertyChangeListener(this);
            System.out.println(this + " enters the doctor's office");

        } else {
            System.out.println(this + " goes back to looking at phone");
        }

    }
}
