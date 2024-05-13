package com.company.oop.taskManagement.models.contracts;

public interface Team extends ShowActivity {
    void addMember(Member member);
    void removeMember(Member member);;
    void addBoard(Board board);
    void removeBoard(Board board);
}
