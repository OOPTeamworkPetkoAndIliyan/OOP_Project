package com.company.oop.taskManagement.models.contracts;

public interface Task extends Identifiable, Commentable, ShowActivity {
    String getTitle();
    String getDescription();
    void addComment(Comment comment);
    void removeComment(Comment comment);
    void showDetails();
}
