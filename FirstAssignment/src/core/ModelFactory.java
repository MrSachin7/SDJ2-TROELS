package core;

import model.temp.TemperatureModelManager;
import model.temp.TemperatureModel;
import model.radidator.Radiator;

public class ModelFactory {
    private TemperatureModel temperatureModel;
    private Radiator radiator;

  /*  public ModelFactory(TemperatureModel temperatureModel, Radiator radiator)
    {
        this.temperatureModel=temperatureModel;
        this.radiator=radiator;
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
