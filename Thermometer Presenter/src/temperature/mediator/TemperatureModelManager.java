package temperature.mediator;

import temperature.model.Temperature;
import temperature.model.TemperatureList;

import java.util.List;

public class TemperatureModelManager implements TemperatureModel {
    private TemperatureList temperatureList;
    private List<Listener> listeners;

    public TemperatureModelManager() {
        temperatureList = new TemperatureList();
    }

    @Override
    public void addTemperature(String id, double value) {
        Temperature temperature = new Temperature(id, value);
        Temperature old = getLastInsertedTemperature();
        this.temperatureList.addTemperature(temperature);
        if (old != null && old.getValue() != temperature.getValue()) {
            System.out.println("-->" + temperature + " (from: " + old + ")");
        }
    }

    @Override
    public Temperature getLastInsertedTemperature() {
        return temperatureList.getLastTemperature(null);
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return temperatureList.getLastTemperature(id);
    }

    @Override
    public void addListener(Listener lstnr) {
      //  listeners.add(lstnr);
    }

    @Override
    public void removeListener(Listener lstnr) {
        //listeners.remove(lstnr);
    }

    public List<Listener> getListeners() {
        return listeners;
    }
    // and maybe other methods...
}
