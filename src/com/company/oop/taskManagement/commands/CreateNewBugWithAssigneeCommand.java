package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewBugWithAssigneeCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    public final static String BUG_CREATED_SUCCESSFULLY = "Bug with title:(%s) was created successfully";
    public CreateNewBugWithAssigneeCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Severity severity = ParsingHelpers.tryParseEnum(parameters.get(3), Severity.class);
        String memberName = parameters.get(4);

        return addNewBug(title, description, priority, severity, memberName);
    }
    private String addNewBug(String title, String description, Priority priority, Severity severity, String memberName){
        Bug bug = createNewBug(title, description, priority, severity, memberName);
        return String.format(BUG_CREATED_SUCCESSFULLY, bug.getTitle());
    }
    private Bug createNewBug(String title, String description, Priority priority, Severity severity, String memberName){
        return getTaskManagerRepository().createBugWithAssignee(title, description, priority, severity, memberName);
    }
}
