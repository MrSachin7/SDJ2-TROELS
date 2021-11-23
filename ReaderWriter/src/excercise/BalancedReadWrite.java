package excercise;

public class BalancedReadWrite {
    private int activeReaders;
    private int activeWriters;
    private int waitingReaders;
    private int waitingWriters;

    private int sharedData;

    public BalancedReadWrite() {
        sharedData = 0;
    }

    public synchronized void acquireRead() {
        waitingReaders++;
        while (activeWriters > 0 || waitingWriters > waitingReaders) {
            try {
                if (activeWriters > 0) System.out.println("Couldn't acquire read , because of active writer");
                else if (waitingWriters > waitingReaders)
                    System.out.println("Couldn't acquire read , because waiting writers are more than the readers");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingReaders--;
        activeReaders++;
    }

    public synchronized void acquireWrite() {
        waitingWriters++;
        while (activeReaders > 0 || activeWriters > 0 || waitingWriters<waitingReaders) {
            try {
                if (activeReaders > 0) {
                    System.out.println("Couldnt acquire write , because of active readers");
                } else if (activeWriters > 0) System.out.println("Couldnt acquire write , because of active writer");

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t write acquiredddddddd");
        waitingWriters--;
        activeWriters++;
    }

    public synchronized void releaseRead() {
        activeReaders--;
        System.out.println(Thread.currentThread().getName()+" released read...");
        if (activeReaders == 0) {
            notifyAll();
        }
    }

    public void releaseWrite() {
        activeWriters--;
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t write released");
        notifyAll();
    }

    public void doWrite() {

        sharedData++;
    }

    public int doRead() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sharedData;
    }
}
