package view.uppercase.log;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TextConverter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener {
    private TextConverter textConverter;
    private ObservableList<String> logs;

    public LogViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        logs = FXCollections.observableArrayList();
        textConverter.addListener(this);


    }


    public ObservableList<String> getLogs() {

        return logs;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logs.add(0, "" + evt.getNewValue());
    }
}
