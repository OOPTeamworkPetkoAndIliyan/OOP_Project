package com.company.oop.taskManagement.models.contracts;

public interface Bug extends Identifiable{
    void changePriority();
    void changeSeverity();
}
