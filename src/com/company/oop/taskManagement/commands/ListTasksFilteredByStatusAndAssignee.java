package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.enums.Status;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ListTasksFilteredByStatusAndAssignee extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    public ListTasksFilteredByStatusAndAssignee(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Status status = ParsingHelpers.tryParseEnum(parameters.get(0), Status.class);
        String assigneeName = parameters.get(1);
       return getTaskManagerRepository().listTasksFilteredByStatusAndAssignee(assigneeName, status);
    }
}
