package view.radiatorController;



import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.radidator.Radiator;

import java.beans.PropertyChangeEvent;

public class RadiatorViewModel {
    private Radiator radiator;
    //private ModelFactory modelFactory
    private StringProperty powerValue;
    private StringProperty warningValue;

    public RadiatorViewModel(Radiator radiator /*,ModelFactory modelFactory**/) {
        //  this.modelFactory = modelFactory;
        this.radiator = radiator;
        powerValue = new SimpleStringProperty();
        warningValue = new SimpleStringProperty();
        powerValue.set(radiator.getPower() + "");
        radiator.addPropertyChangeListener("Power changed", this::update);
    }

    public StringProperty powerValueProperty() {
        return powerValue;
    }

    public StringProperty warningValueProperty() {
        return warningValue;
    }

    public void turnUp() {
        radiator.turnUp();
        //modelFactory.getRadiator().turnUp();
    }

    public void turnDown() {
        radiator.turnDown();


    }

    public void update(PropertyChangeEvent event) {

        String temp = event.getNewValue() + "";
        Platform.runLater(() -> powerValue.set(temp));

        if ((int) event.getNewValue() == 3) {
            Platform.runLater(() -> warningValue.set("Max power reached,, decreasing power............"));
        } else {
            Platform.runLater(() -> warningValue.set(""));
        }

    }


}
