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



    public BugImpl(int id, String title, String description, Member assignee, List<String> stepsToReproduce,
                   Priority priority, Severity severity) {
        super(id,title, description);
        setAssignee(assignee);
        this.stepsToReproduce = stepsToReproduce;
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

    public List<String> getStepsToReproduce() {
        return new ArrayList<>(stepsToReproduce);
    }

    public Priority getPriority() {
        return priority;
    }

    public Severity getSeverity() {
        return severity;
    }

    public BugStatus getStatus() {
        return bugStatus;
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
