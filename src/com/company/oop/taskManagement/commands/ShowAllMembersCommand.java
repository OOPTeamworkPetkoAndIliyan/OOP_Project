package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ShowAllMembersCommand extends BaseCommand {


    public ShowAllMembersCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        if (!parameters.isEmpty()){
            throw new IllegalArgumentException("There should be non parameters");
        }
        return getTaskManagerRepository().showAllMembers();
    }

}
