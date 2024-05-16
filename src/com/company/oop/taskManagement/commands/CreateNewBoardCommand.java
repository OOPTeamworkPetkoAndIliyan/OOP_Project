package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewBoardCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public final static String BOARD_CREATED_SUCCESSFULLY = "Board with name:(%s) was created successfully";
    public CreateNewBoardCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);

        return addNewBoard(name);
    }
    private String addNewBoard(String name){
        Board board = createNewBoard(name);
        return String.format(BOARD_CREATED_SUCCESSFULLY, board.getName());
    }
    private Board createNewBoard(String name){
        return getTaskManagerRepository().createBoard(name);
    }
}
