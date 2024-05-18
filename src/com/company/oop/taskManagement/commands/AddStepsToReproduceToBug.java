package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.Arrays;
import java.util.List;

public class AddStepsToReproduceToBug extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String INVALID_ID = "Invalid ID";
    public static final String STEPS_TO_REPRODUCE_SUCCESSFULLY_ADDED = "Steps to reproduce were added to bug with ID: %d";

    public AddStepsToReproduceToBug(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        List<String> stepsToReproduce = Arrays.stream(parameters.get(0).split(";")).toList();
        int bugID = ParsingHelpers.tryParseInt(parameters.get(1), INVALID_ID);
        return addStepsToReproduce(stepsToReproduce, bugID);
    }

    private String addStepsToReproduce(List<String> stepsToReproduce, int bugID) {
        Bug bug = getTaskManagerRepository().getBugByID(bugID);
        bug.addStepsToReproduce(stepsToReproduce);
        return String.format(STEPS_TO_REPRODUCE_SUCCESSFULLY_ADDED, bug.getId());
    }
}
