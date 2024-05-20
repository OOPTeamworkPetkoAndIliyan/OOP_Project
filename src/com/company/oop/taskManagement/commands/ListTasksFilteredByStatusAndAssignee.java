package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;

import java.util.List;

public class ListTasksFilteredByStatusAndAssignee extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    public ListTasksFilteredByStatusAndAssignee(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
    }
}
