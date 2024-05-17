package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.commands.BaseCommand;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangePriorityOfBugCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_PRIORITY_OF_BUG_WAS_CHANGED_SUCCESSFULLY = "The priority of Bug with ID: %d, was changed to %s";

    public ChangePriorityOfBugCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int bugID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(1), Priority.class);
        return changePriorityOfBug(bugID, priority);
    }

    private String changePriorityOfBug(int bugID, Priority priority) {
        Bug bug = getTaskManagerRepository().getBugByID(bugID);
        bug.changePriority(priority);
        return String.format(THE_PRIORITY_OF_BUG_WAS_CHANGED_SUCCESSFULLY, bug.getId(), bug.getPriority());
    }
}
