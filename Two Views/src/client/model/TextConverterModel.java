package client.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextConverterModel implements TextConverter {
    private ArrayList<String> list;
    private PropertyChangeSupport property;

    public TextConverterModel() {
        list = new ArrayList<>();
        property = new PropertyChangeSupport(this);
    }

    @Override
    public String toUpperCase(String txt) {
        addLog("Converting "+ txt);
        return txt.toUpperCase();

    }

    @Override
    public void addLog(String log) {
        list.add(log);
        property.firePropertyChange("logValue",null,log);
    }

    public List<String> getLog() {

        return list;
    }

    @Override
    public int getLogSize() {
        return list.size();
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
