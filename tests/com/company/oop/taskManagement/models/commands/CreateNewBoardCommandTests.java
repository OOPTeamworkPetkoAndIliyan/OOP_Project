package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.CreateNewBoardCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.Utils.UtilsTest;
import com.company.oop.taskManagement.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateNewBoardCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new CreateNewBoardCommand(taskManagerRepository);
        Team testTeam = taskManagerRepository.createTeam(CreateBaseConstants.NAME_TEAM_VALID_LENGTH);
    }

    @Test
    public void execute_Should_CreateNewBoard_When_InputValid(){
        List<String> params = List.of(CreateBaseConstants.NAME_BOARD_VALID_LENGTH);
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getBoards().size());

    }
    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = UtilsTest.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }
    @Test
    public void execute_Should_CreateNewBoardInTeam_When_InputValid(){
        List<String> params = List.of(
                CreateBaseConstants.NAME_BOARD_VALID_LENGTH,
                CreateBaseConstants.NAME_TEAM_VALID_LENGTH);
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getBoards().size());

    }
}
