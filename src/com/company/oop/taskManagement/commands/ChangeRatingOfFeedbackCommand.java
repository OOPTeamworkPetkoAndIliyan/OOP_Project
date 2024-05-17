package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;

import java.util.List;

public class ChangeRatingOfFeedbackCommand extends BaseCommand{
    public ChangeRatingOfFeedbackCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
    }
}
