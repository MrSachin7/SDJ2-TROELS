package model;

import model.PropertyChangeSubject;
import model.temp.Temperature;

public interface TemperatureModel extends PropertyChangeSubject {

        void addTemperature(String id,double value);

        Temperature getLastInsertedTemperature();

        Temperature getLastInsertedTemperature(String id);
    }

