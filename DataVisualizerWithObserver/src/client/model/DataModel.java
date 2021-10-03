package client.model;

import client.network.Client;
import client.network.SocketClient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataModel implements Model {

    private double x;
    private double y;
    private double z;
    private String lastUpdate;
    private Client client;

    private Random random ;
    private PropertyChangeSupport changeSupport ;

    public DataModel(Client client)
    {
        this.random= new Random();
        this.changeSupport = new PropertyChangeSupport(this);
        this.client = client;
    }



    @Override
    public double[] getDataValues() {
      //  return new double[]{x, y, z};
        return client.getDataValues();
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void addListener(String name, PropertyChangeListener listener) {
        if (name == null)
            changeSupport.addPropertyChangeListener(listener);
        else
            changeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void saveData(double[] data) {
        x = data[0];
        y = data[1];
        z = data[2];
        changeSupport.firePropertyChange("Data", null, new double[]{x, y, z});
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

        changeSupport.firePropertyChange("Data", null, new double[]{x, y, z});
        calcTimeStamp();
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        changeSupport.firePropertyChange("TimeUpdate", lastUpdate, strDate);
        lastUpdate = strDate;
    }


}
