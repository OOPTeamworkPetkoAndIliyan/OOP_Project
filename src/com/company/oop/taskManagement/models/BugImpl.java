package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Bug;

import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.BugEnums.BugStatus;

import java.util.ArrayList;
import java.util.List;

public class BugImpl extends TaskImpl implements Bug {
    private Priority priority;
    private Severity severity;
    private BugStatus bugStatus;
    private Member assignee;
    private List<String> stepsToReproduce;


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
    @Override
    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }
    @Override
    public void addStepsToReproduce(List<String> stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
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
    public void changeStatus(BugStatus bugStatus) {
        String previousStatus = this.bugStatus.toString();
        this.bugStatus = bugStatus;
        String presentStatus = this.bugStatus.toString();
        getHistory().add(new EventLog(String.format("The status of item with ID: %d switched from %s to %s",
                getId(), previousStatus, presentStatus)));
    }
    @Override
    public void changePriority(Priority priority) {
        String previousPriority = this.priority.toString();
        this.priority = priority;
        String presentPriority = this.priority.toString();
        getHistory().add(new EventLog(String.format("The priority of item with ID: %d switched from %s to %s",
                getId(), previousPriority, presentPriority)));
    }

    @Override
    public void changeSeverity(Severity severity) {
        String previousSeverity = this.severity.toString();
        this.severity = severity;
        String presentSeverity = this.severity.toString();
        getHistory().add(new EventLog(String.format("The severity of item with ID: %d switched from %s to %s",
                getId(), previousSeverity, presentSeverity)));
    }
    @Override
    public String showDetails(){
        StringBuilder str = new StringBuilder(String.format("%s", super.showDetails()));
        str.append(String.format("Priority: %s", getPriority())).append(System.lineSeparator());
        str.append(String.format("Severity: %s", getSeverity())).append(System.lineSeparator());
        str.append(String.format("Status: %s", getStatus())).append(System.lineSeparator());
        if (getAssignee() != null){
            str.append(String.format("Assignee: %s", getAssignee().getName())).append(System.lineSeparator());
        }
        str.append("Steps to reproduce: ").append(System.lineSeparator());
        for (String s : stepsToReproduce) {
            str.append(s).append(System.lineSeparator());
        }
        return str.toString();
    }
}
