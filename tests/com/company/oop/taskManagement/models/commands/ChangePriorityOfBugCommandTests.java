package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.ChangePriorityOfBugCommand;
import com.company.oop.taskManagement.commands.CreateNewMemberCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.Utils.UtilsTest;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangePriorityOfBugCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new ChangePriorityOfBugCommand(taskManagerRepository);
    }

    @Test
    public void execute_Should_ChangePriorityOfBug_When_ValidInput() {
        Bug bug = taskManagerRepository.createBug(
                "BugTitle111",
                "BugDescription",
                Priority.LOW, Severity.MINOR
        );
        taskManagerRepository.getBugs().add(bug);
        List<String> param = Arrays.asList(String.valueOf(bug.getId()),"High");
        String result = command.execute(param);

        // Assert
        Assertions.assertEquals(Priority.HIGH, bug.getPriority());
        Assertions.assertEquals("The priority of Bug with ID: " + bug.getId() + ", was changed to High", result);
    }
}
