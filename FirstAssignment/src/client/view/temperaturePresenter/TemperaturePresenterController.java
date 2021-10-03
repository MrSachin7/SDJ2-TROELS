package client.view.temperaturePresenter;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    @FXML
    private Label indoorTempLabel;
    @FXML
    private Label outsideTemp;

    public void init(TemperaturePresenterViewModel viewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        t0Label.textProperty().bind(viewModel.t0ValueProperty());
        t1Label.textProperty().bind(viewModel.t1ValueProperty());
        t2Label.textProperty().bind(viewModel.t2ValueProperty());
        indoorTempLabel.textProperty().bind(viewModel.getIndoorTempLabel());
        warningLabel.textProperty().bind(viewModel.warningLabelProperty());
        radiatorLabel.textProperty().bind(viewModel.radiatorValueProperty());
        outsideTemp.textProperty().bind(viewModel.getOutDoorTemp());

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
