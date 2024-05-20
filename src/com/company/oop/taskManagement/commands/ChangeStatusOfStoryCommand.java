package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Status;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangeStatusOfStoryCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_STATUS_OF_STORY_WAS_CHANGED_SUCCESSFULLY = "The status of Story with ID: %d, was changed to %s";

    public ChangeStatusOfStoryCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int storyID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        Status storyStatus = ParsingHelpers.tryParseEnum(parameters.get(1), Status.class);
        return changeStatusOfStory(storyID, storyStatus);
    }

    private String changeStatusOfStory(int storyID, Status storyStatus) {
        Story story = getTaskManagerRepository().getStoryByID(storyID);
        story.changeStatus(storyStatus);
        return String.format(THE_STATUS_OF_STORY_WAS_CHANGED_SUCCESSFULLY, story.getId(), story.getStatus());
    }
}
