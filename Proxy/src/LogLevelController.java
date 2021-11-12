import java.util.Scanner;

public class LogLevelController implements Logger{

    private Logger logger;
    private String level;

    public LogLevelController(){
        this.logger = new ConsoleLogger();
        setLevel();
    }

    private void setLevelAsSparse( ) {
        this.level = "Sparse";
    }
    private void setLevelAsVerbose() {
        this.level = "Verbose";
    }
    private void setLevel(){
        Scanner scanner = new Scanner(System.in);

            System.out.println("What is your level..\n" +
                    " 1 ) Sparse\n" +
                    " 2 ) Verbose");
            if (scanner.nextLine().equals("1")){
               setLevelAsSparse();
            }
            else if (scanner.nextLine().equals("2")){
               setLevelAsVerbose();
            }
            else {
                System.out.println("Invalid input");
                scanner.close();
                setLevel();
            }
            scanner.close();
    }

    @Override
    public void log(String txt) {
        if (level.equals("Sparse")){
            if (txt.toLowerCase().contains("error")){
                logger.log(txt);
            }
        }
        else if (level.equals("Verbose")){
            logger.log(txt);
        }
    }
}
