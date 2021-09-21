package view.radiatorController;

import core.ModelFactory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TemperatureModel;
import model.temp.Temperature;

public class RadiatorViewModel {
    private ModelFactory modelFactory;
    private StringProperty powerValue;
    private StringProperty warningValue;

    public RadiatorViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        powerValue = new SimpleStringProperty();
        warningValue = new SimpleStringProperty();
        powerValue.set(modelFactory.getRadiator().getPower() + "");
    }

    public StringProperty powerValueProperty() {
        return powerValue;
    }

    public StringProperty warningValueProperty() {
        return warningValue;
    }

    public void turnUp() {
        modelFactory.getRadiator().turnUp();
        Platform.runLater(() -> powerValue.set(modelFactory.getRadiator().getPower() + ""));
    }

    public void turnDown() {
        modelFactory.getRadiator().turnDown();
        Platform.runLater(() -> powerValue.set(modelFactory.getRadiator().getPower() + ""));
    }


}
