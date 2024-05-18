package com.company.oop.taskManagement.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHelpers {

    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d; received: %d.";
    private static final String INVALID_NUMBER_OF_ARGUMENTS_2 = "Invalid number of arguments. Expected: %d or %d; received: %d.";

    public static void validateIntRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateDecimalRange(double value, double min, double max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateArgumentsCount(List<String> list, int expectedNumberOfParameters) {
        if (list.size() != expectedNumberOfParameters) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedNumberOfParameters, list.size())
            );
        }
    }
    public static void validateArgumentsCountWithOptionalParam(List<String> list,
                                                               int expectedNumberOfParameters,
                                                               int expectedNumberOfParametersWithOptParam) {
        if ((list.size() != expectedNumberOfParameters) && list.size() != expectedNumberOfParametersWithOptParam) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_OF_ARGUMENTS_2, expectedNumberOfParameters,
                            expectedNumberOfParametersWithOptParam,
                            list.size())
            );
        }
    }
    public static void validatePattern(String value, String pattern, String message) {
        Pattern patternToMatch = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = patternToMatch.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(message);
        }
    }
}
