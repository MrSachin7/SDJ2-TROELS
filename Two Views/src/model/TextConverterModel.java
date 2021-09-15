package model;

import java.util.ArrayList;
import java.util.List;

public class TextConverterModel implements TextConverter {
    private ArrayList<String> list;

    public TextConverterModel() {
        list = new ArrayList<>();
    }

    @Override
    public String toUpperCase(String txt) {
        list.add("Converting :"+txt);
        return txt.toUpperCase();

    }

    @Override
    public void addLog(String log) {
        list.add(log);
    }

    public List<String> getLog() {

        return list;
    }

    @Override
    public int getLogSize() {
        return list.size();
    }
}
