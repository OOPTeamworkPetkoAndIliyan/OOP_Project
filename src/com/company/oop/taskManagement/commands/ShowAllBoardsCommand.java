package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;

import java.util.List;

public class ShowAllBoardsCommand extends BaseCommand{
    protected ShowAllBoardsCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        if (!parameters.isEmpty()) {
            throw new IllegalArgumentException("There should be non parameters");
        }
        return getTaskManagerRepository().showAllTeams();
    }
}
