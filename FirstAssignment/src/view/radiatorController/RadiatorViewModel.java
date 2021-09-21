package view.radiatorController;

import core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;
import model.temp.Temperature;

public class RadiatorViewModel {
    private ModelFactory modelFactory;
    private StringProperty powerValue;
    private StringProperty warningValue;

    public RadiatorViewModel(ModelFactory modelFactory) {
        this.modelFactory=modelFactory;
        powerValue = new SimpleStringProperty();
        warningValue = new SimpleStringProperty();
    }

    public StringProperty powerValueProperty()
    {
        return powerValue;
    }
    public StringProperty warningValueProperty()
    {
        return warningValue;
    }
    public void turnUp()
    {
        modelFactory.getRadiator().turnUp();
        powerValue.set(modelFactory.getRadiator().getPower()+"");
    }
    public void turnDown()
    {
        modelFactory.getRadiator().turnDown();
        powerValue.set(modelFactory.getRadiator().getPower()+"");
    }


}
