package com.company.oop.taskManagement.models.contracts;

import com.company.oop.taskManagement.models.enums.Priority;

public interface Bug extends Identifiable, Task{
    String getTitle();
    void changePriority(Priority priority);
    Priority getPriority();
    void changeSeverity();
    void setAssignee(Member member);
}
