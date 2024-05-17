package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class AssignTaskToMemberCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String INVALID_ID = "Invalid ID";
    public static final String TASK_ASSIGNED_TO_MEMBER_SUCCESSFULLY = "Task with ID: %d was assigned to member with name %s successfully";

    public AssignTaskToMemberCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int taskID = ParsingHelpers.tryParseInt(parameters.get(0), INVALID_ID);
        String memberName = parameters.get(1);
        return assignTaskToMember(taskID, memberName);
    }

    private String assignTaskToMember(int taskID, String memberName) {
        Task task = getTaskManagerRepository().getTaskByID(taskID);
        Member member = getTaskManagerRepository().getMemberByName(memberName);
        member.addTask(task);
        return String.format(TASK_ASSIGNED_TO_MEMBER_SUCCESSFULLY, task.getId(), member.getName());
    }
}
