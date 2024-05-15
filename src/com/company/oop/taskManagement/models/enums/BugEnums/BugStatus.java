package com.company.oop.taskManagement.models.enums.BugEnums;

public enum BugStatus {
    ACTIVE,
    DONE;

    @Override
    public String toString() {
        switch (this) {
            case ACTIVE:
                return "Active";
            case DONE:
                return "Done";
            default:
                return "";
        }
    }
}
