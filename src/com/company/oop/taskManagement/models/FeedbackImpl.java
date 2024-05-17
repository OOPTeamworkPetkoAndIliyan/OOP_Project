package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.FeedbackEnums.FeedbackStatus;


public class FeedbackImpl extends TaskImpl implements Feedback {
    private int rating;
    private FeedbackStatus status;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(id, title, description);
        this.rating = rating;
        this.status = FeedbackStatus.NEW;
    }


    @Override
    public void showDetails() {

    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public void changeRating() {

    }
}
