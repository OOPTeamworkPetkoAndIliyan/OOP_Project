package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ListAllTasksFilteredByTitleCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public ListAllTasksFilteredByTitleCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = parameters.get(0);
        return listAllTasksFilteredByTitle(title);
    }

    private String listAllTasksFilteredByTitle(String title) {
        List<Task> tasks = getTaskManagerRepository().getTasks().stream().filter(task -> task.getTitle().contains(title)).toList();
        StringBuilder str = new StringBuilder("All tasks filtered by title: ");
        str.append(System.lineSeparator());
        for (Task task : tasks) {
            str.append(task.showDetails()).append(System.lineSeparator());
        }
        return str.toString();
    }
}
