package com.company.oop.taskManagement.models.contracts;

public interface Task extends Identifiable {
    String getTitle();
    String getDescription();
    void advanceStatus();
    void revertStatus();
    void addComment(Comment comment);
    void removeComment(Comment comment);
    void showDetails();
}
