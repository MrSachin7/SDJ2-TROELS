package logger;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log {

    private static Log instance;
    private static Lock lock = new ReentrantLock();
    private File logFIle;

    private Log() {
        logFIle = new File("FourthAssignment/LogFile.txt");

    }

    public void log(String text) {
        try {
            Writer out = new BufferedWriter(new FileWriter(logFIle,true));
            out.append(text);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
