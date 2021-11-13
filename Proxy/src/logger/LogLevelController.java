package logger;

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
            String input = scanner.nextLine();
            if (input.equals("1")){
               setLevelAsSparse();
               return;
            }
            else if (input.equals("2")){
               setLevelAsVerbose();
               return;
            }
            else {
                System.out.println("Invalid input");
                scanner.close();
                setLevel();
            }

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
