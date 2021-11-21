package writersPreference;

public class WritersPreferenceTosharedInt {

    private boolean activeWriter;
    private int waitingWriters;
    private int activeReaders;
//    private int waitingReaders;

    private int sharedInt;

    public synchronized void acquireRead() {
     //   waitingReaders++;
        while (activeWriter ||waitingWriters>0) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
//        waitingReaders--;
        activeReaders++;
    }

    public synchronized void releaseRead() {
        activeReaders--;
        if (activeReaders==0){
            notifyAll();
        }
    }

    public synchronized void acquireWrite() {
        waitingWriters++;
        while (activeWriter || activeReaders>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        activeWriter=true;
    }

    public synchronized void releaseWrite() {

        activeWriter=false;
        notifyAll();
    }

    public int readInt() {
        return sharedInt;
    }

    public void incrementInt() {
        sharedInt++;
    }
}
