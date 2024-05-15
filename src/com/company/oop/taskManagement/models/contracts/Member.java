package com.company.oop.taskManagement.models.contracts;

import java.util.List;

public interface Member  extends ShowActivity{
    void addTask(Task task);
    void removeTask(Task task);
    List<Task> getTasks();
    String getName();
}
