package com.company.oop.taskManagement.models.contracts;

import java.util.List;

public interface Team extends ShowActivity {
    List<Member> getMembers();
    String getName();
    void addMember(Member member);
    void removeMember(Member member);;
    void addBoard(Board board);
    void removeBoard(Board board);
}
