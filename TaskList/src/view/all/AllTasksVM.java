package view.all;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Task;
import model.TaskModel;

public class AllTasksVM {
    private ObservableList<Task> tasks;
    private TaskModel taskModel;

    public AllTasksVM(TaskModel taskModel)
    {
        tasks = FXCollections.observableArrayList();
        this.taskModel = taskModel;
    }

    public ObservableList<Task> getTaskList() {
        return tasks;
    }
}
