package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewBugWithAssigneeCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    public final static String BUG_CREATED_SUCCESSFULLY = "Bug with ID: %d and title: %s was created successfully";
    public final static String BUG_CREATED_SUCCESSFULLY_IN_BOARD = "Bug with ID: %d and title %s was created successfully in board with name: %s";
    public CreateNewBugWithAssigneeCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCountWithOptionalParam(parameters,
                EXPECTED_NUMBER_OF_ARGUMENTS,
                EXPECTED_NUMBER_OF_ARGUMENTS + 1);
        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Severity severity = ParsingHelpers.tryParseEnum(parameters.get(3), Severity.class);
        String memberName = parameters.get(4);
        if (parameters.size() == EXPECTED_NUMBER_OF_ARGUMENTS + 1){
            String boardName = parameters.get(5);
            return addNewBugInBoard(title, description, priority, severity, memberName, boardName);
        }
        return addNewBug(title, description, priority, severity, memberName);
    }

    private String addNewBugInBoard(String title, String description, Priority priority, Severity severity, String memberName, String boardName) {
        Board board = getTaskManagerRepository().getBoardByName(boardName);
        Bug bug = createNewBug(title, description, priority, severity, memberName);
        board.addTask(bug);
        return String.format(BUG_CREATED_SUCCESSFULLY_IN_BOARD,bug.getId(), bug.getTitle(), board.getName());
    }

    private String addNewBug(String title, String description, Priority priority, Severity severity, String memberName){
        Bug bug = createNewBug(title, description, priority, severity, memberName);
        return String.format(BUG_CREATED_SUCCESSFULLY, bug.getId(), bug.getTitle());
    }
    private Bug createNewBug(String title, String description, Priority priority, Severity severity, String memberName){
        return getTaskManagerRepository().createBugWithAssignee(title, description, priority, severity, memberName);
    }
}
