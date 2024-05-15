package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements Team {

    public static final int TEAM_MIN_NAME_LENGTH = 5;
    public static final int TEAM_MAX_NAME_LENGTH = 15;
    public static final java.lang.String TEAM_NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(TEAM_MIN_NAME_LENGTH, TEAM_MAX_NAME_LENGTH);
    private java.lang.String name;
    private final List<String> members = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();

    public TeamImpl(java.lang.String name) {
        setName(name);
    }

    private void setName(java.lang.String name) {
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

    public List<String> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public void showActivity() {
    // foreach(Member member : this.members){
        //
        // }
    }

    @Override
    public void addMember(String member) {
        //дали мембъра съществува
        //addMember 0 0
        //addMember 0 levski
        //addMember -u Ilian Karagyozov -t levski
        members.add(member);
    }

    @Override
    public void removeMember(String member) {
        members.remove(member);

    }

    @Override
    public void addBoard(Board board) {
        boards.add(board);
    }

    @Override
    public void removeBoard(Board board) {
        boards.remove(board);
    }
}
