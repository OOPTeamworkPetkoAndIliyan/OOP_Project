package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;

import java.util.List;

public class ListTasksWithAssigneeSortedByTitleCommand extends BaseCommand{
    public ListTasksWithAssigneeSortedByTitleCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return getTaskManagerRepository().listTasksWithAssigneeSortedByTitle();
    }
}
