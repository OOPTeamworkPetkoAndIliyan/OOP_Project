package com.company.oop.taskManagement.models.contracts;

public interface Team extends ShowActivity {
    String getName();
    void addMember(Member member);
    void removeMember(String member);;
    void addBoard(Board board);
    void removeBoard(Board board);
}
