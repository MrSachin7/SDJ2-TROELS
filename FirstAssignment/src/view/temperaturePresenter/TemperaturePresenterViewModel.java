package view.temperaturePresenter;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;
import model.temp.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperaturePresenterViewModel  {
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
       // temperatureModel.addPropertyChangeListener("Temperature added",this);

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



    public void updateData() {
        Temperature t1 = temperatureModel.getLastInsertedTemperature("t1");
        if (t1!= null)
        {
            Platform.runLater(()->t1value.set(t1.toString()));
        }
        else
        {
           Platform.runLater(()->t1value.set("No data")) ;
        }
        Temperature t2 = temperatureModel.getLastInsertedTemperature("t2");
        if (t2!= null)
        {
          Platform.runLater(()->t2value.set(t2.toString()) );
        }
        else
        {
           Platform.runLater(()->t2value.set("No data"));
        }
    }
}
