package model.temp;


import model.utils.PropertyChangeSubject;

public interface TemperatureModel extends PropertyChangeSubject {

    void addTemperature(String id, double value);
    void addOutdoorTemperature(String id, double value);
}

