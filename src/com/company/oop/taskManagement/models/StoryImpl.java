package com.company.oop.taskManagement.models;


import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Size;
import com.company.oop.taskManagement.models.enums.StoryEnums.StoryStatus;

public class StoryImpl extends TaskImpl implements Story {
    private StoryStatus storyStatus;
    private Size size;
    private Priority priority;

    private String assignee;

    public StoryImpl(int id, String title, String description, Size size, Priority priority) {
        super( id,title, description);
        setAssignee(assignee);
        this.storyStatus = StoryStatus.NOT_DONE;
        this.size = size;
        this.priority = priority;
    }
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public StoryStatus getStatus() {
        return storyStatus;
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
