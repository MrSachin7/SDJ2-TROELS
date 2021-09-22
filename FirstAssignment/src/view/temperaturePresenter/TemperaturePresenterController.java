package view.temperaturePresenter;

import core.ViewHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.temp.Temperature;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperaturePresenterController {
    private TemperaturePresenterViewModel viewModel;
    private ViewHandler viewHandler;
    @FXML
    private Label t0Label;
    @FXML
    private Label t1Label;
    @FXML
    private Label t2Label;
    @FXML
    private Label warningLabel;
    @FXML
    private Label radiatorLabel;

    public void init(TemperaturePresenterViewModel viewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        t0Label.textProperty().bind(viewModel.t0ValueProperty());
        t1Label.textProperty().bind(viewModel.t1ValueProperty());
        t2Label.textProperty().bind(viewModel.t2ValueProperty());
        warningLabel.textProperty().bind(viewModel.warningLabelProperty());
        radiatorLabel.textProperty().bind(viewModel.radiatorValueProperty());

    }

    @FXML
    private void onLineChartPressed(ActionEvent actionEvent) {
        viewHandler.openLineChartView();
    }

    @FXML
    private void onControlHeater(ActionEvent actionEvent) {
        viewHandler.openControlHeaterView();
    }

    // @FXML
    //  private void onUpdateButtonPressed(ActionEvent actionEvent) {
    //viewModel.
    // }


   /* @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Temperature t1 = (Temperature) evt.getNewValue();
        String t11 = t1.getValue() + "";
        Platform.runLater(() -> t1Label.setText(t11));
    } **/
}
