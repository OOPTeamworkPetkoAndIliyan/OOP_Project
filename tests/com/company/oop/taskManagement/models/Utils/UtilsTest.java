package com.company.oop.taskManagement.models.Utils;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {
    public static String getString(int length) {
        return "x".repeat(length);
    }
    public static List<String> getList(int wantedSize) {
        return Arrays.asList(new String[wantedSize]);
    }
}
