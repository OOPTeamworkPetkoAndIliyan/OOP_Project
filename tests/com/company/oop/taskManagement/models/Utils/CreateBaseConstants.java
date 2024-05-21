package com.company.oop.taskManagement.models.Utils;

public class CreateBaseConstants {
    public static final int TITLE_MIN_LEN = 9;
    public static final String NAME_MEMBER_VALID_LENGTH = UtilsTest.getString(TITLE_MIN_LEN + 1).replace("x", "m");
    public static final String NAME_TEAM_VALID_LENGTH = UtilsTest.getString(TITLE_MIN_LEN + 1).replace("x", "t");
    public static final String NAME_BOARD_VALID_LENGTH = UtilsTest.getString(TITLE_MIN_LEN + 1).replace("x","b");
    public static final int FEEDBACK_RATING = 5;
    public static final String VALID_TITLE = UtilsTest.getString(TITLE_MIN_LEN + 1);
    public static final String VALID_DESCRIPTION = UtilsTest.getString(TITLE_MIN_LEN + 1);
}
