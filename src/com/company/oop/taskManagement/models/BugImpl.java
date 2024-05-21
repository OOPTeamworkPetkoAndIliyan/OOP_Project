package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Bug;

import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BugImpl extends TaskImpl implements Bug {
    Status[] BUG_POSSIBLE_STATUS = new Status[]{Status.ACTIVE, Status.DONE};
    private Priority priority;
    private Severity severity;
    private Status status;
    private Member assignee;
    private List<String> stepsToReproduce;


    public BugImpl(int id, String title, String description,
                   Priority priority, Severity severity) {
        super(id,title, description);
        this.stepsToReproduce = new ArrayList<>();
        this.status = Status.ACTIVE;
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
    public Status getStatus() {
        return status;
    }
    @Override
    public void changeStatus(Status status) {
        String previousStatus = this.status.toString();
        if (Arrays.stream(BUG_POSSIBLE_STATUS).noneMatch(s -> s == status)) {
            throw new IllegalArgumentException("Not a valid status for bug");
        }
        this.status = status;
        String presentStatus = this.status.toString();
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
