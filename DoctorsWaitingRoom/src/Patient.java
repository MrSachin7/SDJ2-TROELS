import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements Listener {
    private int ticketNumber;
    private WaitingRoom waitingRoom;

    public Patient(int ticketNumber, WaitingRoom waitingRoom) {
        this.ticketNumber = ticketNumber;
        this.waitingRoom=waitingRoom;
        waitingRoom.addListener(this);
        System.out.println(this+ " enters the waiting room");

    }


    @Override
    public void update(int turnNo) {
        System.out.println(this+" looks up");
        if (this.ticketNumber==turnNo)
        {
            System.out.println(this+ " enters the doctors room");
           // waitingRoom.removeListener(this);
        }
        else
        {
            System.out.println(this+ " goes back to looking at phone");
        }
    }

    @Override
    public String toString() {
        return "Patient "+this.ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
