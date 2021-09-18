package model;

public class Task {
    private String owner;
    private String description;
    private String timeCreated;

    public Task(String owner,String desc,String created)
    {
        this.owner=owner;
        this.description=desc;
        this.timeCreated=created;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getTimeCreated() {
        return timeCreated;
    }
}
