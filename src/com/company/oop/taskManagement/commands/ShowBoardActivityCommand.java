package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ShowBoardActivityCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String END_MESSAGE = "--- All activities ---";
    public ShowBoardActivityCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String boardName = parameters.get(0);
        return showBoardActivity(boardName);
    }

    private String showBoardActivity(String boardName) {
        Board board = getTaskManagerRepository().getBoardByName(boardName);
        System.out.println(board.showActivity());
        return END_MESSAGE;
    }
}
