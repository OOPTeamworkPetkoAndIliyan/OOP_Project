package com.company.oop.taskManagement.models.contracts;

public interface Board extends ShowActivity {
    void addTask(Task task);
    void removeTask(Task task);
}
