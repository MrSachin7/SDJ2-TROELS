package view.temperaturePresenter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;
import model.temp.Temperature;

import java.beans.PropertyChangeEvent;

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
        temperatureModel.addPropertyChangeListener("Temperature added",this::TemperatureUpdated);

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

    public void TemperatureUpdated(PropertyChangeEvent event)
    {
        String t0Value =((Temperature) event.getNewValue()).getValue()+"";
    }

    public void update()
    {
        Temperature t1 = temperatureModel.getLastInsertedTemperature("t1");
        if (t1!= null)
        {
            t1value.set(t1.toString());
        }
        else
        {
            t1value.set("No data");
        }
        Temperature t2 = temperatureModel.getLastInsertedTemperature("t2");
        if (t2!= null)
        {
            t2value.set(t2.toString());
        }
        else
        {
            t2value.set("No data");
        }

    }
}
