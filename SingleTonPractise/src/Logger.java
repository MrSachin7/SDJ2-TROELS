import java.io.*;

public class Logger {
    private File logFile;
    private static Logger instance;

    private Logger() {
        this.logFile = new File("Logfile.txt");
    }
    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String txt){
        try {
            Writer out = new BufferedWriter(new FileWriter(logFile,true));
            out.append(txt);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
