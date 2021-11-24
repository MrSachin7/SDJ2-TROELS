package guardsman;

import logger.Log;
import valuable.Diamond;
import valuable.Gold;
import valuable.Silver;
import valuable.Valuable;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {

    private List<Valuable> valuables;
    private Log logger;


    public TreasureRoom() {
        this.valuables = new ArrayList<>();
        logger = Log.getInstance();
    }

    @Override
    public void add(Valuable valuable) {
        valuables.add(valuable);
    }

    @Override
    public Valuable retrieve() throws Exception {
        if (valuables.isEmpty()) {
            throw new Exception("Nothing in the safe");
        }
        return valuables.remove(0);
    }

    @Override
    public void readValuables() {
        int countDiamonds = 0;
        int countSilvers = 0;
        int countGolds = 0;
        int diamondsValue = 0;
        int silversValue = 0;
        int goldsValue = 0;
        for (Valuable i : valuables
        ) {
            if (i instanceof Diamond){
                countDiamonds++;
                diamondsValue+=i.getValue();
            }
            else if (i instanceof Gold){
                countGolds ++;
                goldsValue+=i.getValue();
            }
            else if (i instanceof Silver){
                countSilvers++;
                silversValue+=i.getValue();
            }

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.log("\t\t\tNumber of diamonds: "+countDiamonds+"\tDiamonds Value: "+diamondsValue+"" +
                "\n\t\t\tNumber of silvers: "+countSilvers+"\tSilvers value: "+silversValue+
                "\n\t\t\tNumber of golds: "+countGolds+"\tGolds value: "+goldsValue);

    }

    @Override
    public void acquireRead() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }

    @Override
    public void acquireWrite() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }

    @Override
    public void releaseRead() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }

    @Override
    public void releaseWrite() {
        // This method is implemented by the genius guard. Have absolutely no idea what to do here....todo ASK TROELS....
    }
}
