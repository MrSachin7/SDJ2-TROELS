package guardsman;

import logger.Log;
import valuable.Valuable;

public class GuardsMan implements TreasureRoomDoor {

    private TreasureRoomDoor treasureRoomDoor;

    private boolean activeWriter;
    private int activeReaders;

    public GuardsMan() {
        this.treasureRoomDoor = new TreasureRoom();
    }

    @Override
    public void add(Valuable valuable) {
        treasureRoomDoor.add(valuable);
    }

    @Override
    public Valuable retrieve() throws Exception {
//        acquireWrite();
           return treasureRoomDoor.retrieve();

    }

    @Override
    public void readValuables() {
//        acquireRead();
        treasureRoomDoor.readValuables();
//        releaseRead();
    }

    public synchronized void acquireRead() {
        while (activeWriter) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeReaders++;
    }

    public synchronized void acquireWrite() {
        while (activeWriter || activeReaders > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeWriter = true;
    }

    public synchronized void releaseRead() {
        activeReaders--;
        notifyAll();

    }

    public synchronized void releaseWrite() {
        activeWriter = false;
        notifyAll();

    }

}
