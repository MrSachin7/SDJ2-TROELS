package model;

public interface TaskModel extends PropertyChangeSubject{
    void addTask(String owner, String description);
    Task getTask();
}
