package core;

import view.radiatorController.RadiatorViewModel;
import view.temperaturePresenter.TemperaturePresenterViewModel;

public class ViewModelFactory {
    private TemperaturePresenterViewModel temperaturePresenterViewModel;
    private ModelFactory modelFactory;
    private RadiatorViewModel radiatorViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
    {
        this.modelFactory=modelFactory;
    }

    public TemperaturePresenterViewModel getTemperaturePresenterViewModel() {
        if (temperaturePresenterViewModel == null) {
            temperaturePresenterViewModel = new TemperaturePresenterViewModel(modelFactory);
        }
        return temperaturePresenterViewModel;
    }

    public RadiatorViewModel getRadiatorViewModel() {
        if (radiatorViewModel == null) {
            radiatorViewModel = new RadiatorViewModel(modelFactory);
        }
        return radiatorViewModel;
    }
}
