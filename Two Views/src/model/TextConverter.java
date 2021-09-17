package model;

import java.util.List;

public interface TextConverter extends UnnamedPropertyChangeSubject {
    String toUpperCase(String txt);

    void addLog(String log);

    int getLogSize();

    List<String> getLog();

}
