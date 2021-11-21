package readerpreference;

import java.util.Random;

public class RunExample {
    public static void main(String[] args) {
        ReadersPreferenceTosharedInt readersPreferenceTosharedInt = new ReadersPreferenceTosharedInt();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                while (true) {
                    readersPreferenceTosharedInt.acquireWrite();
                    readersPreferenceTosharedInt.incrementInt();
                    readersPreferenceTosharedInt.releaseWrite();
                    try {
                        Thread.sleep(50+new Random().nextInt(50));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI=i;
            new Thread(()->{
                while (true) {
                    readersPreferenceTosharedInt.acquireRead();
                    System.out.println("reader "+finalI+" :"+readersPreferenceTosharedInt.readInt());
                    readersPreferenceTosharedInt.releaseRead();
                    try {
                        Thread.sleep(500+new Random().nextInt(50));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
