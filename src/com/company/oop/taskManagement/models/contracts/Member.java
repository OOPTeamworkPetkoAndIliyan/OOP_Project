package com.company.oop.taskManagement.models.contracts;

public interface Member  extends ShowActivity{
    void addTask(Task task);
    void removeTask(Task task);
}
