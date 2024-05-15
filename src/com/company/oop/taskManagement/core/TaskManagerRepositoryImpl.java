package com.company.oop.taskManagement.core;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.BugImpl;
import com.company.oop.taskManagement.models.FeedbackImpl;
import com.company.oop.taskManagement.models.StoryImpl;
import com.company.oop.taskManagement.models.contracts.*;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;


import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerRepositoryImpl implements TaskManagerRepository {
    private int nextId;
    private final List<Team> teams;
    private final List<Bug> bugs;
    private final List<Story> stories;
    private final List<Feedback> feedbacks;

    public TaskManagerRepositoryImpl() {
        nextId = 0;
        this.teams = new ArrayList<>();
        this.bugs = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    @Override
    public Bug createBug(String title, String description, Priority priority, Severity severity) {
        Bug bug = new BugImpl(++nextId, title, description,
                priority, severity);
        bugs.add(bug);
        return bug;
    }

    @Override
    public Story createStory(String title, String description, String assignee, Size size, Priority priority) {
        Story story = new StoryImpl(++nextId, title, description, assignee,
                size, priority);
        stories.add(story);
        return story;
    }

    @Override
    public Feedback createFeedback(String title, String description, int rating) {
        Feedback feedback = new FeedbackImpl(++nextId, title, description, rating);
        feedbacks.add(feedback);
        return feedback;
    }
}
