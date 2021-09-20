package core;

import view.temperaturePresenter.TemperaturePresenterViewModel;

public class ViewModelFactory {
    private TemperaturePresenterViewModel temperaturePresenterViewModel;
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory)
    {
        this.modelFactory=modelFactory;
    }

    public TemperaturePresenterViewModel getTemperaturePresenterViewModel() {
        if (temperaturePresenterViewModel == null) {
            temperaturePresenterViewModel = new TemperaturePresenterViewModel(modelFactory.getTemperatureModel());
        }
        return temperaturePresenterViewModel;
    }
}
