package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewStoryWithAssigneeCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    public final static String STORY_CREATED_SUCCESSFULLY = "Story with title: %s was created successfully";
    public final static String STORY_CREATED_SUCCESSFULLY_IN_BOARD = "Story with title: %s was created successfully in board with name %s";

    public CreateNewStoryWithAssigneeCommand(TaskManagerRepository taskManagerRepository) {
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
        String memberName = parameters.get(4);
        if (parameters.size() == EXPECTED_NUMBER_OF_ARGUMENTS + 1){
            String boardName = parameters.get(5);
            return addNewStoryInBoard(title, description, priority, size, memberName, boardName);
        }
        return addNewStory(title, description, priority, size, memberName);
    }

    private String addNewStoryInBoard(String title, String description, Priority priority, Size size, String memberName, String boardName) {
        Board board = getTaskManagerRepository().getBoardByName(boardName);
        Story story = createNewStory(title, description, priority, size, memberName);
        board.addTask(story);
        return String.format(STORY_CREATED_SUCCESSFULLY_IN_BOARD, story.getTitle(), board.getName());
    }

    private String addNewStory(String title, String description, Priority priority, Size size, String memberName){
        Story story = createNewStory(title, description, priority, size, memberName);
        return String.format(STORY_CREATED_SUCCESSFULLY, story.getTitle());
    }
    private Story createNewStory(String title, String description, Priority priority, Size size, String memberName){
        return getTaskManagerRepository().createStoryWithAssignee(title, description, priority, size, memberName);
    }
}
