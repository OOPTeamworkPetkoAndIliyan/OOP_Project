package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Bug;

import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.BugEnums.BugStatus;

import java.util.ArrayList;
import java.util.List;

public class BugImpl extends TaskImpl implements Bug {
    private List<String> stepsToReproduce;
    private Priority priority;
    private Severity severity;
    private BugStatus bugStatus;
    private Member assignee;



    public BugImpl(int id, String title, String description,
                   Priority priority, Severity severity) {
        super(id,title, description);
        this.stepsToReproduce = new ArrayList<>();
        this.bugStatus = BugStatus.ACTIVE;
        this.priority = priority;
        this.severity = severity;
    }
    public Member getAssignee() {
        return assignee;
    }

    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    @Override
    public void changeStatus(BugStatus bugStatus) {
        this.bugStatus = bugStatus;
    }

    public List<String> getStepsToReproduce() {
        return new ArrayList<>(stepsToReproduce);
    }
    @Override
    public Priority getPriority() {
        return priority;
    }
    @Override
    public Severity getSeverity() {
        return severity;
    }
    @Override
    public BugStatus getStatus() {
        return bugStatus;
    }

    @Override
    public void showDetails() {

    }

    @Override
    public void changePriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void changeSeverity(Severity severity) {
        this.severity = severity;
    }

    @Override
    public void showActivity() {

    }
}
