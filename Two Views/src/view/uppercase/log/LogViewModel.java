package view.uppercase.log;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TextConverter;

public class LogViewModel {
    private TextConverter textConverter;
    private ObservableList<String> logs;

    public LogViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        logs = FXCollections.observableArrayList();


    }

    public ObservableList<String> getLogs() {
        return logs;
    }

    public void loadLogs() {
        for (int i = 0; i <textConverter.getLog().size() ; i++) {

            logs.add(textConverter.getLog().get(i));
        }
    }
}