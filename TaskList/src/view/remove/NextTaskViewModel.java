package view.remove;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import model.Task;
import model.TaskModel;

public class NextTaskViewModel {
    private StringProperty nextTask;
    private StringProperty createdBy;
    private StringProperty createdAt;

    private TaskModel taskModel;

    public NextTaskViewModel(TaskModel taskModel)
    {
        this.taskModel=taskModel;
        nextTask= new SimpleStringProperty();
        createdAt= new SimpleStringProperty();
        createdBy = new SimpleStringProperty();
    }
    public void removeFirstTask()
    {
        taskModel.getTask();
    }
    public StringProperty nextTaskProperty()
    {
        return nextTask;
    }
    public StringProperty createdByProperty()
    {
        return createdBy;
    }
    public StringProperty createdAtProperty()
    {
        return createdAt;
    }
    public  void setAllLabels()
    {
        nextTask.set(taskModel.getAllTasks().get(0).getDescription());
        createdAt.set(taskModel.getAllTasks().get(0).getTimeCreated());
        createdBy.set(taskModel.getAllTasks().get(0).getOwner());

    }
    public void clear()
    {

        nextTask.set(null);
        createdAt.set(null);
        createdBy.set(null);
    }


}
