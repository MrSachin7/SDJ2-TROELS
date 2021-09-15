package view.uppercase;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import view.uppercase.log.LogViewModel;

import java.io.IOException;

public class LogViewController {
    @FXML private ListView<String> logList;
    @FXML private Label topicLabel;
    private LogViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(LogViewModel logVM)
    {
        this.viewModel =logVM;

        logList.setItems(logVM.getLogs());
viewModel.loadLogs();

    }
    @FXML private void onBack(ActionEvent actionEvent)
    {
        try {
            viewHandler.openToUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
