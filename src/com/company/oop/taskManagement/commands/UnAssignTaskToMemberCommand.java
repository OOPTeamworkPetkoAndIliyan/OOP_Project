package com.company.oop.taskManagement.commands;

import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.utils.ParsingHelpers;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.List;

public class UnAssignTaskToMemberCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    public static final String INVALID_ID = "Invalid ID";
    public static final String TASK_UNASSIGNED_TO_MEMBER_SUCCESSFULLY = "Task with ID: %d was unassigned to member with name %s successfully";

    public UnAssignTaskToMemberCommand(TaskManagerRepository taskManagerRepository) {
        super(taskManagerRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int taskID = ParsingHelpers.tryParseInt(parameters.get(0), INVALID_ID);
        String memberName = parameters.get(1);
        return unAssignTaskToMember(taskID, memberName);
    }

    private String unAssignTaskToMember(int taskID, String memberName) {
        Task task = getTaskManagerRepository().getTaskByID(taskID);
        Member member = getTaskManagerRepository().getMemberByName(memberName);
        member.removeTask(task);
        return String.format(TASK_UNASSIGNED_TO_MEMBER_SUCCESSFULLY, task.getId(), member.getName());
    }
}