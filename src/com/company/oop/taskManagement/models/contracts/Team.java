package com.company.oop.taskManagement.models.contracts;

public interface Team extends ShowActivity {
    void addMember(String member);
    void removeMember(String member);;
    void addBoard(Board board);
    void removeBoard(Board board);
}
