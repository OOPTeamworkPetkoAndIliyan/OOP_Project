package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.StoryEnums.Priority;
import com.company.oop.taskManagement.models.enums.StoryEnums.Size;
import com.company.oop.taskManagement.models.enums.StoryEnums.Status;

public class StoryImpl extends TaskImpl implements Story {
    private Status status;
    private Size size;
    private Priority priority;

    private Member assignee;

    protected StoryImpl(int id, String title, String description, Member assignee, Size size, Priority priority) {
        super( id,title, description);
        setAssignee(assignee);
        this.status = Status.NOT_DONE;
        this.size = size;
        this.priority = priority;
    }

    public Member getAssignee() {
        return assignee;
    }

    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    public Status getStatus() {
        return status;
    }

    public Size getSize() {
        return size;
    }

    public Priority getPriority() {
        return priority;
    }



    @Override
    public void changePriority() {

    }

    @Override
    public void changeSize() {

    }

    @Override
    public void advanceStatus() {
        
    }

    @Override
    public void revertStatus() {

    }

    @Override
    public void showDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Story Details:\n");
        sb.append("ID: ").append(getId()).append("\n");
        sb.append("Title: ").append(getTitle()).append("\n");
        sb.append("Description: ").append(getDescription()).append("\n");
        sb.append("Status: ").append(getStatus()).append("\n");
        sb.append("Assignee: ").append(getAssignee()).append("\n");
        sb.append("Priority: ").append(getPriority()).append("\n");
        sb.append("Size: ").append(getSize()).append("\n");
        System.out.println(sb);
    }
}
