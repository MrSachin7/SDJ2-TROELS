package client.view.all;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Task;
import client.model.TaskModel;

import java.beans.PropertyChangeEvent;

public class AllTasksVM {
    private ObservableList<Task> tasks;
    private TaskModel taskModel;

    public AllTasksVM(TaskModel taskModel) {
        tasks = FXCollections.observableArrayList();
        this.taskModel = taskModel;
        taskModel.addPropertyChangeListener("TaskAdded", this::listModified);
        //The double ":" sign denotes call the method, so whenever a property change is fired with the name TaskAdded , listModified function is called.


        taskModel.addPropertyChangeListener("TaskRemoved", evt -> tasks.remove((Task) evt.getNewValue()));
        // This is a lambda expression to directly implement something so as to not make the function. Whenever a property
        // change is fired with the name TaskRemoved, the task will be removed but without calling any function.

    }

    public ObservableList<Task> getTaskList() {
        return tasks;
    }

    private void listModified(PropertyChangeEvent evt) {
        tasks.add((Task) evt.getNewValue());
    }
}
