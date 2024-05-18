package com.company.oop.taskManagement.models.contracts;

import com.company.oop.taskManagement.models.enums.BugEnums.BugStatus;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;

import java.util.List;

public interface Bug extends Identifiable, Task{
    String getTitle();
    void changePriority(Priority priority);
    Priority getPriority();
    Severity getSeverity();
    BugStatus getStatus();
    void changeSeverity(Severity severity);
    void setAssignee(Member member);

    void changeStatus(BugStatus bugStatus);
    void addStepsToReproduce(List<String> stepsToReproduce);
}
