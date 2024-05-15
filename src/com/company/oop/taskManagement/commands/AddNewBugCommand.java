package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.Arrays;
import java.util.List;

public class AddNewBugCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    public final static String BUG_CREATED_SUCCESSFULLY = "Bug with title:(%s) was created successfully";
    public AddNewBugCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        //String title, String description, Member assignee, List<String> stepsToReproduce,
        // Priority priority, Severity severity
        String title = parameters.get(0);
        String description = parameters.get(1);
      //  String assignee = parameters.get(2);
//        List<String> stepsToReproduce = Arrays.stream(parameters.get(3).split(" ")).toList();
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Severity severity = ParsingHelpers.tryParseEnum(parameters.get(3), Severity.class);

        return addNewBug(title, description, priority, severity);
    }
    private String addNewBug(String title, String description, Priority priority, Severity severity){
        Bug bug = createNewBug(title, description, priority, severity);
        return String.format(BUG_CREATED_SUCCESSFULLY, bug.getTitle());
    }
    private Bug createNewBug(String title, String description, Priority priority, Severity severity){
        return getTaskManagerRepository().createBug(title, description, priority, severity);
    }
}
