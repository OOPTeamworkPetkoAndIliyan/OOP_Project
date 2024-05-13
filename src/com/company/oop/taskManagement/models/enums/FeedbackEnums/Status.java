package com.company.oop.taskManagement.models.enums.FeedbackEnums;

public enum Status {
    NEW,
    UNSCHEDULED,
    SCHEDULED,
    DONE;

    @Override
    public String toString() {
        switch (this) {
            case NEW:
                return "New";
            case UNSCHEDULED:
                return "Unscheduled";
            case SCHEDULED:
                return "Scheduled";
            case DONE:
                return "Done";
            default:
                return "";
        }
    }
}
