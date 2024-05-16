package com.company.oop.taskManagement.models.contracts;

public interface Story extends Identifiable, Task{
    void setAssignee(Member assignee);
    void changePriority();
    void changeSize();
}
