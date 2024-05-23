package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.ChangeStatusOfBugCommand;
import com.company.oop.taskManagement.commands.ChangeStatusOfFeedbackCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ChangeStatusOfFeedbackCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new ChangeStatusOfFeedbackCommand(taskManagerRepository);
    }

    @Test
    public void execute_Should_ChangeStatusOfFeedback_When_ValidInput() {
        Feedback feedback = taskManagerRepository.createFeedback(
                "FeedbackTitle111",
                "FeedbackDescription",
                4
        );
        taskManagerRepository.getFeedbacks().add(feedback);
        List<String> param = Arrays.asList(String.valueOf(feedback.getId()), "Done");
        String result = command.execute(param);

        // Assert
        Assertions.assertEquals(Status.DONE, feedback.getStatus());
        Assertions.assertEquals("The status of Feedback with ID: " + feedback.getId() + ", was changed to Done", result);
    }
}
