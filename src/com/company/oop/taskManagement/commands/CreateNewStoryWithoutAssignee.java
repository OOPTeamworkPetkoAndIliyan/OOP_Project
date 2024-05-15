package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewStoryWithoutAssignee extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    public final static String STORY_CREATED_SUCCESSFULLY = "Story with title:(%s) was created successfully";
    public CreateNewStoryWithoutAssignee(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Size size = ParsingHelpers.tryParseEnum(parameters.get(3), Size.class);

        return addNewStory(title, description, priority, size);
    }
    private String addNewStory(String title, String description, Priority priority, Size size){
        Story story = createNewStoryWithoutAssignee(title, description, priority, size);
        return String.format(STORY_CREATED_SUCCESSFULLY, story.getTitle());
    }
    private Story createNewStoryWithoutAssignee(String title, String description, Priority priority, Size size){
        return getTaskManagerRepository().createStoryWithoutAssignee(title, description, priority, size);
    }
}
