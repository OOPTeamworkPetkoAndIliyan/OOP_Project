package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;

import java.util.List;

public class ChangeStatusOfStoryCommand extends BaseCommand{
    public ChangeStatusOfStoryCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
    }
}
