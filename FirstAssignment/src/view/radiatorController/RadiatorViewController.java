package view.radiatorController;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.View;


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
        warningValue.textProperty().bind(viewModel.powerValueProperty());
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
