package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Task;

import java.util.Comparator;
import java.util.List;

public class ListAllTasksSortedByTitleCommand extends BaseCommand {
    public ListAllTasksSortedByTitleCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return getTaskManagerRepository().listAllTasksSortedByTitle();
    }
}