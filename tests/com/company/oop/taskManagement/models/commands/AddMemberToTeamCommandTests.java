package com.company.oop.taskManagement.models.commands;

import com.company.oop.taskManagement.commands.AddBoardToTeamCommand;
import com.company.oop.taskManagement.commands.AddMemberToTeamCommand;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddMemberToTeamCommandTests {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private Command command;
    private TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void before() {
        this.taskManagerRepository = new TaskManagerRepositoryImpl();
        this.command = new AddMemberToTeamCommand(taskManagerRepository);

    }

    @Test
    public void execute_Should_AddMemberToTeam_When_ValidInput() {
        Member member = taskManagerRepository.createMember(CreateBaseConstants.NAME_MEMBER_VALID_LENGTH);
        Team team = taskManagerRepository.createTeam(CreateBaseConstants.NAME_TEAM_VALID_LENGTH);
        List<String> params = List.of(member.getName(), team.getName());
        command.execute(params);
        Assertions.assertEquals(1, taskManagerRepository.getTeam().size());
    }
}
