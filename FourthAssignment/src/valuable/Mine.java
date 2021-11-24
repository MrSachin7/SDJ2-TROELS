package valuable;

import java.util.Random;

public class Mine {
    public Valuable getValuable(){
        int a = new Random().nextInt(13);
        if (a<6){
            return new Silver(); // common and less value
        }else if (a<10){
            return new Gold(); // rare and good value
        }
        else if (a<11){
            return new Diamond();  // super rare but massive value
        }
        else if (a<13){
            return new WasteCan(); // unlucky sometimes
        }
        else throw new RuntimeException("Invalid random generated, hint: check the boundary of the random");
    }
}
