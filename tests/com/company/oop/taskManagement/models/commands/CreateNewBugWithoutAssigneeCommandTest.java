package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.CreateNewBugWithAssigneeCommand;
import com.company.oop.taskManagement.commands.CreateNewBugWithoutAssigneeCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.Utils.UtilsTest;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateNewBugWithoutAssigneeCommandTest {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    private Command command;
    private TaskManagerRepository taskManagerRepository;
    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new CreateNewBugWithoutAssigneeCommand(taskManagerRepository);
        Board board = taskManagerRepository.createBoard(CreateBaseConstants.NAME_BOARD_VALID_LENGTH);
        Member member = taskManagerRepository.createMember(CreateBaseConstants.NAME_MEMBER_VALID_LENGTH);
    }
    @Test
    public void execute_Should_CreateNewBugWithoutAssignee_When_ValidInput(){
        List<String> params = List.of(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                Priority.HIGH.toString(),
                Severity.CRITICAL.toString()
        );
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getBugs().size());
    }
    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = UtilsTest.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> command.execute(params));
    }
    @Test
    public void execute_Should_CreateNewBugWithoutAssigneeInBoard_When_ValidInput(){
        List<String> params = List.of(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                Priority.HIGH.toString(),
                Severity.CRITICAL.toString(),
                CreateBaseConstants.NAME_BOARD_VALID_LENGTH
        );
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getBugs().size());
        Assertions.assertEquals(1, taskManagerRepository.getBoards().size());
    }
}
