package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements Board {
    public static final int BOARD_MIN_NAME_LENGTH = 5;
    public static final int BOARD_MAX_NAME_LENGTH = 10;
    public static final String BOARD_NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(BOARD_MIN_NAME_LENGTH, BOARD_MAX_NAME_LENGTH);
    private String name;
    private final List<Task> tasks = new ArrayList<>();
    private final List<String>activityHistory = new ArrayList<>();

    public BoardImpl(String name) {
        setName(name);
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

    private void setName(String name) {
        ValidationHelpers.validateIntRange(name.length(),
                BOARD_MIN_NAME_LENGTH,
                BOARD_MAX_NAME_LENGTH,
                BOARD_NAME_ERR_MESSAGE);
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
