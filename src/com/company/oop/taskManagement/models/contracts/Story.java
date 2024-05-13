package com.company.oop.taskManagement.models.contracts;

public interface Story extends Identifiable{
    void changePriority();
    void changeSize();
}
