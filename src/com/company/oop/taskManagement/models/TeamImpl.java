package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements Team {

    public static final int TEAM_MIN_NAME_LENGTH = 5;
    public static final int TEAM_MAX_NAME_LENGTH = 15;
    public static final java.lang.String TEAM_NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(TEAM_MIN_NAME_LENGTH, TEAM_MAX_NAME_LENGTH);
    private String name;
    private final List<Member> members = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();
    private final List<EventLog> history = new ArrayList<>();

    public TeamImpl(String name) {
        setName(name);
    }

    private void setName(String name) {
        ValidationHelpers.validateIntRange(name.length(),
                TEAM_MIN_NAME_LENGTH,
                TEAM_MAX_NAME_LENGTH,
                TEAM_NAME_ERR_MESSAGE);
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public String showActivity() {
        StringBuilder stringBuilder = new StringBuilder("Team's activity: ");
        stringBuilder.append(System.lineSeparator());
        for (EventLog eventLog : history) {
            stringBuilder.append(eventLog.viewInfo()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public void addMember(Member member) {
        for (Member member1 : members) {
            if (member1.getName().equals(member.getName())){
                throw new IllegalArgumentException(String.format
                        ("There is already existing member with name: %s in this team.",member.getName()));
            }
        }
        members.add(member);
        history.add(new EventLog(String.format("Member with name %s was added to the team", member.getName())));
    }

    @Override
    public void removeMember(Member member) {
        if (!members.contains(member)){
            throw new IllegalArgumentException(String.format
                    ("There is not existing member with name: %s in this team.", member.getName()));
        }
        members.remove(member);
        history.add(new EventLog(String.format("Member with name %s was removed from the team", member.getName())));
    }

    @Override
    public void addBoard(Board board) {
        for (Board board1 : boards) {
            if (board.getName().equals(board1.getName())){
                throw new IllegalArgumentException(String.format("There is already a board with name: %s in the team", board.getName()));
            }
        }
        boards.add(board);
        history.add(new EventLog(String.format("Board with name %s was added to the team", board.getName())));
    }

    @Override
    public void removeBoard(Board board) {
        if (!boards.contains(board)){
            throw new IllegalArgumentException(String.format("There is no board with name %s to be removed", board.getName()));
        }
        boards.remove(board);
        history.add(new EventLog(String.format("Board with name %s was removed from the team", board.getName())));
    }
}
