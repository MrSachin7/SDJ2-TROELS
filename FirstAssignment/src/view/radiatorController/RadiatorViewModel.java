package view.radiatorController;

import core.ModelFactory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class RadiatorViewModel {
    private ModelFactory modelFactory;
    private StringProperty powerValue;
    private StringProperty warningValue;

    public RadiatorViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        powerValue = new SimpleStringProperty();
        warningValue = new SimpleStringProperty();
        powerValue.set(modelFactory.getRadiator().getPower() + "");
        modelFactory.getRadiator().addPropertyChangeListener("Power changed",this::update);
    }

    public StringProperty powerValueProperty() {
        return powerValue;
    }

    public StringProperty warningValueProperty() {
        return warningValue;
    }

    public void turnUp() {
        modelFactory.getRadiator().turnUp();
    }

    public void turnDown() {
        modelFactory.getRadiator().turnDown();


    }
    public void update(PropertyChangeEvent event)
    {

        String temp = event.getNewValue()+"";
        Platform.runLater(()->powerValue.set(temp));

        if ((int)event.getNewValue()==3)
        {
            Platform.runLater(()->warningValue.set("Max power reached,, decreasing power............"));
        }
        else
        {
            Platform.runLater(()->warningValue.set(""));
        }

    }


}
