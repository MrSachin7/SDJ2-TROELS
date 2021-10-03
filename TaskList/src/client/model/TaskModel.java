package client.model;

import java.util.List;

public interface TaskModel extends PropertyChangeSubject{
    void addTask(String owner, String description);

    Task getTask();
    List<Task> getAllTasks();
}
