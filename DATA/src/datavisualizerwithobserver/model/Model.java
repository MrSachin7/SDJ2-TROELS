package datavisualizerwithobserver.model;

import shared.Subject;

import java.beans.PropertyChangeListener;

public interface Model extends Subject {
    double[] getDataValues();

    String getLastUpdateTimeStamp();

    void addListener(String name, PropertyChangeListener listener);

    void saveData(double[] data);

    double[] update();
}
