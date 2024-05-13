package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.enums.BugEnums.Priority;
import com.company.oop.taskManagement.models.enums.BugEnums.Severity;
import com.company.oop.taskManagement.models.enums.BugEnums.Status;

import java.util.ArrayList;
import java.util.List;

public class BugImpl extends TaskImpl{
    private List<String> stepsToReproduce;
    private Priority priority;
    private Severity severity;
    private Status status;



    public BugImpl(String title, String description, String assignee, List<String> stepsToReproduce,
                   Priority priority, Severity severity) {
        super(title, description, assignee);
        this.stepsToReproduce = stepsToReproduce;
        this.status = Status.ACTIVE;
        this.priority = priority;
        this.severity = severity;
    }

    public List<String> getStepsToReproduce() {
        return new ArrayList<>(stepsToReproduce);
    }

    public Priority getPriority() {
        return priority;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void changeStatus() {

    }

    @Override
    public void showDetails() {

    }
}
