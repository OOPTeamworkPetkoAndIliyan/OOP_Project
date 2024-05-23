package com.company.oop.taskManagement.utils;

import com.company.oop.taskManagement.models.BugImpl;
import com.company.oop.taskManagement.models.CommentImpl;

import java.lang.reflect.Field;
import java.util.Scanner;

public class DisplayCommands {
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_RESET = "\u001B[0m";

    public static void displayAllCommands() {
        StringBuilder sb = new StringBuilder();
        appendColoredCommand(sb, "createnewmembercommand");
        sb.append("--").append("{member name}").append(System.lineSeparator());
        appendColoredCommand(sb, "createnewteamcommand");
        sb.append("--").append("{team name}").append(System.lineSeparator());
        appendColoredCommand(sb, "createnewboardcommand");
        sb.append("--").append("{board name}").append("--").append("{team name(optional)}")
                .append(System.lineSeparator());
        appendColoredCommand(sb, "createnewbugwithassigneecommand");
        sb.append("--").append("{title name}").append("--").append("{description}")
                .append("--").append("{priority}").append("--")
                .append("{severity}").append("--").append("{assignee}")
                .append("--").append("{board name(optional)}").append(System.lineSeparator());
        appendColoredCommand(sb, "createnewbugwithoutassigneecommand");
        sb.append("--").append("{title name}").append("--").append("{description}")
                .append("--").append("{priority}").append("--")
                .append("{severity}").append("--").append("{board name(optional)}").append(System.lineSeparator());
        appendColoredCommand(sb, "createnewstorywithassigneecommand");
        sb.append("--").append("{title name}").append("--").append("{description}")
                .append("--").append("{priority}").append("--")
                .append("{size}").append("--").append("{assignee}")
                .append("--").append("{board name(optional)}").append(System.lineSeparator());
        appendColoredCommand(sb, "createnewstorywithoutassigneecommand");
        sb.append("--").append("{title name}").append("--").append("{description}")
                .append("--").append("{priority}").append("--")
                .append("{size}").append("--")
                .append("{board name(optional)}").append(System.lineSeparator());
        appendColoredCommand(sb, "createnewfeedbackcommand");
        sb.append("--").append("{title name}").append("--").append("{description}")
                .append("--").append("{priority}").append("--")
                .append("{rating}").append("--")
                .append("{board name(optional)}").append(System.lineSeparator());
        appendColoredCommand(sb, "addmembertoteamcommand");
        sb.append("--").append("{member name}").append("--").append("{team name}")
                .append(System.lineSeparator());
        appendColoredCommand(sb, "addcommenttotaskcommand");
        sb.append("--").append("{author name}").append("--")
                .append("{content}").append("--")
                .append("{task ID}").append(System.lineSeparator());
        appendColoredCommand(sb, "addboardtoteamcommand");
        sb.append("--").append("{board name}").append("--")
                .append("{team name}").append(System.lineSeparator());
        appendColoredCommand(sb, "addstepstoreproducetobugcommand");
        sb.append("--").append("{steps to reproduce}").append("--")
                .append("{bug ID}").append(System.lineSeparator());
        appendColoredCommand(sb, "assigntasktomembercommand");
        sb.append("--").append("{task ID}").append("--")
                .append("{member name}").append(System.lineSeparator());
        appendColoredCommand(sb, "unassigntasktomembercommand");
        sb.append("--").append("{task ID}").append("--")
                .append("{member name}").append(System.lineSeparator());
        appendColoredCommand(sb, "changepriorityofbugcommand");
        sb.append("--").append("{bug ID}").append("--")
                .append("{priority}").append(System.lineSeparator());
        appendColoredCommand(sb, "changepriorityofstorycommand");
        sb.append("--").append("{story ID}").append("--")
                .append("{priority}").append(System.lineSeparator());
        appendColoredCommand(sb, "changeratingoffeedbackcommand");
        sb.append("--").append("{feedback ID}").append("--")
                .append("{rating}").append(System.lineSeparator());
        appendColoredCommand(sb, "changeseverityofbugcommand");
        sb.append("--").append("{bug ID}").append("--")
                .append("{severity}").append(System.lineSeparator());
        appendColoredCommand(sb, "changesizeofstorycommand");
        sb.append("--").append("{story ID}").append("--")
                .append("{size}").append(System.lineSeparator());
        appendColoredCommand(sb, "changestatusofbugcommand");
        sb.append("--").append("{bug ID}").append("--")
                .append("{status}").append(System.lineSeparator());
        appendColoredCommand(sb, "changestatusoffeedbackcommand");
        sb.append("--").append("{feedback ID}").append("--")
                .append("{status}").append(System.lineSeparator());
        appendColoredCommand(sb, "changestatusofstorycommand");
        sb.append("--").append("{story ID}").append("--")
                .append("{status}").append(System.lineSeparator());
        appendColoredCommand(sb, "showallboardscommand");
        sb.append(System.lineSeparator());
        appendColoredCommand(sb, "showallmembersscommand");
        sb.append(System.lineSeparator());
        appendColoredCommand(sb, "showallteamscommand");
        sb.append(System.lineSeparator());
        appendColoredCommand(sb, "showallteammemberscommandcommand");
        sb.append("--").append("{team name}").append(System.lineSeparator());
        appendColoredCommand(sb, "showmemberactivitycommand");
        sb.append("--").append("{member name}").append(System.lineSeparator());
        appendColoredCommand(sb, "showteamactivitycommand");
        sb.append("--").append("{team name}").append(System.lineSeparator());
        appendColoredCommand(sb, "showboardactivitycommand");
        sb.append("--").append("{board name}").append(System.lineSeparator());
        appendColoredCommand(sb, "showtaskactivitycommand");
        sb.append("--").append("{task name}").append(System.lineSeparator());
        appendColoredCommand(sb, "listalltaskssortedbytitlecommand");
        sb.append(System.lineSeparator());
        appendColoredCommand(sb, "listalltasksfilteredbytitlecommand");
        sb.append("--").append("{title}").append(System.lineSeparator());
        appendColoredCommand(sb, "listtaskswithassigneesortedbytitlecommand");
        sb.append(System.lineSeparator());
        appendColoredCommand(sb, "listtaskswithassigneefilteredbyassigneecommand");
        sb.append("--").append("{assignee name}").append(System.lineSeparator());
        appendColoredCommand(sb, "listoptionaltypeoftasksfilteredbyentitycommand");
        sb.append("--").append("{Bug/Story/Feedback}").append("--")
                        .append("{status/assignee}").append("--")
                        .append("{status/assignee(optional)}").append(System.lineSeparator());

        System.out.println(sb);
    }

    private static void appendColoredCommand(StringBuilder sb, String command) {
        sb.append(ANSI_GREEN).append(command).append(ANSI_RESET);
    }
}
