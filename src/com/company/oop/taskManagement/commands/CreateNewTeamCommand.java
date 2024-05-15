package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewTeamCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public final static String TEAM_CREATED_SUCCESSFULLY = "Team with name:(%s) was created successfully";
    public CreateNewTeamCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.getFirst();

        return addNewTeam(name);
    }
    private String addNewTeam(String name){
        Team team = createNewTeam(name);
        return String.format(TEAM_CREATED_SUCCESSFULLY, team.getName());
    }
    private Team createNewTeam(String name){
        return getTaskManagerRepository().createTeam(name);
    }
}
