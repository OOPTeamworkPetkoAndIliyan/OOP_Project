package com.company.oop.taskManagement.models.contracts;
public interface Feedback extends Identifiable, Task{
    int getRating();
    void changeRating(int rating);
}
