package com.company.oop.taskManagement.models.enums;

public enum Status {
    ACTIVE,
    DONE,
    NOT_DONE,
    IN_PROGRESS,
    NEW,
    UNSCHEDULED,
    SCHEDULED;


//    @Override
//    public String toString() {
//        switch (this) {
//            case ACTIVE:
//                return "Active";
//            case DONE:
//                return "Done";
//            default:
//                return "";
//        }
//    }

    @Override
    public String toString() {
        switch (this){
            case ACTIVE:
                return "Active";
            case DONE:
                return "Done";
            case IN_PROGRESS:
                return "In progress";
            case NOT_DONE:
                return "Not done";
            case NEW:
                return "New";
            case SCHEDULED:
                return "Scheduled";
            case UNSCHEDULED:
                return "Unscheduled";
            default:
                return "";
        }

    }
}
