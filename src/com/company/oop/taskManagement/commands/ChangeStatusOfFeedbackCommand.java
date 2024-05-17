package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.BugEnums.BugStatus;
import com.company.oop.taskManagement.models.enums.FeedbackEnums.FeedbackStatus;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ChangeStatusOfFeedbackCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String ID_ERROR_MESSAGE = "There is no such ID";
    public static final String THE_STATUS_OF_BUG_WAS_CHANGED_SUCCESSFULLY = "The status of Bug with ID: %d, was changed to %s";

    public ChangeStatusOfFeedbackCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int feedbackID = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR_MESSAGE);
        FeedbackStatus feedbackStatus = ParsingHelpers.tryParseEnum(parameters.get(1), FeedbackStatus.class);
        return changeStatusOfFeedback(feedbackID, feedbackStatus);
    }

    private String changeStatusOfFeedback(int feedbackID, FeedbackStatus feedbackStatus) {
        Feedback feedback = getTaskManagerRepository().getFeedbackByID(feedbackID);
        feedback.changeStatus(feedbackStatus);
        return String.format(THE_STATUS_OF_BUG_WAS_CHANGED_SUCCESSFULLY, feedback.getId(), feedback.getStatus());
    }
}
