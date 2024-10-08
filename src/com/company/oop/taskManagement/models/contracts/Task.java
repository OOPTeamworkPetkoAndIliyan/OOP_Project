package com.company.oop.taskManagement.models.contracts;

import com.company.oop.taskManagement.models.EventLog;
import com.company.oop.taskManagement.models.enums.Status;

import java.util.List;

public interface Task extends Identifiable, Commentable, ShowActivity {
    Member getAssignee();
    String getTitle();
    String getDescription();
    void addComment(Comment comment);
    List<EventLog> getHistory();
    String showDetails();
    Status getStatus();
    void changeStatus(Status status);

}
