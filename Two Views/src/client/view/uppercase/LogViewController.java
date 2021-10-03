package client.view.uppercase;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import client.view.uppercase.log.LogViewModel;

import java.io.IOException;


public class LogViewController {
    @FXML
    private ListView<String> logList;

    private LogViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(LogViewModel viewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;

        logList.setItems(viewModel.getLogs());
        System.out.println(viewModel.getLogs());

    }

    @FXML
    private void onBack(ActionEvent actionEvent) {
        try {
            viewHandler.closeStage("Log");
            viewHandler.openView("convert");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
