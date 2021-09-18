package core;

import model.TaskModel;
import model.TaskModelManager;

public class ModelFactory {
    private TaskModel taskModel;

    public TaskModel getTaskModel()
    {
        if (taskModel == null) {
            taskModel = new TaskModelManager();
        }
        return taskModel;
    }
}
