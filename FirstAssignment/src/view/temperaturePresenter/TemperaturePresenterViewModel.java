package view.temperaturePresenter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;

public class TemperaturePresenterViewModel {
    private StringProperty t0value,t1value,t2value,radiatorValue,warningLabel;
    private TemperatureModel temperatureModel;

    public TemperaturePresenterViewModel(TemperatureModel temperatureModel)
    {
        this.temperatureModel=temperatureModel;
        t0value = new SimpleStringProperty();
        t1value = new SimpleStringProperty();
        t2value = new SimpleStringProperty();
        radiatorValue = new SimpleStringProperty();
        warningLabel = new SimpleStringProperty();
    }

    public StringProperty t0ValueProperty()
    {
        return t0value;
    }
    public StringProperty t1ValueProperty()
    {
        return t1value;
    }
    public StringProperty t2ValueProperty()
    {
        return t2value;
    }
    public StringProperty radiatorValueProperty()
    {
        return radiatorValue;
    }
    public StringProperty warningLabelProperty()
    {
        return warningLabel;
    }
}
