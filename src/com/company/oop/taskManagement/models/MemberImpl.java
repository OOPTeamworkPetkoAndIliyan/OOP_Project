package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl implements Member {
    private String name;
    private List<Task> tasks;
    private List<String> activityHistory;

    public MemberImpl(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        this.activityHistory = new ArrayList<>();
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
