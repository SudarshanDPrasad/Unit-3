package com.example.rxjava;

public class Task {
    int id;
    String TaskName;
    boolean name;

    public Task(int id, String TaskName, boolean name) {

        this.id = id;
        this.TaskName = TaskName;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return true;
    }
}
