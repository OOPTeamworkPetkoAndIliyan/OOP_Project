package com.company.oop.taskManagement.core.contracts;

import com.company.oop.taskManagement.models.contracts.*;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;


import java.util.List;

public interface TaskManagerRepository {
    Board createBoard(String name);
    Team createTeam(String name);
    Member createMember(String name);
    Bug createBug(String title, String description,
                  Priority priority, Severity severity);
    Bug createBugWithAssignee(String title, String description,
                                     Priority priority, Severity severity, String memberName);
    Story createStoryWithoutAssignee(String title, String description, Priority priority, Size size);
    Story createStoryWithAssignee(String title, String description, Priority priority, Size size, String memberName);
    Feedback createFeedback(String title, String description, int rating);
    Member getMemberByName(String memberName);
     String showAllMembers();

    Team getTeamByName(String teamName);
}
