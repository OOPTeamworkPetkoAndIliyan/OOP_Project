package com.company.oop.taskManagement.models.contracts;

import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
public interface Story extends Identifiable, Task{
    void setAssignee(Member assignee);
    void changePriority(Priority priority);
    Priority getPriority();
    void changeSize(Size size);
    Size getSize();


}
