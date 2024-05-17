package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class ShowMemberActivityCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String END_MESSAGE = "--- All activities ---";

    public ShowMemberActivityCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String memberName = parameters.get(0);
        return showMemberActivity(memberName);
    }

    private String showMemberActivity(String memberName) {
        Member member = getTaskManagerRepository().getMemberByName(memberName);
        System.out.print(member.showActivity());
        return END_MESSAGE;
    }
}
