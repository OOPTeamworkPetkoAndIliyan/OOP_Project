package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangePriorityOfStoryCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_PRIORITY_OF_STORY_WAS_CHANGED_SUCCESSFULLY = "The priority of Story with ID: %d, was changed to %s";

    public ChangePriorityOfStoryCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int storyID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(1), Priority.class);
        return changePriorityOfStory(storyID, priority);
    }

    private String changePriorityOfStory(int storyID, Priority priority) {
        Story story = getTaskManagerRepository().getStoryByID(storyID);
        story.changePriority(priority);
        return String.format(THE_PRIORITY_OF_STORY_WAS_CHANGED_SUCCESSFULLY, story.getId(), story.getPriority());
    }
}
