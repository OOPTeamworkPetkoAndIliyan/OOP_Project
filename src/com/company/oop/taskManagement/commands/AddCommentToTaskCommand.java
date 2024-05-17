package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Comment;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class AddCommentToTaskCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    public static final String INVALID_ID = "Invalid ID";
    public static final String COMMENT_ADDED_TO_TASK_SUCCESSFULLY = "Comment added to task with ID: %d successfully.";

    public AddCommentToTaskCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String author = parameters.get(0);
        String content = parameters.get(1);
        int taskID = ParsingHelpers.tryParseInt(parameters.get(2), INVALID_ID);
        return addCommentToTask(author, content, taskID);
    }

    private String addCommentToTask(String author, String content, int taskID) {
        Comment comment = getTaskManagerRepository().createComment(author, content);
        Task task = getTaskManagerRepository().getTaskByID(taskID);
        task.addComment(comment);
        return String.format(COMMENT_ADDED_TO_TASK_SUCCESSFULLY, task.getId());
    }
}
