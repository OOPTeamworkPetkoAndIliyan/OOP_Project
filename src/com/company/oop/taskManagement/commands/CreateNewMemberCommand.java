package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class CreateNewMemberCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public final static String MEMBER_CREATED_SUCCESSFULLY = "Member with name: %s was created successfully";
    public CreateNewMemberCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);

        return addNewMember(name);
    }
    private String addNewMember(String name){
        Member member = createNewMember(name);
        return String.format(MEMBER_CREATED_SUCCESSFULLY, member.getName());
    }
    private Member createNewMember(String name){
        return getTaskManagerRepository().createMember(name);
    }
}

