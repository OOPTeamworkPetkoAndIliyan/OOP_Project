package com.company.oop.taskManagement.models.contracts;

public interface Task {
    void changeStatus();
    void assignTo();
    void addComment(Comment comment);
    void removeComment(Comment comment);
    void showDetails();
}
