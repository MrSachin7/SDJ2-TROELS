package model;

import java.util.List;

public interface TaskModel extends PropertyChangeSubject{
    void addTask(String owner, String description);
    void removeFirstTask();
    Task getTask();
    List<Task> getAllTasks();
}
