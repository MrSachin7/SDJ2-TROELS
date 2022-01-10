package adapterqueue;

import logger.Log;
import valuable.Valuable;
import valuable.WasteCan;

import java.util.ArrayList;
import java.util.List;

public class Deposit {
    private List<Valuable> list;
    private Log logger;

    public Deposit() {
        list = new ArrayList<>();
        logger = Log.getInstance();
    }

    public synchronized void add(Valuable valuable) {
        if (valuable instanceof WasteCan) {
            logger.log("Waste can detected , thrown away");
        } else {
            list.add(valuable);
            logger.log(valuable.getName() + " deposited");
        }
        notifyAll();
    }

    public synchronized Valuable get() throws Exception  {
        while(list.isEmpty()){
            logger.log("Nothing on the deposit");
            wait();
        }
        Valuable valuable = list.get(0);
        notifyAll();
        //logger.log(valuable.getName()+" removed from the deposit");
        return valuable;
    }

    public int size(){
        return list.size();
    }

}
