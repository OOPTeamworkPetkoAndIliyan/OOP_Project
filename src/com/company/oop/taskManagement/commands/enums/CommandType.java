package com.company.oop.taskManagement.commands.enums;

public enum CommandType {
    CREATENEWBUGWITHOUTASSIGNEECOMMAND,
    CREATENEWBUGWITHASSIGNEECOMMAND,
    CREATENEWMEMBERCOMMAND,
    CREATENEWTEAMCOMMAND,
    CREATENEWSTORYWITHOUTASSIGNEECOMMAND,
    CREATENEWSTORYWITHASSIGNEECOMMAND,
    CREATENEWFEEDBACKCOMMAND,
    CREATENEWBOARDCOMMAND,
    SHOWALLMEMBERSCOMMAND,
    ADDMEMBERTOTEAMCOMMAND,
    SHOWALLTEAMCOMMAND,
    SHOWALLBOARDSCOMMAND,
    SHOWALLTEAMMEMBERSCOMMAND,
    ADDBOARDTOTEAMCOMMAND,
    CHANGEPRIORITYOFBUGCOMMAND,
    CHANGESEVERITYOFBUGCOMMAND,
    CHANGESTATUSOFBUGCOMMAND,
    CHANGEPRIORITYOFSTORYCOMMAND,
    CHANGESIZEOFSTORYCOMMAND,
    CHANGESTATUSOFSTORYCOMMAND,
    CHANGERATINGOFFEEDBACKCOMMAND,
    CHANGESTATUSOFFEEDBACKCOMMAND,
    ASSIGNTASKTOMEMBERCOMMAND,
    UNASSIGNTASKTOMEMBERCOMMAND;

}
