package view.temperaturePresenter;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

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
        radiatorLabel.textProperty().bind(viewModel.warningLabelProperty());
    }
    @FXML private void onControlHeater(ActionEvent actionEvent)
    {
        //viewHandler.openRadiatorView()
    }
}
