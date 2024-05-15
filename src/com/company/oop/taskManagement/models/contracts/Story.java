package com.company.oop.taskManagement.models.contracts;

public interface Story extends Identifiable, Task{
    void changePriority();
    void changeSize();
}
