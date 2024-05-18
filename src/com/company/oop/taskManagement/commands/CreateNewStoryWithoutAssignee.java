package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewStoryWithoutAssignee extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    public final static String STORY_CREATED_SUCCESSFULLY = "Story with ID: %d and title: %s was created successfully";
    public final static String STORY_CREATED_SUCCESSFULLY_IN_BOARD = "Story with ID: %d and title: %s was created successfully in board with name: %s";
    public CreateNewStoryWithoutAssignee(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCountWithOptionalParam(parameters,
                EXPECTED_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS + 1);
        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Size size = ParsingHelpers.tryParseEnum(parameters.get(3), Size.class);
        if (parameters.size() == EXPECTED_NUMBER_OF_ARGUMENTS + 1){
            String boardName = parameters.get(4);
            return addNewStoryInBoard(title, description, priority, size, boardName);
        }
        return addNewStory(title, description, priority, size);
    }

    private String addNewStoryInBoard(String title, String description, Priority priority, Size size, String boardName) {
        Board board = getTaskManagerRepository().getBoardByName(boardName);
        Story story = createNewStoryWithoutAssignee(title, description, priority, size);
        board.addTask(story);
        return String.format(STORY_CREATED_SUCCESSFULLY_IN_BOARD,story.getId(), story.getTitle(), board.getName());
    }

    private String addNewStory(String title, String description, Priority priority, Size size){
        Story story = createNewStoryWithoutAssignee(title, description, priority, size);
        return String.format(STORY_CREATED_SUCCESSFULLY,story.getId(), story.getTitle());
    }
    private Story createNewStoryWithoutAssignee(String title, String description, Priority priority, Size size){
        return getTaskManagerRepository().createStoryWithoutAssignee(title, description, priority, size);
    }
}
