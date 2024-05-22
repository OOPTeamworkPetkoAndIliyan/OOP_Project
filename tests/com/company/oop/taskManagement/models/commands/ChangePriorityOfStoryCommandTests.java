package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.ChangePriorityOfBugCommand;
import com.company.oop.taskManagement.commands.ChangePriorityOfStoryCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ChangePriorityOfStoryCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new ChangePriorityOfStoryCommand(taskManagerRepository);
    }

    @Test
    public void execute_Should_ChangePriorityOfStory_When_ValidInput() {
        Story story = taskManagerRepository.createStoryWithoutAssignee(
                "StoryTitle111",
                "StoryDescription",
                Priority.LOW, Size.LARGE
        );
        taskManagerRepository.getStories().add(story);
        List<String> param = Arrays.asList(String.valueOf(story.getId()),"High");
        String result = command.execute(param);

        // Assert
        Assertions.assertEquals(Priority.HIGH, story.getPriority());
        Assertions.assertEquals("The priority of Story with ID: " + story.getId() + ", was changed to High", result);
    }
}
