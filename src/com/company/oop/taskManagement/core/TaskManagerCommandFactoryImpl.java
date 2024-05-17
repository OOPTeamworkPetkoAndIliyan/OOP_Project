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
            case CREATENEWSTORYWITHOUTASSIGNEECOMMAND:
                return new CreateNewStoryWithoutAssignee(taskManagerRepository);
            case CREATENEWSTORYWITHASSIGNEECOMMAND:
                return new CreateNewStoryWithAssigneeCommand(taskManagerRepository);
            case CREATENEWBOARDCOMMAND:
                return new CreateNewBoardCommand(taskManagerRepository);
            case CREATENEWFEEDBACKCOMMAND:
                return new CreateNewFeedbackCommand(taskManagerRepository);
            case SHOWALLMEMBERSCOMMAND:
                return new ShowAllMembersCommand(taskManagerRepository);
            case SHOWALLTEAMCOMMAND:
                return new ShowAllTeamsCommand(taskManagerRepository);
            case SHOWALLBOARDSCOMMAND:
                return new ShowAllBoardsCommand(taskManagerRepository);
            case SHOWALLTEAMMEMBERSCOMMAND:
                return new ShowAllTeamMembers(taskManagerRepository);
            case ADDMEMBERTOTEAMCOMMAND:
                return new AddMemberToTeamCommand(taskManagerRepository);
            case ADDBOARDTOTEAMCOMMAND:
                return new AddBoardToTeamCommand(taskManagerRepository);
            case CHANGEPRIORITYOFBUGCOMMAND:
                return new ChangePriorityOfBugCommand(taskManagerRepository);
            default:
                throw new IllegalArgumentException();
        }
    }
}
