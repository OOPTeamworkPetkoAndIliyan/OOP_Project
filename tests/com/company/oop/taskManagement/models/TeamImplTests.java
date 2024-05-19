package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamImplTests {
    public static final String INVALID_NAME = "c".repeat(17);
    public static final String VALID_NAME = "c".repeat(7);
    @Test
    public void constructor_Should_ThrowException_WhenNameIsInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new TeamImpl(INVALID_NAME));
    }
    @Test
    public void constructor_Should_NotThrowException_WhenNameIsValid(){
        Assertions.assertDoesNotThrow(() -> new TeamImpl(VALID_NAME));
    }
    @Test
    public void addMember_Should_AddMemberToTheListOfMembers(){
        Team team = new TeamImpl(VALID_NAME);
        team.addMember(new MemberImpl("s".repeat(7)));
        Assertions.assertEquals(1, team.getMembers().size());
    }
    @Test
    public void addMember_Should_ThrowExceptionWhenTheSameMemberExistInTheList(){
        Team team = new TeamImpl(VALID_NAME);
        Member member = new MemberImpl("s".repeat(7));
        team.addMember(member);
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.addMember(member));
    }
    @Test
    public void removeMember_Should_RemoveMemberFromTheListOfMembers(){
        Team team = new TeamImpl(VALID_NAME);
        Member member = new MemberImpl("s".repeat(7));
        team.addMember(member);
        team.removeMember(member);
        Assertions.assertEquals(0, team.getMembers().size());
    }
    @Test
    public void removeMember_Should_ThrowExceptionWhenTheMemberDoesNotExist(){
        Team team = new TeamImpl(VALID_NAME);
        Member member = new MemberImpl("s".repeat(7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.removeMember(member));
    }
    @Test
    public void addBoard_Should_AddBoardToTheListOfBoards(){
        Team team = new TeamImpl(VALID_NAME);
        team.addBoard(new BoardImpl("s".repeat(7)));
        Assertions.assertEquals(1, team.getBoards().size());
    }
    @Test
    public void addBoard_Should_ThrowExceptionWhenTheSameBoardExistInTheList(){
        Team team = new TeamImpl(VALID_NAME);
        Board board = new BoardImpl("s".repeat(7));
        team.addBoard(board);
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.addBoard(board));
    }
    @Test
    public void removeBoard_Should_RemoveBoardFromTheListOfBoards(){
        Team team = new TeamImpl(VALID_NAME);
        Board board = new BoardImpl("s".repeat(7));
        team.addBoard(board);
        team.removeBoard(board);
        Assertions.assertEquals(0, team.getBoards().size());
    }
    @Test
    public void removeBoard_Should_ThrowExceptionWhenTheBoardDoesNotExist(){
        Team team = new TeamImpl(VALID_NAME);
        Board board = new BoardImpl("s".repeat(7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.removeBoard(board));
    }
}
