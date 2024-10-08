package com.company.oop.taskManagement.core.contracts;

import com.company.oop.taskManagement.models.contracts.*;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.models.enums.Status;


import java.util.List;

public interface TaskManagerRepository {
    List<Task> getTasks();

    List<Member> getMember();

    List<Team> getTeam();

    List<Bug> getBugs();

    List<Story> getStories();

    List<Feedback> getFeedbacks();

    List<Board> getBoards();

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

    Comment createComment(String author, String content);

    Member getMemberByName(String memberName);

    String showAllMembers();

    String showAllTeams();

    String showAllBoards();

    String showAllTeamMembers(String teamName);

    Team getTeamByName(String teamName);

    Board getBoardByName(String boardName);

    Task getTaskByID(int taskID);

    Bug getBugByID(int bugID);

    Story getStoryByID(int storyID);

    Feedback getFeedbackByID(int feedbackID);

    String listAllTasksFilteredByTitle(String title);

    String listAllTasksSortedByTitle();

    String listTasksWithAssigneeSortedByTitle();

    String listAllTasksWithAssigneeFilteredByAssignee(String assigneeName);

    String listTasksFilteredByStatusAndAssignee(String assigneeName, Status status);

    String filterTaskTypeByStatusAndAssignee(String taskType, Status status, String assigneeName);

    String filterTaskTypeByEntityType(String taskType, String entityType);
}
