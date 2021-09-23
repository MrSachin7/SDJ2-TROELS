package model;

import model.temp.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel {


    private PropertyChangeSupport support;




    public TemperatureModelManager()
    {


        support = new PropertyChangeSupport(this);
    }
    @Override
    public void addTemperature(String id, double value) {
        Temperature temperature1 = new Temperature(id,value);
        // Fire the change of property named Temperature added

        support.firePropertyChange("Temperature added",null,temperature1);
    }



    @Override
    public void addOutdoorTemperature(String id, double value) {
        Temperature temperature = new Temperature(id,value);

        System.out.println("Outdoor temperature added");
        support.firePropertyChange("Outdoor Temperature added",null,temperature);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }


}
