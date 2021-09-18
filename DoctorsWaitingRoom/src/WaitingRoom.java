
import java.util.ArrayList;
import java.util.List;

public class WaitingRoom implements Subject, Runnable {
    private List<Listener> list;

    public WaitingRoom()
    {
        this.list= new ArrayList<>();
    }
    @Override
    public void addListener(Listener lstnr) {
        list.add(lstnr);
    }

    @Override
    public void removeListener(Listener lstnr) {
        list.remove(lstnr);
    }

    private  void updateListeners(int turnNo) {
        for (Listener listeners : list
        ) {
            listeners.update(turnNo);
        }
    }

    @Override
    public void run() {
        int turnNO = -1;
        while (true) {

            try {
                turnNO++;
                System.out.println("Dingggg");
                updateListeners(turnNO);
                Thread.sleep(10000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
