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
    public void showDetails() {

    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public void changeRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void changeStatus(FeedbackStatus feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    @Override
    public FeedbackStatus getStatus() {
        return feedbackStatus;
    }

    @Override
    public void showActivity() {

    }
}
