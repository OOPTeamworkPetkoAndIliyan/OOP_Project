package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Status;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangeStatusOfBugCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_STATUS_OF_BUG_WAS_CHANGED_SUCCESSFULLY = "The status of Bug with ID: %d, was changed to %s";

    public ChangeStatusOfBugCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int bugID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        Status status = ParsingHelpers.tryParseEnum(parameters.get(1), Status.class);
        return changeStatusOfBug(bugID, status);
    }

    private String changeStatusOfBug(int bugID, Status status) {
        Bug bug = getTaskManagerRepository().getBugByID(bugID);
        bug.changeStatus(status);
        return String.format(THE_STATUS_OF_BUG_WAS_CHANGED_SUCCESSFULLY, bug.getId(), bug.getStatus());
    }
}
