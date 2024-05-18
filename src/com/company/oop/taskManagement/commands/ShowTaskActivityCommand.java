package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ShowTaskActivityCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String END_MESSAGE = "--- All activities ---";
    public static final String INVALID_ID = "Invalid ID";

    public ShowTaskActivityCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int taskID = ParsingHelpers.tryParseInt(parameters.get(0), INVALID_ID);
        return showTaskActivity(taskID);
    }

    private String showTaskActivity(int taskID) {
        Task task = getTaskManagerRepository().getTaskByID(taskID);
        System.out.println(task.showActivity());
        return END_MESSAGE;
    }
}
