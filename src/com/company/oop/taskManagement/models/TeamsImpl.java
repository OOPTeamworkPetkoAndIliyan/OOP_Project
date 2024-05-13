package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class TeamsImpl implements Team {

    public static final int MIN_NAME_LENGTH = 5;
    public static final int MAX_NAME_LENGTH = 15;
    public static final String NAME_ERR_MESSAGE =
            "Name should be between %d and %d length.".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private String name;
    private final List<Member> members = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();

    public TeamsImpl(String name) {
        setName(name);
    }

    private void setName(String name) {
        ValidationHelpers.validateIntRange(name.length(),
                MIN_NAME_LENGTH,
                MAX_NAME_LENGTH,
                NAME_ERR_MESSAGE);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public void showActivity() {

    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public void removeMember(Member member) {
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
