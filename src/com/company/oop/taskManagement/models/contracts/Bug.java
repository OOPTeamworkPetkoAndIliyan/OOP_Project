package com.company.oop.taskManagement.models.contracts;

public interface Bug extends Identifiable{
    String getTitle();
    void changePriority();
    void changeSeverity();
    void setAssignee(Member member);
}
