package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangeRatingOfFeedbackCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_RATING_OF_FEEDBACK_WAS_CHANGED_SUCCESSFULLY = "The rating of Feedback with ID: %d, was changed to %d";
    public static final String INVALID_RATING = "Invalid rating";

    public ChangeRatingOfFeedbackCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int feedbackID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        int rating = ParsingHelpers.tryParseInt(parameters.get(1), INVALID_RATING);
        return changeRatingOfFeedback(feedbackID, rating);
    }

    private String changeRatingOfFeedback(int feedbackID, int rating) {
        Feedback feedback = getTaskManagerRepository().getFeedbackByID(feedbackID);
        feedback.changeRating(rating);
        return String.format(THE_RATING_OF_FEEDBACK_WAS_CHANGED_SUCCESSFULLY, feedback.getId(), feedback.getRating());
    }
}
