package client.core;

import client.view.lineChart.LineChartViewModel;
import client.view.radiatorController.RadiatorViewModel;
import client.view.temperaturePresenter.TemperaturePresenterViewModel;

public class ViewModelFactory {
    private TemperaturePresenterViewModel temperaturePresenterViewModel;
    private ModelFactory modelFactory;
    private RadiatorViewModel radiatorViewModel;
    private LineChartViewModel lineChartViewModel;

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
            radiatorViewModel = new RadiatorViewModel(modelFactory.getRadiator());
        }
        return radiatorViewModel;
    }

    public LineChartViewModel getLineChartViewModel() {
        if (lineChartViewModel == null) {
            lineChartViewModel = new LineChartViewModel(modelFactory);
        }
        return lineChartViewModel;
    }
}
