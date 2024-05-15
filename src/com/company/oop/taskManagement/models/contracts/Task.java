package com.company.oop.taskManagement.models.contracts;

public interface Task extends Identifiable {
    void advanceStatus();
    void revertStatus();
    void addComment(Comment comment);
    void removeComment(Comment comment);
    void showDetails();
}
