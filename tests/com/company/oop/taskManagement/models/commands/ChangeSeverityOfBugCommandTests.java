package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.ChangePriorityOfBugCommand;
import com.company.oop.taskManagement.commands.ChangeSeverityOfBugCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ChangeSeverityOfBugCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new ChangeSeverityOfBugCommand(taskManagerRepository);
    }

    @Test
    public void execute_Should_ChangeSeverityOfBug_When_ValidInput() {
        Bug bug = taskManagerRepository.createBug(
                "BugTitle111",
                "BugDescription",
                Priority.LOW, Severity.MINOR
        );
        taskManagerRepository.getBugs().add(bug);
        List<String> param = Arrays.asList(String.valueOf(bug.getId()),"Major");
        String result = command.execute(param);

        // Assert
        Assertions.assertEquals(Severity.MAJOR, bug.getSeverity());
        Assertions.assertEquals("The severity of Bug with ID: " + bug.getId() + ", was changed to Major", result);
    }
}
