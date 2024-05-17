package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangeSeverityOfBugCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_SEVERITY_OF_BUG_WAS_CHANGED_SUCCESSFULLY = "The severity of Bug with ID: %d, was changed to %s";

    public ChangeSeverityOfBugCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int bugID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        Severity severity = ParsingHelpers.tryParseEnum(parameters.get(1), Severity.class);
        return changePriorityOfBug(bugID, severity);
    }

    private String changePriorityOfBug(int bugID, Severity severity) {
        Bug bug = getTaskManagerRepository().getBugByID(bugID);
        bug.changeSeverity(severity);
        return String.format(THE_SEVERITY_OF_BUG_WAS_CHANGED_SUCCESSFULLY, bug.getId(), bug.getSeverity());
    }
}
