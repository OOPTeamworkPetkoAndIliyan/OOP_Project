package com.company.oop.taskManagement.core.contracts;

import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.BugEnums.Priority;
import com.company.oop.taskManagement.models.enums.BugEnums.Severity;
import com.company.oop.taskManagement.models.enums.StoryEnums.Size;

import java.util.List;

public interface TaskManagerRepository {
    Bug createBug(String title, String description, Member assignee, List<String> stepsToReproduce,
                  Priority priority, Severity severity);
    Story createStory(String title, String description, Member assignee, Size size,
                     com.company.oop.taskManagement.models.enums.StoryEnums.Priority priority);
    Feedback createFeedback(String title, String description, int rating);
}
