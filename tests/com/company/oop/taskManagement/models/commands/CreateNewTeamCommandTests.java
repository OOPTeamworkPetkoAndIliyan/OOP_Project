package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.CreateNewMemberCommand;
import com.company.oop.taskManagement.commands.CreateNewTeamCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.Utils.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateNewTeamCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private Command command;
    private TaskManagerRepository taskManagerRepository;
    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new CreateNewTeamCommand(taskManagerRepository);
    }
    @Test
    public void execute_Should_CreateNewMember_When_ValidInput(){
        List<String> params = List.of(
                CreateBaseConstants.NAME_TEAM_VALID_LENGTH
        );
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getTeam().size());
    }
    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = UtilsTest.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }
}
