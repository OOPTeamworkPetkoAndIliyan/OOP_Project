package com.company.oop.taskManagement.core;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.*;
import com.company.oop.taskManagement.models.contracts.*;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.models.enums.Status;


import java.lang.String;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManagerRepositoryImpl implements TaskManagerRepository {
    private int nextId;
    private final List<Team> teams;
    private final List<Board> boards;
    private final List<Member> members;
    private final List<Task> tasks;
    private final List<Bug> bugs;
    private final List<Story> stories;
    private final List<Feedback> feedbacks;

    public TaskManagerRepositoryImpl() {
        nextId = 0;
        this.teams = new ArrayList<>();
        this.members = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.bugs = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.boards = new ArrayList<>();
    }

    @Override
    public List<Member> getMember() {
        return new ArrayList<>(members);
    }

    @Override
    public List<Team> getTeam() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public List<Bug> getBugs() {
        return new ArrayList<>(bugs);
    }

    @Override
    public List<Story> getStories() {
        return new ArrayList<>(stories);
    }

    @Override
    public List<Feedback> getFeedbacks() {
        return new ArrayList<>(feedbacks);
    }

    @Override
    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public Bug createBug(String title, String description, Priority priority, Severity severity) {
        Bug bug = new BugImpl(++nextId, title, description,
                priority, severity);
        bugs.add(bug);
        tasks.add(bug);
        return bug;
    }

    public Bug createBugWithAssignee(String title, String description,
                                     Priority priority, Severity severity, String memberName) {
        Bug bug = new BugImpl(++nextId, title, description,
                priority, severity);
        Member member = getMemberByName(memberName);
        bug.setAssignee(member);
        bugs.add(bug);
        tasks.add(bug);
        return bug;
    }

    @Override
    public Story createStoryWithoutAssignee(String title, String description, Priority priority, Size size) {
        Story story = new StoryImpl(++nextId, title, description,
                priority, size);
        stories.add(story);
        tasks.add(story);
        return story;
    }

    @Override
    public Story createStoryWithAssignee(String title, String description, Priority priority, Size size, String memberName) {
        Story story = new StoryImpl(++nextId, title, description, priority, size);
        Member member = getMemberByName(memberName);
        story.setAssignee(member);
        stories.add(story);
        tasks.add(story);
        return story;
    }

    @Override
    public Team createTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                throw new IllegalArgumentException(String.format("There is already an existing team with name: %s", name));
            }
        }
        Team team = new TeamImpl(name);
        teams.add(team);
        return team;
    }

    @Override
    public Board createBoard(String name) {
        Board board = new BoardImpl(name);
        boards.add(board);
        return board;
    }

    @Override
    public Member createMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                throw new IllegalArgumentException(String.format("There is already an existing member with name: %s", name));
            }
        }
        Member member = new MemberImpl(name);
        members.add(member);
        return member;
    }

    @Override
    public Feedback createFeedback(String title, String description, int rating) {
        Feedback feedback = new FeedbackImpl(++nextId, title, description, rating);
        feedbacks.add(feedback);
        tasks.add(feedback);
        return feedback;
    }

    @Override
    public Comment createComment(String author, String content) {
        return new CommentImpl(author, content);
    }

    @Override
    public Member getMemberByName(String memberName) {
        for (Member member : members) {
            if (member.getName().equals(memberName)) {
                return member;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such member with this name: %s.", memberName));
    }


    @Override
    public String showAllMembers() {
        StringBuilder stringBuilder = new StringBuilder("Members: ");
        for (Member member : members) {
            stringBuilder.append(member.getName()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String showAllTeams() {
        StringBuilder stringBuilder = new StringBuilder("Teams: ");
        for (Team team : teams) {
            stringBuilder.append(team.getName()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String showAllBoards() {
        StringBuilder stringBuilder = new StringBuilder("Boards: ");
        for (Board board : boards) {
            stringBuilder.append(board.getName()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String showAllTeamMembers(String teamName) {
        Team team = getTeamByName(teamName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Members for team ").append(team.getName()).append(":").append(System.lineSeparator());
        for (Member member : team.getMembers()) {
            stringBuilder.append(member.getName()).append(System.lineSeparator());

        }
        return stringBuilder.toString();
    }

    @Override
    public Team getTeamByName(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such team with name: %s", teamName));
    }

    @Override
    public Board getBoardByName(String boardName) {
        for (Board board : boards) {
            if (board.getName().equals(boardName)) {
                return board;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such board with name: %s", boardName));
    }

    @Override
    public Task getTaskByID(int taskID) {
        for (Task task : tasks) {
            if (task.getId() == taskID) {
                return task;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such task with ID: %d", taskID));
    }

    @Override
    public Bug getBugByID(int bugID) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugID) {
                return bug;
            }
        }
        throw new IllegalArgumentException(String.format("There is no bug with ID: %d", bugID));
    }

    @Override
    public Story getStoryByID(int storyID) {
        for (Story story : stories) {
            if (story.getId() == storyID) {
                return story;
            }
        }
        throw new IllegalArgumentException(String.format("There is no story with ID: %d", storyID));
    }

    @Override
    public Feedback getFeedbackByID(int feedbackID) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getId() == feedbackID) {
                return feedback;
            }
        }
        throw new IllegalArgumentException(String.format("There is no feedback with ID: %d", feedbackID));
    }

    @Override
    public String listAllTasksFilteredByTitle(String title) {
        List<Task> tasks = getTasks().stream().filter(task -> task.getTitle().contains(title)).toList();
        StringBuilder str = new StringBuilder("All tasks filtered by title: ");
        str.append(System.lineSeparator());
        for (Task task : tasks) {
            str.append(task.showDetails()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String listAllTasksSortedByTitle() {
        List<Task> tasks = getTasks().stream().sorted(Comparator.comparing((Task::getTitle))).toList();
        StringBuilder str = new StringBuilder("All tasks sorted by title: ");
        str.append(System.lineSeparator());
        for (Task task : tasks) {
            str.append(task.showDetails()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String listTasksWithAssigneeSortedByTitle() {
        List<Task> tasks = getTasks().stream().filter(task -> task.getAssignee() != null)
                .sorted(Comparator.comparing(Task::getTitle)).toList();
        StringBuilder str = new StringBuilder("All tasks with assignee sorted by title: ");
        str.append(System.lineSeparator());
        for (Task task : tasks) {
            str.append(task.showDetails()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String listAllTasksWithAssigneeFilteredByAssignee(String assigneeName) {
        List<Task> tasks = getTasks().stream().filter(task -> task.getAssignee()!=null)
                .filter(task -> task.getAssignee().getName().equals(assigneeName)).toList();
        StringBuilder str = new StringBuilder("All tasks with assignee filtered by assignee: ");
        str.append(System.lineSeparator());
        for (Task task : tasks) {
            str.append(task.showDetails()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String listTasksFilteredByStatusAndAssignee(String assigneeName, Status status) {
        List<Task> tasks = getTasks().stream().filter(task -> task.getAssignee()!=null)
                .filter(task -> task.getStatus().equals(status))
                .filter(task -> task.getAssignee().getName().equals(assigneeName)).toList();
        StringBuilder str = new StringBuilder("All tasks filtered by assignee and by status: ");
        str.append(System.lineSeparator());
        for (Task task : tasks) {
            str.append(task.showDetails()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String filterTaskTypeByStatusAndAssignee(String taskType, Status status, String assigneeName) {
        StringBuilder str = new StringBuilder();
        switch (taskType.toUpperCase()){
            case "BUG":
                List<Bug> bugs1 = bugs.stream().
                        filter(bug -> bug.getStatus().toString().equals(status.toString())
                                && bug.getAssignee() != null && bug.getAssignee().getName().equals(assigneeName))
                        .toList();
                str.append(String.format("All bugs of %s with status %s", assigneeName, status.toString()));
                str.append(System.lineSeparator());
                for (Bug bug : bugs1) {
                    str.append(bug.showDetails()).append(System.lineSeparator());
                }
                break;
            case "STORY":
                List<Story> stories1 = stories.stream().
                        filter(story -> story.getStatus().toString().equalsIgnoreCase(status.toString())
                                && story.getAssignee() != null && story.getAssignee().getName().equals(assigneeName))
                        .toList();
                str.append(String.format("All stories of %s with status %s", assigneeName, status.toString()));
                str.append(System.lineSeparator());
                for (Story story : stories1) {
                    str.append(story.showDetails()).append(System.lineSeparator());
                }
                break;
            case "FEEDBACK":
                throw new IllegalArgumentException("Feedbacks do not have an assignee");
        }
        return str.toString();
    }

    @Override
    public String filterTaskTypeByEntityType(String taskType, String entityType) {
        StringBuilder str = new StringBuilder();
        switch (taskType.toUpperCase()){
            case "BUG":
                List<Bug> bugs1 = new ArrayList<>();
                if (entityType.equalsIgnoreCase("status")){
                    bugs1 = bugs.stream().filter(bug -> bug.getStatus().toString().equalsIgnoreCase(entityType)).toList();
                    str.append(String.format("All bugs with status %s", entityType));
                    str.append(System.lineSeparator());
                    for (Bug bug : bugs1) {
                        str.append(bug.showDetails()).append(System.lineSeparator());
                    }
                }else {
                    bugs1 = bugs.stream().filter(bug ->bug.getAssignee() != null && bug.getAssignee().getName().equalsIgnoreCase(entityType)).toList();
                    str.append(String.format("All bugs of %s", entityType));
                    str.append(System.lineSeparator());
                    for (Bug bug : bugs1) {
                        str.append(bug.showDetails()).append(System.lineSeparator());
                    }
                }
                break;
            case "STORY":
                List<Story> stories1 = new ArrayList<>();
                if (entityType.equalsIgnoreCase("status")){
                    stories1 = stories.stream().filter(story -> story.getStatus().toString().equalsIgnoreCase(entityType)).toList();
                    str.append(String.format("All stories with status %s", entityType));
                    str.append(System.lineSeparator());
                    for (Story story : stories1) {
                        str.append(story.showDetails()).append(System.lineSeparator());
                    }
                }else {
                    stories1 = stories.stream().filter(story ->story.getAssignee() != null && story.getAssignee().getName().equalsIgnoreCase(entityType)).toList();
                    str.append(String.format("All stories of %s", entityType));
                    str.append(System.lineSeparator());
                    for (Story story : stories1) {
                        str.append(story.showDetails()).append(System.lineSeparator());
                    }
                }
                break;
            case "FEEDBACK":
                List<Feedback> feedbacks1 = new ArrayList<>();
                if (entityType.equalsIgnoreCase("status")){
                    feedbacks1 = feedbacks.stream().filter(story -> story.getStatus().toString().equalsIgnoreCase(entityType)).toList();
                    str.append(String.format("All feedbacks with status %s", entityType));
                    str.append(System.lineSeparator());
                    for (Feedback feedback : feedbacks1) {
                        str.append(feedback.showDetails()).append(System.lineSeparator());
                    }
                }else {
                    throw new IllegalArgumentException("Feedbacks do not have an assignee");
                }
                break;
        }
        return str.toString();
    }
}
