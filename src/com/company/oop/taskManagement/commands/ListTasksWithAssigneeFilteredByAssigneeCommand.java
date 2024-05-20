package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ListTasksWithAssigneeFilteredByAssigneeCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public ListTasksWithAssigneeFilteredByAssigneeCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String assigneeName = parameters.get(0);
        return getTaskManagerRepository().listAllTasksWithAssigneeFilteredByAssignee(assigneeName);
    }
}
