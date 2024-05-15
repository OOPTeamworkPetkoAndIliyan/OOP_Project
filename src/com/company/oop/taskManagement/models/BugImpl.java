package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.BugEnums.Priority;
import com.company.oop.taskManagement.models.enums.BugEnums.Severity;
import com.company.oop.taskManagement.models.enums.BugEnums.Status;

import java.util.ArrayList;
import java.util.List;

public class BugImpl extends TaskImpl implements Bug {
    private List<String> stepsToReproduce;
    private Priority priority;
    private Severity severity;
    private Status status;
    private Member assignee;



    public BugImpl(int id, String title, String description, Member assignee, List<String> stepsToReproduce,
                   Priority priority, Severity severity) {
        super(id,title, description);
        setAssignee(assignee);
        this.stepsToReproduce = stepsToReproduce;
        this.status = Status.ACTIVE;
        this.priority = priority;
        this.severity = severity;
    }

    public Member getAssignee() {
        return assignee;
    }

    public void setAssignee(Member assignee) {
        this.assignee = assignee;
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
    public void advanceStatus() {

    }

    @Override
    public void revertStatus() {

    }

    @Override
    public void showDetails() {

    }

    @Override
    public void changePriority() {

    }

    @Override
    public void changeSeverity() {

    }
}
