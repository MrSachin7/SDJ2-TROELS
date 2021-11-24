package logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log {

    private static Log instance;
    private static Lock lock = new ReentrantLock();

    private Log() {

    }

    public void log(String text) {
        System.out.println(text);
    }

    public static Log getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance==null){
                    instance= new Log();
                }
            }
        }
        return instance;

    }
}
