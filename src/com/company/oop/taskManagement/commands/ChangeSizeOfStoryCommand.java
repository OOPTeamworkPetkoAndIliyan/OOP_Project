package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangeSizeOfStoryCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_SIZE_OF_STORY_WAS_CHANGED_SUCCESSFULLY = "The size of Story with ID: %d, was changed to %s";

    public ChangeSizeOfStoryCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int storyID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        Size size = ParsingHelpers.tryParseEnum(parameters.get(1), Size.class);
        return changePriorityOfStory(storyID, size);
    }

    private String changePriorityOfStory(int storyID, Size size) {
        Story story = getTaskManagerRepository().getStoryByID(storyID);
        story.changeSize(size);
        return String.format(THE_SIZE_OF_STORY_WAS_CHANGED_SUCCESSFULLY, story.getId(), story.getSize());
    }
}
