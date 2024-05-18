package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.FeedbackEnums.FeedbackStatus;


public class FeedbackImpl extends TaskImpl implements Feedback {
    private int rating;
    private FeedbackStatus feedbackStatus;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(id, title, description);
        this.rating = rating;
        this.feedbackStatus = FeedbackStatus.NEW;
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
    public void changeStatus(FeedbackStatus feedbackStatus) {
        String previousStatus = this.feedbackStatus.toString();
        this.feedbackStatus = feedbackStatus;
        String presentStatus = this.feedbackStatus.toString();
        getHistory().add(new EventLog(String.format("The status of item with ID: %d switched from %s to %s",
                getId(), previousStatus, presentStatus)));
    }

    @Override
    public FeedbackStatus getStatus() {
        return feedbackStatus;
    }
}
