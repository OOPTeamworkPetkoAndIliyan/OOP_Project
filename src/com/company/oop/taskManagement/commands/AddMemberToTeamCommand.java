package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class AddMemberToTeamCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public final static String MEMBER_ADDED_TO_TEAM_SUCCESSFULLY = "Member with name:(%s) was added to Team with name:(%s) successfully";

    protected AddMemberToTeamCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String memberName = parameters.get(0);
        String teamName = parameters.get(1);
        return addMemberToTeam(memberName, teamName);
    }
    private String addMemberToTeam(String memberName, String teamName){
        Member member = getTaskManagerRepository().getMemberByName(memberName);
        Team team = getTaskManagerRepository().getTeamByName(teamName);
        team.addMember(member);
        return String.format(MEMBER_ADDED_TO_TEAM_SUCCESSFULLY, member.getName(), team.getName());
    }
}
