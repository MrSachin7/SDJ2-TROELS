package client.view.radiatorController;

import client.core.ViewHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class RadiatorViewController {
    @FXML
    private Label powerValue;
    @FXML
    private Label warningValue;

    private ViewHandler viewHandler;
    private RadiatorViewModel viewModel;

    public void init(ViewHandler viewHandler, RadiatorViewModel viewModel) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        powerValue.textProperty().bind(viewModel.powerValueProperty());
        warningValue.textProperty().bind(viewModel.warningValueProperty());
    }

    @FXML
    private void onTurnUp(ActionEvent actionEvent) {
        viewModel.turnUp();
    }

    @FXML
    private void onTurnDown(ActionEvent actionEvent) {
        viewModel.turnDown();
    }

    @FXML
    private void onBack(ActionEvent actionEvent) {
        viewHandler.openTemperaturePresenterView();
    }


}
