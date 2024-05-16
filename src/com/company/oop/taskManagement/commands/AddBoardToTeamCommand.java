package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class AddBoardToTeamCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public final static String BOARD_ADDED_TO_TEAM_SUCCESSFULLY = "Board with name:(%s) was added to Team with name:(%s) successfully";

    public AddBoardToTeamCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String boardName = parameters.get(0);
        String teamName = parameters.get(1);
        return addBoardToTeam(boardName, teamName);
    }
    private String addBoardToTeam(String boardName, String teamName){
        Board board = getTaskManagerRepository().getBoardByName(boardName);
        Team team = getTaskManagerRepository().getTeamByName(teamName);
        team.addBoard(board);
        return String.format(BOARD_ADDED_TO_TEAM_SUCCESSFULLY, board.getName(), team.getName());
    }
}
