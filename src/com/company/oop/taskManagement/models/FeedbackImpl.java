package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.enums.FeedbackEnums.Status;


public class FeedbackImpl extends TaskImpl implements Feedback {
    private int rating;
    private Status status;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(id, title, description);
        this.rating = rating;
        this.status = Status.NEW;
    }

    @Override
    public void advanceStatus() {

    }

    @Override
    public void revertStatus() {

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
