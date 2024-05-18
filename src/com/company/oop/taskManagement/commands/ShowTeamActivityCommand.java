package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ShowTeamActivityCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String END_MESSAGE = "--- All activities ---";
    public ShowTeamActivityCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = parameters.get(0);
        return showTeamActivity(teamName);
    }

    private String showTeamActivity(String teamName) {
        Team team = getTaskManagerRepository().getTeamByName(teamName);
        System.out.println(team.showActivity());
        return END_MESSAGE;
    }
}
