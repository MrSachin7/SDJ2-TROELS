package adapterqueue;

import logger.Log;
import valuable.Valuable;
import valuable.WasteCan;

import java.util.ArrayList;
import java.util.List;

public class Deposit {
    private List<Valuable> list;
    private double cap;
    private Log logger;

    public Deposit() {
        list = new ArrayList<>();
        cap = 500;
        logger = Log.getInstance();
    }

    public synchronized void add(Valuable valuable) {
        while (totalItemsSize() >= cap) {
            try {
                logger.log("Max size reached");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (valuable instanceof WasteCan) {
            logger.log("Waste can detected , thrown away");
        } else {
            list.add(valuable);
            logger.log(valuable.getName() + " deposited");
        }
        notifyAll();
    }

    public synchronized Valuable get() throws Exception {
        while (list.isEmpty()) {
            logger.log("Nothing on the deposit");
            wait();
        }
        Valuable valuable = list.remove(0);
        notifyAll();
        //logger.log(valuable.getName()+" removed from the deposit");
        return valuable;
    }

    public double totalItemsSize() {
        double count = 0;
        for (Valuable v : list
        ) {
            count += v.getValue();
        }
        return count;
    }

}
