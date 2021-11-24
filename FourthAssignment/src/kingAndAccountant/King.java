package kingAndAccountant;

import guardsman.TreasureRoomDoor;
import logger.Log;
import valuable.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King implements Runnable {
    private Random random;
    private TreasureRoomDoor treasureRoomDoor;
    private boolean canKingParty;

    public King(TreasureRoomDoor treasureRoomDoor) {
        this.random = new Random();
        this.treasureRoomDoor = treasureRoomDoor;
    }

    @Override
    public void run() {
        while (true) {
            double randomInt = random.nextInt(150 - 50) + 50;
            double value = 0;
            treasureRoomDoor.acquireWrite();
            List<Valuable> temp = new ArrayList<>();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            kingLoopingThroughAllAvailableValues:
            while (true) {
                try {
                    Valuable valuable = treasureRoomDoor.retrieve();
                    value += valuable.getValue();
                    if (value >= randomInt) {
                        canKingParty = true;
                        break kingLoopingThroughAllAvailableValues;   // if the value is met, the king stops looking through the list;
                    }
                    temp.add(valuable);   // if the value is not met, the king stores the valuable in a local list...
                } catch (Exception e) {
                    // the catch clause is triggered when there is nothing more in the list.
                    for (Valuable i : temp
                    ) {
                        treasureRoomDoor.add(i);   // the king returns the stuff he took and the party is cancelled
                    }
                    break kingLoopingThroughAllAvailableValues;

                }
            }
            treasureRoomDoor.releaseWrite();
            if (canKingParty) {
                Log.getInstance().log("\t\t\t\t\t\t----PARTY IS HERE---THE KING IS HAPPY--- --");
            } else {
                Log.getInstance().log("\t\t\t\t\t\t-----NOT ENOUGH RESOURCES--POOR KING");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
