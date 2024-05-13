package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements Board {
    public static final int MIN_NAME_LENGTH = 5;
    public static final int MAX_NAME_LENGTH = 10;
    public static final String NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private String name;
    private final List<Task> tasks = new ArrayList<>();
    private final List<String>activityHistory = new ArrayList<>();

    public BoardImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public List<String> getActivityHistory() {
        return new ArrayList<>(activityHistory);
    }

    public void setName(String name) {
        ValidationHelpers.validateIntRange(name.length(),
                MIN_NAME_LENGTH,
                MAX_NAME_LENGTH,
                NAME_ERR_MESSAGE);
        this.name = name;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void showActivity() {
        
    }
}
