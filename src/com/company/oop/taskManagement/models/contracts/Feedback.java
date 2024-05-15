package com.company.oop.taskManagement.models.contracts;

public interface Feedback extends Identifiable{
    int getRating();
    void changeRating();
}
