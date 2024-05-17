package com.company.oop.taskManagement.models;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ValidationHelpers;


import java.util.ArrayList;
import java.util.List;

public class MemberImpl implements Member {
    public static final int MEMBER_MIN_NAME_LENGTH = 5;
    public static final int MEMBER_MAX_NAME_LENGTH = 15;
    public static final java.lang.String MEMBER_NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(MEMBER_MIN_NAME_LENGTH, MEMBER_MAX_NAME_LENGTH);
    private String name;
    private List<Task> tasks;
    private List<EventLog> history;

    public MemberImpl(String name) {
        setName(name);
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
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
        if (tasks.contains(task)){
            throw new IllegalArgumentException(String.format("There is already an assigned task with ID: %d",task.getId()));
        }
        tasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        if (!tasks.contains(task)){
            throw new IllegalArgumentException(String.format("There is no existing task with ID: %d",task.getId()));
        }
        tasks.remove(task);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void showActivity() {

    }
}
// foreach(Member member : members){
// if(member.getName().equals(name))
// }