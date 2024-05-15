package com.company.oop.taskManagement.core;

import com.company.oop.taskManagement.commands.CreateNewBugWithAssigneeCommand;
import com.company.oop.taskManagement.commands.CreateNewBugWithoutAssigneeCommand;
import com.company.oop.taskManagement.commands.CreateNewMemberCommand;
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
            default:
                throw new IllegalArgumentException();
        }
    }
}
