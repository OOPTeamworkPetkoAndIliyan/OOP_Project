package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.FeedbackEnums.FeedbackStatus;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewFeedbackCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    public static final String INVALID_RATING_MESSAGE = "Invalid rating";
    public final static String FEEDBACK_CREATED_SUCCESSFULLY = "Feedback with title: %s was created successfully";
    public final static String FEEDBACK_CREATED_SUCCESSFULLY_IN_BOARD = "Feedback with title: %s was created successfully in board with name: %s";
    public CreateNewFeedbackCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCountWithOptionalParam(parameters,
                EXPECTED_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS + 1);
        String title = parameters.get(0);
        String description = parameters.get(1);
        int rating = ParsingHelpers.tryParseInt(parameters.get(2), INVALID_RATING_MESSAGE);
        if (parameters.size() == EXPECTED_NUMBER_OF_ARGUMENTS + 1){
            String boardName = parameters.get(3);
            return addNewFeedbackInBoard(title, description, rating, boardName);
        }
        return addNewFeedback(title, description, rating);
    }

    private String addNewFeedbackInBoard(String title, String description, int rating, String boardName) {
        Board board = getTaskManagerRepository().getBoardByName(boardName);
        Feedback feedback = createNewFeedback(title, description, rating);
        return String.format(FEEDBACK_CREATED_SUCCESSFULLY_IN_BOARD, feedback.getTitle(), board.getName());
    }

    private String addNewFeedback(String title, String description, int rating){
        Feedback feedback = createNewFeedback(title, description, rating);
        return String.format(FEEDBACK_CREATED_SUCCESSFULLY, feedback.getTitle());
    }
    private Feedback createNewFeedback(String title, String description,int rating){
        return getTaskManagerRepository().createFeedback(title, description, rating);
    }
}
