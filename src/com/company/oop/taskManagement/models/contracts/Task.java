package com.company.oop.taskManagement.models.contracts;

import com.company.oop.taskManagement.models.EventLog;

import java.util.List;

public interface Task extends Identifiable, Commentable, ShowActivity {
    String getTitle();
    String getDescription();
    void addComment(Comment comment);
    List<EventLog> getHistory();
    String showDetails();
}
