package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.enums.Status;

import java.util.Arrays;


public class FeedbackImpl extends TaskImpl implements Feedback {
    Status[] STORY_POSSIBLE_STATUS = new Status[]{Status.NEW, Status.SCHEDULED, Status.UNSCHEDULED, Status.DONE};
    private int rating;
    private Status feedbackStatus;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(id, title, description);
        this.rating = rating;
        this.feedbackStatus = Status.NEW;
    }
    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public void changeRating(int rating) {
        int previousRating = this.rating;
        this.rating = rating;
        int presentRating = this.rating;
        getHistory().add(new EventLog(String.format("The rating of item with ID: %d switched from %d to %d",
                getId(), previousRating, presentRating)));
    }

    @Override
    public void changeStatus(Status status) {
        String previousStatus = this.feedbackStatus.toString();
        if (Arrays.stream(STORY_POSSIBLE_STATUS).noneMatch(s -> s == status)) {
            throw new IllegalArgumentException("Not a valid status for feedback");
        }
        this.feedbackStatus = status;
        String presentStatus = this.feedbackStatus.toString();
        getHistory().add(new EventLog(String.format("The status of item with ID: %d switched from %s to %s",
                getId(), previousStatus, presentStatus)));
    }

    @Override
    public Status getStatus() {
        return feedbackStatus;
    }

    @Override
    public Member getAssignee() {
        return null;
    }

    @Override
    public String showDetails(){
        StringBuilder str = new StringBuilder(String.format("%s", super.showDetails()));
        str.append(String.format("Rating: %d", getRating())).append(System.lineSeparator());
        str.append(String.format("Status: %s", getStatus())).append(System.lineSeparator());
        return str.toString();
    }
}
