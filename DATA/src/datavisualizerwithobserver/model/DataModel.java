package datavisualizerwithobserver.model;

import datavisualizerwithobserver.network.Client;
import datavisualizerwithobserver.network.ClientSocket;

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

    private Random random = new Random();
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public DataModel(Client client)
    {
        this.client=client;
        client.startClient();
        x=33.3;
        y=33.3;
        z=33.3;
    }


    @Override
    public double[] getDataValues() {
        return new double[]{x, y, z};
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void addListener(String name, PropertyChangeListener listener) {
        if(name == null)
            changeSupport.addPropertyChangeListener(listener);
        else
            changeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(eventName,listener);
    }

    @Override
    public void saveData(double[] data) {
        x = data[0];
        y = data[1];
        z = data[2];
        changeSupport.firePropertyChange("Data", null, new double[]{x, y, z});
      //  calcTimeStamp();
    }

    @Override
    public double[] update() {
       return client.update();
    }

  /*  public void recalculateData() {
        int first = random.nextInt(100)+1;
        int second = random.nextInt(100)+1;
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
**/

}
