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
    private final List<EventLog> history = new ArrayList<>();

    public BoardImpl(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }
    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public List<EventLog> getActivityHistory() {
        return new ArrayList<>(history);
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
        for (Task task1 : tasks) {
            if (task1.getId()==task.getId()){
                throw new IllegalArgumentException (String.format
                        ("There is already existing task with ID: %d in this board.",task.getId()));
            }
        }
        tasks.add(task);
        history.add(new EventLog(String.format("Task with ID: %d was added to the board", task.getId())));
    }

    @Override
    public void removeTask(Task task) {
        if (!tasks.contains(task)){
            throw new IllegalArgumentException(String.format("There is no existing task with ID: %d in this board", task.getId()));
        }
        tasks.remove(task);
        history.add(new EventLog(String.format("Task with ID: %d was removed from this board",task.getId())));
    }

    @Override
    public String showActivity() {
        StringBuilder stringBuilder = new StringBuilder("Board's activity: ");
        stringBuilder.append(System.lineSeparator());
        for (EventLog eventLog : history) {
            stringBuilder.append(eventLog.viewInfo()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
