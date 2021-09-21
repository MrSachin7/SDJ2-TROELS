package model;

import model.PropertyChangeSubject;
import model.temp.Temperature;
import model.temp.TemperatureList;

public interface TemperatureModel extends PropertyChangeSubject {

    void addTemperature(String id, double value);

    Temperature getLastInsertedTemperature();

    Temperature getLastInsertedTemperature(String id);

    void addOutdoorTemperature(String id, double value);

    Temperature getLastAddedOutdoorTemperature()

;
}

