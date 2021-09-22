package model;



public interface TemperatureModel extends PropertyChangeSubject {

    void addTemperature(String id, double value);
    void addOutdoorTemperature(String id, double value);
}

