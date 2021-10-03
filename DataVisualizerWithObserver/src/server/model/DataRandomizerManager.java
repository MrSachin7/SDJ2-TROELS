package server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataRandomizerManager implements DataRandomizer {

    private double x;
    private double y;
    private double z;
    private Random random;
    private PropertyChangeSupport support;
    private String lastUpdate;

    public DataRandomizerManager() {
        random = new Random();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void saveData(double[] data) {
        x = data[0];
        y = data[1];
        z = data[2];
        support.firePropertyChange("Data", null, new double[]{x, y, z});
        calcTimeStamp();
    }

    public void recalculateData() {
        int first = random.nextInt(100) + 1;
        int second = random.nextInt(100) + 1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

        x = bottom;
        y = top - bottom;
        z = 100 - top;

        support.firePropertyChange("Recalculate", null, new double[]{x, y, z});
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
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
