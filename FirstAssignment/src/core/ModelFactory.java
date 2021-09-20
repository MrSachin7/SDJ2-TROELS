package core;

import model.TemperatureModelManager;
import model.TemperatureModel;

public class ModelFactory {
    private TemperatureModel temperatureModel;

  //  public ModelFactory(TemperatureModel temperatureModel)
    {
        this.temperatureModel=temperatureModel;
    }

    public TemperatureModel getTemperatureModel() {
        if (temperatureModel == null) {
            temperatureModel = new TemperatureModelManager();
        }
        return temperatureModel;
    }
}
