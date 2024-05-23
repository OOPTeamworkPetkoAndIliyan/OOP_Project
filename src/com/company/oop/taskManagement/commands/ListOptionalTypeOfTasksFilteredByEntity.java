package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.enums.Status;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ListOptionalTypeOfTasksFilteredByEntity extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String INVALID_STATUS = "There is no such status";

    public ListOptionalTypeOfTasksFilteredByEntity(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCountWithOptionalParam(parameters,
                EXPECTED_NUMBER_OF_ARGUMENTS,
                EXPECTED_NUMBER_OF_ARGUMENTS +1);
        String taskType = parameters.get(0);
        if (EXPECTED_NUMBER_OF_ARGUMENTS == 2) {
            String entityType = parameters.get(1);
            return listOptionalTypeOfTasksFilteredByStatusOrAssignee(taskType, entityType);
        }else {
            Status status = ParsingHelpers.tryParseEnum(parameters.get(1), Status.class);
            String assigneeName = parameters.get(2);
            return listOptionalTypeOfTasksFilteredByStatusAndAssignee(taskType, status, assigneeName);
        }
    }

    private String listOptionalTypeOfTasksFilteredByStatusAndAssignee(String taskType, Status status, String assigneeName) {
        return getTaskManagerRepository().filterTaskTypeByStatusAndAssignee(taskType, status, assigneeName);
    }

    private String listOptionalTypeOfTasksFilteredByStatusOrAssignee(String taskType, String entityType){
        return getTaskManagerRepository().filterTaskTypeByEntityType(taskType, entityType);
    }
}
