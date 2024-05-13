package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl implements Member {
    public static final int MEMBER_MIN_NAME_LENGTH = 5;
    public static final int MEMBER_MAX_NAME_LENGTH = 15;
    public static final String MEMBER_NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(MEMBER_MIN_NAME_LENGTH, MEMBER_MAX_NAME_LENGTH);
    private String name;
    private List<Task> tasks;
    private List<String> activityHistory;

    public MemberImpl(String name) {
        setName(name);
        this.tasks = new ArrayList<>();
        this.activityHistory = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.validateIntRange(name.length(),
                MEMBER_MIN_NAME_LENGTH,
                MEMBER_MAX_NAME_LENGTH,
                MEMBER_NAME_ERR_MESSAGE);
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
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void showActivity() {

    }
}
