package view.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Task;
import model.TaskModel;

public class AddTaskViewModel {
    private StringProperty creator;
    private StringProperty description;
    private TaskModel taskModel;

    public AddTaskViewModel(TaskModel taskModel) {
        this.taskModel = taskModel;
        creator = new SimpleStringProperty();
        description = new SimpleStringProperty();
    }

    public void addNewTask() {
        taskModel.addTask(creator.getValue(), description.getValue());
    }

    public StringProperty creatorProperty() {
        return creator;
    }

    public StringProperty descriptionProperty() {
        return description;
    }
    public void clear()
    {
        creator.setValue("");
        description.setValue("");
    }
}
