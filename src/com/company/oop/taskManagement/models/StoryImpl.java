package com.company.oop.taskManagement.models;


import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.models.enums.StoryEnums.StoryStatus;

public class StoryImpl extends TaskImpl implements Story {
    private StoryStatus storyStatus;
    private Size size;
    private Priority priority;

    private Member assignee;

    public StoryImpl(int id, String title, String description, Priority priority, Size size) {
        super( id,title, description);
        setAssignee(assignee);
        this.storyStatus = StoryStatus.NOT_DONE;
        this.size = size;
        this.priority = priority;
    }
    public Member getAssignee() {
        return assignee;
    }

    public StoryStatus getStatus() {
        return storyStatus;
    }

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
        this.priority = priority;
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
