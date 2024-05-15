package com.company.oop.taskManagement.core.contracts;

import com.company.oop.taskManagement.commands.contracts.Command;

public interface TaskManagerCommandFactory {
    Command createCommandFromCommandName(String commandTypeAsString, TaskManagerRepository taskManagerRepository);
}
