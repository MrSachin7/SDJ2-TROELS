package datavisualizerwithobserver.SERVER.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataRandomizerManager implements DataRandomizer {

    private PropertyChangeSupport support;
    private Random random;
    int x,y,z;
    private String lastUpdate;

    public DataRandomizerManager() {
        support = new PropertyChangeSupport(this);
        this.random= new Random();


    }

    public void recalculateData() {
        int first = random.nextInt(100) + 1;
        int second = random.nextInt(100) + 1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

         x = bottom;
         y = top - bottom;
         z = 100 - top;

        support.firePropertyChange("update", null, new double[]{x, y, z});
        calcTimeStamp();
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        support.firePropertyChange("TimeUpdate", lastUpdate, strDate);
        lastUpdate = strDate;
    }

    @Override
    public double[] update() {
        recalculateData();
        return new double[]{x,y,z};
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
