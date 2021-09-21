package core;

import model.TemperatureModelManager;
import model.TemperatureModel;
import model.radidator.Radiator;

public class ModelFactory {
    private TemperatureModel temperatureModel;
    private Radiator radiator;

  /*  public ModelFactory(TemperatureModel temperatureModel)
    {
        this.temperatureModel=temperatureModel;
    }**/

    public TemperatureModel getTemperatureModel() {
        if (temperatureModel == null) {
            temperatureModel = new TemperatureModelManager();
        }
        return temperatureModel;
    }

    public Radiator getRadiator() {
        if (radiator == null) {
            radiator = new Radiator();
        }
        return radiator;
    }
}
