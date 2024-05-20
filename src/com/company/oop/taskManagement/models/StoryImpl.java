package com.company.oop.taskManagement.models;


import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.models.enums.Status;

import java.util.Arrays;

public class StoryImpl extends TaskImpl implements Story {
    Status[] STORY_POSSIBLE_STATUS = new Status[]{Status.NOT_DONE, Status.IN_PROGRESS, Status.DONE};
    private Priority priority;
    private Size size;
    private Status storyStatus;
    private Member assignee;

    public StoryImpl(int id, String title, String description, Priority priority, Size size) {
        super( id,title, description);
        setAssignee(assignee);
        this.storyStatus = Status.NOT_DONE;
        this.size = size;
        this.priority = priority;
    }
    @Override
    public Member getAssignee() {
        return assignee;
    }
    @Override
    public Status getStatus() {
        return storyStatus;
    }

    @Override
    public void changeStatus(Status status) {
        String previousStatus = this.storyStatus.toString();
        if (Arrays.stream(STORY_POSSIBLE_STATUS).noneMatch(s -> s == status)) {
            throw new IllegalArgumentException("Not a valid status for story");
        }
        this.storyStatus = status;
        String presentStatus = this.storyStatus.toString();
        getHistory().add(new EventLog(String.format("The status of item with ID: %d switched from %s to %s",
                getId(), previousStatus, presentStatus)));
    }

    @Override
    public Size getSize() {
        return size;
    }
    @Override
    public Priority getPriority() {
        return priority;
    }


    @Override
    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    @Override
    public void changePriority(Priority priority) {
        String previousPriority = this.priority.toString();
        this.priority = priority;
        String presentPriority = this.priority.toString();
        getHistory().add(new EventLog(String.format("The priority of item with ID: %d switched from %s to %s",
                getId(), previousPriority, presentPriority)));
    }

    @Override
    public void changeSize(Size size) {
        String previousSize = this.size.toString();
        this.size = size;
        String presentSize = this.size.toString();
        getHistory().add(new EventLog(String.format("The size of item with ID: %d switched from %s to %s",
                getId(), previousSize, presentSize)));
    }


    @Override
    public String showDetails(){
        StringBuilder str = new StringBuilder(String.format("%s", super.showDetails()));
        str.append(String.format("Priority: %s", getPriority())).append(System.lineSeparator());
        str.append(String.format("Size: %s", getSize())).append(System.lineSeparator());
        str.append(String.format("Status: %s", getStatus())).append(System.lineSeparator());
        if (getAssignee() != null){
            str.append(String.format("Assignee: %s", getAssignee().getName())).append(System.lineSeparator());
        }
        return str.toString();
    }
}
