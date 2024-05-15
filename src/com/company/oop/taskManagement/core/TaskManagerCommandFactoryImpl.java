package com.company.oop.taskManagement.core;

import com.company.oop.taskManagement.commands.*;
import com.company.oop.taskManagement.commands.contracts.Command;
import com.company.oop.taskManagement.commands.enums.CommandType;
import com.company.oop.taskManagement.core.contracts.TaskManagerCommandFactory;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.utils.ParsingHelpers;

public class TaskManagerCommandFactoryImpl implements TaskManagerCommandFactory {

    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskManagerRepository taskManagerRepository) {
        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeAsString, CommandType.class);
        switch (commandType) {
            case CREATENEWBUGWITHOUTASSIGNEE:
                return new CreateNewBugWithoutAssigneeCommand(taskManagerRepository);
            case CREATENEWBUGWITHASSIGNEE:
                return new CreateNewBugWithAssigneeCommand(taskManagerRepository);
            case CREATENEWMEMBERCOMMAND:
                return new CreateNewMemberCommand(taskManagerRepository);
            case CREATENEWTEAMCOMMAND:
                return new CreateNewTeamCommand(taskManagerRepository);
            case CREATENEWSTORYWITHOUTASSIGNEE:
                return new CreateNewStoryWithoutAssignee(taskManagerRepository);
            default:
                throw new IllegalArgumentException();
        }
    }
}
