package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel {
    private List<Task> tasks;
    private PropertyChangeSupport support;

    public TaskModelManager() {
        tasks = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }




    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }


    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void addTask(String owner, String description) {
        Task newTask = (new Task(owner, description, calcTimeStamp()));
        tasks.add(newTask);
        support.firePropertyChange("TaskAdded", null, newTask);
    }

    @Override
    public Task getTask() {
        if (tasks.size() > 0) {
            Task removedTask = tasks.remove(0);
            support.firePropertyChange("TaskRemoved", null, removedTask);
            return removedTask;
        } else
            return null;

    }

    private String calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        return sdfDate.format(now);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}




