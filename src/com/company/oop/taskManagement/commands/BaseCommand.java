package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;

import java.util.List;

public abstract class BaseCommand implements Command {
    private final TaskManagerRepository taskManagerRepository;

    protected BaseCommand(TaskManagerRepository taskManagerRepository) {
        this.taskManagerRepository = taskManagerRepository;
    }

    protected TaskManagerRepository getTaskManagerRepository() {
        return taskManagerRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        return executeCommand(parameters);
    }



    protected abstract String executeCommand(List<String> parameters);
}
