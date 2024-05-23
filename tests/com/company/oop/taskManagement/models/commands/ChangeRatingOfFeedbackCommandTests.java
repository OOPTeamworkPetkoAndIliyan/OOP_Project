package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.ChangePriorityOfStoryCommand;
import com.company.oop.taskManagement.commands.ChangeRatingOfFeedbackCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ChangeRatingOfFeedbackCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new ChangeRatingOfFeedbackCommand(taskManagerRepository);
    }
    @Test
    public void execute_Should_ChangeRatingOfFeedback_When_ValidInput(){
        Feedback feedback = taskManagerRepository.createFeedback(
                "FeedbackTitle111",
                "FeedbackDescription",
                5
        );
        taskManagerRepository.getFeedbacks().add(feedback);
        List<String> param = Arrays.asList(String.valueOf(feedback.getId()),String.valueOf(8));
        String result = command.execute(param);
        Assertions.assertEquals(8, feedback.getRating());
        Assertions.assertEquals("The rating of Feedback with ID: " + feedback.getId() + ", was changed to 8", result);
    }
}
