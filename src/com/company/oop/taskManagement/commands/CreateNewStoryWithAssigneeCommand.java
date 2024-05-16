package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewStoryWithAssigneeCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    public final static String STORY_CREATED_SUCCESSFULLY = "Story with title:(%s) was created successfully";

    public CreateNewStoryWithAssigneeCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Size size = ParsingHelpers.tryParseEnum(parameters.get(3), Size.class);
        String memberName = parameters.get(4);
        return addNewStory(title, description, priority, size, memberName);
    }
    private String addNewStory(String title, String description, Priority priority, Size size, String memberName){
        Story story = createNewStory(title, description, priority, size, memberName);
        return String.format(STORY_CREATED_SUCCESSFULLY, story.getTitle());
    }
    private Story createNewStory(String title, String description, Priority priority, Size size, String memberName){
        return getTaskManagerRepository().createStoryWithAssignee(title, description, priority, size, memberName);
    }
}
