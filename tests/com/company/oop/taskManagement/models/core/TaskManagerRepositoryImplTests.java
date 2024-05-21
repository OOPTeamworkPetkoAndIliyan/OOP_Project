package com.company.oop.taskManagement.models.core;

import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.contracts.*;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerRepositoryImplTests {
    TaskManagerRepository taskManagerRepository;
    Member testMember;
    Board testBoard;
    Team testTeam;

    @BeforeEach
    public void beforeEach() {
        taskManagerRepository = new TaskManagerRepositoryImpl();
        testMember = taskManagerRepository.createMember(CreateBaseConstants.NAME_MEMBER_VALID_LENGTH);
        testBoard = taskManagerRepository.createBoard(CreateBaseConstants.NAME_BOARD_VALID_LENGTH);
        testTeam = taskManagerRepository.createTeam(CreateBaseConstants.NAME_TEAM_VALID_LENGTH);
    }

    @Test
    public void createBug_Should_ReturnBug_When_InputValid() {
        Bug testBug = taskManagerRepository.createBug(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                Priority.HIGH,
                Severity.CRITICAL
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(testBug.getTitle(), CreateBaseConstants.VALID_TITLE),
                () -> Assertions.assertEquals(testBug.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                () -> Assertions.assertEquals(testBug.getPriority(), Priority.HIGH),
                () -> Assertions.assertEquals(testBug.getSeverity(), Severity.CRITICAL)
        );
    }

    @Test
    public void createStory_Should_ReturnStory_When_InputValid() {
        Story testStory = taskManagerRepository.createStoryWithoutAssignee(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                Priority.HIGH,
                Size.LARGE
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(testStory.getTitle(), CreateBaseConstants.VALID_TITLE),
                () -> Assertions.assertEquals(testStory.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                () -> Assertions.assertEquals(testStory.getPriority(), Priority.HIGH),
                () -> Assertions.assertEquals(testStory.getSize(), Size.LARGE)
        );
    }

    @Test
    public void createFeedBack_Should_ReturnFeedback_When_InputValid() {
        Feedback testFeedback = taskManagerRepository.createFeedback(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                CreateBaseConstants.FEEDBACK_RATING
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(testFeedback.getTitle(), CreateBaseConstants.VALID_TITLE),
                () -> Assertions.assertEquals(testFeedback.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                () -> Assertions.assertEquals(testFeedback.getRating(), CreateBaseConstants.FEEDBACK_RATING)
        );
    }

    @Test
    public void createMember_Should_ReturnMember_When_InputValid() {
        Assertions.assertEquals(testMember.getName(), CreateBaseConstants.NAME_MEMBER_VALID_LENGTH);
    }
    @Test
    public void createBoard_Should_ReturnBoard_When_InputValid(){
        Assertions.assertEquals(testBoard.getName(), CreateBaseConstants.NAME_BOARD_VALID_LENGTH);
    }
    @Test
    public void createTeam_Should_ReturnTeam_When_InputValid(){
        Assertions.assertEquals(testTeam.getName(), CreateBaseConstants.NAME_TEAM_VALID_LENGTH);
    }

    @Test
    public void getMember_Should_ReturnValidMember_When_InputValid() {
        Assertions.assertNotNull(testMember);
        Assertions.assertEquals(testMember.getName(), CreateBaseConstants.NAME_MEMBER_VALID_LENGTH);
    }
    @Test
    public void getTeam_Should_ReturnValidTeam_When_InputValid(){
        Assertions.assertNotNull(testTeam);
        Assertions.assertEquals(CreateBaseConstants.NAME_TEAM_VALID_LENGTH,testTeam.getName());
    }

    @Test
    public void createBugWithAssignee_Should_ReturnBugWithAssignee_When_InputValid() {
        Bug testBug = taskManagerRepository.createBugWithAssignee(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                Priority.HIGH,
                Severity.CRITICAL,
                testMember.getName()
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(testBug.getTitle(), CreateBaseConstants.VALID_TITLE),
                () -> Assertions.assertEquals(testBug.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                () -> Assertions.assertEquals(testBug.getPriority(), Priority.HIGH),
                () -> Assertions.assertEquals(testBug.getSeverity(), Severity.CRITICAL),
                () -> Assertions.assertEquals(testBug.getAssignee().getName(), testMember.getName())
        );
    }
    @Test
    public void createStoryWithAssignee_Should_ReturnStoryWithAssignee_When_InputValid() {
        Story testStory = taskManagerRepository.createStoryWithAssignee(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                Priority.HIGH,
                Size.LARGE,
                testMember.getName()
        );
        Assertions.assertAll(
                () -> Assertions.assertEquals(testStory.getTitle(), CreateBaseConstants.VALID_TITLE),
                () -> Assertions.assertEquals(testStory.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                () -> Assertions.assertEquals(testStory.getPriority(), Priority.HIGH),
                () -> Assertions.assertEquals(testStory.getSize(), Size.LARGE),
                () -> Assertions.assertEquals(testStory.getAssignee().getName(), testMember.getName())
        );
    }
    @Test
    public void showAllTeamMembers_Should_ReturnAllTeamMembers_When_InputValid(){
        //String testTeam = taskManagerRepository.showAllTeamMembers(CreateBaseConstants.VALID_TITLE);
        testTeam.addMember(testMember);
        String expectedOutput = "Members for team tttttttttt:" + System.lineSeparator() +
                "mmmmmmmmmm"+ System.lineSeparator();
        String actualOutput = taskManagerRepository.showAllTeamMembers(testTeam.getName());
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void showAllMembers_Should_ReturnAllMembers_When_InputValid(){
        String expectedOutput = "Members: mmmmmmmmmm" + System.lineSeparator();
        String actualOutput = taskManagerRepository.showAllMembers();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void showAllTeams_Should_ReturnAllTeams_When_InputValid(){
        String expectedOutput = "Teams: tttttttttt" + System.lineSeparator();
        String actualOutput = taskManagerRepository.showAllTeams();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void showAllBoards_Should_ReturnAllBoards_When_InputValid(){
        String expectedOutput = "Boards: bbbbbbbbbb" + System.lineSeparator();
        String actualOutput = taskManagerRepository.showAllBoards();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
