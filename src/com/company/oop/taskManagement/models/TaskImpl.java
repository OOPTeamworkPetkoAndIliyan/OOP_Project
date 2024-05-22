package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Comment;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskImpl implements Task {
    public static final int TASK_TITLE_MIN_LENGTH = 10;
    public static final int TASK_TITLE_MAX_LENGTH = 100;
    public static final String TASK_TITLE_ERR_MESSAGE = "Task title must be between %d and %d".formatted(
            TASK_TITLE_MIN_LENGTH, TASK_TITLE_MAX_LENGTH
    );
    public static final int TASK_DESCRIPTION_MIN_LENGTH = 10;
    public static final int TASK_DESCRIPTION_MAX_LENGTH = 500;
    public static final String TASK_DESCRIPTION_ERR_MESSAGE = "Task description must be between %d and %d".formatted(
            TASK_DESCRIPTION_MIN_LENGTH, TASK_DESCRIPTION_MAX_LENGTH
    );
    private int id;
    private String title;
    private String description;
    private final List<Comment> comments = new ArrayList<>();
    private final List<EventLog> history = new ArrayList<>();

    protected TaskImpl(int id, String title, String description) {
        this.id = id;
        setTitle(title);
        setDescription(description);
    }


    private void setTitle(String title) {
        ValidationHelpers.validateIntRange(title.length(),
                TASK_TITLE_MIN_LENGTH,
                TASK_TITLE_MAX_LENGTH,
                TASK_TITLE_ERR_MESSAGE);
        this.title = title;
    }

    private void setDescription(String description) {
        ValidationHelpers.validateIntRange(description.length(),
                TASK_DESCRIPTION_MIN_LENGTH,
                TASK_DESCRIPTION_MAX_LENGTH,
                TASK_DESCRIPTION_ERR_MESSAGE);
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public List<EventLog> getHistory() {
        return this.history;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    @Override
    public String showActivity() {
        StringBuilder stringBuilder = new StringBuilder("Task's activity: ");
        stringBuilder.append(System.lineSeparator());
        for (EventLog eventLog : getHistory()) {
            stringBuilder.append(eventLog.viewInfo()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    @Override
    public String showDetails(){
        StringBuilder str = new StringBuilder(String.format("Task with ID: %d has the following details: ", getId()));
        str.append(System.lineSeparator()).append(String.format("Title: %s", getTitle()));
        str.append(System.lineSeparator()).append(String.format("Description: %s", getDescription()));
        str.append(System.lineSeparator());
        return str.toString();
    }

}