package com.company.oop.taskManagement.models.enums.BugEnums;

public enum Severity {
    CRITICAL,
    MAJOR,
    MINOR;

    @Override
    public String toString() {
        switch (this) {
            case CRITICAL:
                return "Critical";
            case MAJOR:
                return "Major";
            case MINOR:
                return "Minor";
            default:
                return "";
        }
    }
}
