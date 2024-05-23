package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.AddBoardToTeamCommand;
import com.company.oop.taskManagement.commands.CreateNewBugWithAssigneeCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddBoardToTeamCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new AddBoardToTeamCommand(taskManagerRepository);

    }

    @Test
    public void execute_Should_AddBoardToTeam_When_ValidInput() {
        Board board = taskManagerRepository.createBoard(CreateBaseConstants.NAME_BOARD_VALID_LENGTH);
        Team team = taskManagerRepository.createTeam(CreateBaseConstants.NAME_TEAM_VALID_LENGTH);
        List<String> params = List.of(board.getName(), team.getName());
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getTeam().size());
    }

}
