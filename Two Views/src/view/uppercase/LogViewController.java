package view.uppercase;

import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import view.uppercase.log.LogViewModel;

import java.io.IOException;


public class LogViewController {
    @FXML
    private ListView<String> logList;

    private LogViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(LogViewModel viewModel) {
        viewHandler = new ViewHandler(new ViewModelFactory(new ModelFactory()));
        this.viewModel = viewModel;
        viewModel.loadLogs();
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
