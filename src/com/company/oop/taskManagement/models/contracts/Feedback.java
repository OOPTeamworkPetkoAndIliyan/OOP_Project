package com.company.oop.taskManagement.models.contracts;

import com.company.oop.taskManagement.models.enums.FeedbackEnums.FeedbackStatus;

public interface Feedback extends Identifiable, Task{
    int getRating();
    void changeRating(int rating);
    void changeStatus(FeedbackStatus feedbackStatus);
    FeedbackStatus getStatus();
}
