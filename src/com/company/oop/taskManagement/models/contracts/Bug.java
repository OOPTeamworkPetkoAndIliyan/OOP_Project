package com.company.oop.taskManagement.models.contracts;

public interface Bug extends Identifiable, Task{
    String getTitle();
    void changePriority();
    void changeSeverity();
    void setAssignee(Member member);
}
