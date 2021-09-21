package model;

import model.PropertyChangeSubject;
import model.temp.Temperature;
import model.temp.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel {

    private TemperatureList temperatureList;
    private PropertyChangeSupport support;
    private TemperatureList outdoorTemperatureList;


    public TemperatureModelManager()
    {
        temperatureList= new TemperatureList();
        outdoorTemperatureList = new TemperatureList();
        support = new PropertyChangeSupport(this);
    }
    @Override
    public void addTemperature(String id, double value) {

        Temperature temperature1 = new Temperature(id,value);
        Temperature old = getLastInsertedTemperature();
        temperatureList.addTemperature(temperature1);
        support.firePropertyChange("Temperature added",old,temperature1);
    }

    @Override
    public Temperature getLastInsertedTemperature() {
        return temperatureList.getLastTemperature(null);
    }
    public Temperature getLastAddedOutdoorTemperature()
    {
        return outdoorTemperatureList.getLastTemperature(null);
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return temperatureList.getLastTemperature(id);
    }

    @Override
    public void addOutdoorTemperature(String id, double value) {
        Temperature temperature = new Temperature(id,value);
        outdoorTemperatureList.addTemperature(temperature);
        System.out.println("Outdoor temperature added");
        System.out.println("Small check "+outdoorTemperatureList.getSize());

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
