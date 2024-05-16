package com.company.oop.taskManagement.core;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.*;
import com.company.oop.taskManagement.models.contracts.*;
import com.company.oop.taskManagement.models.enums.FeedbackEnums.FeedbackStatus;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;


import java.lang.String;
import java.util.ArrayList;
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

//
//    public List<Team> getTeams() {
//        return new ArrayList<>(teams);
//    }
//
//    public List<Member> getMembers() {
//        return new ArrayList<>(members);
//    }
//
//    public List<Task> getTasks() {
//        return new ArrayList<>(tasks);
//    }
//
//    public List<Bug> getBugs() {
//        return new ArrayList<>(bugs);
//    }
//
//    public List<Story> getStories() {
//        return new ArrayList<>(stories);
//    }
//
//    public List<Feedback> getFeedbacks() {
//        return new ArrayList<>(feedbacks);
//    }


    @Override
    public Bug createBug(String title, String description, Priority priority, Severity severity) {
        Bug bug = new BugImpl(++nextId, title, description,
                priority, severity);
        bugs.add(bug);
        return bug;
    }
    public Bug createBugWithAssignee(String title, String description,
                                     Priority priority, Severity severity, String memberName) {
        Bug bug = new BugImpl(++nextId, title, description,
                priority, severity);
        Member member = getMemberByName(memberName);
        bug.setAssignee(member);
        bugs.add(bug);
        return bug;
    }

    @Override
    public Story createStoryWithoutAssignee(String title, String description, Priority priority, Size size) {
        Story story = new StoryImpl(++nextId, title, description,
                priority, size);
        stories.add(story);
        return story;
    }

    @Override
    public Story createStoryWithAssignee(String title, String description, Priority priority, Size size, String memberName) {
        Story story = new StoryImpl(++nextId, title, description, priority, size);
        Member member = getMemberByName(memberName);
        story.setAssignee(member);
        stories.add(story);
        return story;
    }

    @Override
    public Team createTeam(String name){
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
        Member member = new MemberImpl(name);
        members.add(member);
        return member;
    }
    @Override
    public Feedback createFeedback(String title, String description, int rating) {
        Feedback feedback = new FeedbackImpl(++nextId, title, description, rating);
        feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Member getMemberByName(String memberName) {
        for (Member member : members) {
            if (member.getName().equals(memberName)){
                return member;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such member with this name: %s.", memberName));
    }

    @Override
    public  String showAllMembers() {
        StringBuilder stringBuilder = new StringBuilder("Members: ");
        for (Member member : members) {
            stringBuilder.append(member.getName()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
