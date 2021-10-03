package client.core;

import client.model.TaskModel;
import client.model.TaskModelManager;

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
