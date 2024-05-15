package com.company.oop.taskManagement.core.contracts;

import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;


import java.util.List;

public interface TaskManagerRepository {
    Bug createBug(String title, String description,
                  Priority priority, Severity severity);
    Bug createBugWithAssignee(String title, String description,
                                     Priority priority, Severity severity, String memberName);
    Member createMember(String name);
    Story createStory(String title, String description, String assignee, Size size, Priority priority);
    Feedback createFeedback(String title, String description, int rating);
    Member getMemberByName(String memberName);
}
