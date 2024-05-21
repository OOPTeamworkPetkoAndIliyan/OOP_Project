package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.contracts.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberImplTests {
    public static final String INVALID_NAME_OVER = "c".repeat(17);
    public static final String INVALID_NAME_BELOW = "c".repeat(3);
    public static final String VALID_NAME = "c".repeat(7);
    @Test
    public void constructor_Should_ThrowException_WhenNameIsLonger(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MemberImpl(INVALID_NAME_OVER));
    }
    @Test
    public void constructor_Should_ThrowException_WhenNameIsShorter(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MemberImpl(INVALID_NAME_BELOW));
    }
    @Test
    public void constructor_Should_NotThrowException_WhenNameIsValid(){
        Assertions.assertDoesNotThrow(() -> new MemberImpl(VALID_NAME));
    }
    @Test
    public void addTask_Should_AddTaskToTheListOfTasks(){
        Member member = new MemberImpl(VALID_NAME);
        member.addTask(new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10));
        Assertions.assertEquals(1, member.getTasks().size());
    }
    @Test
    public void addTask_Should_ThrowExceptionWhenTheSameTaskExistInTheList(){
        Member member = new MemberImpl(VALID_NAME);
        Feedback feedback = new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10);
        member.addTask(feedback);
        Assertions.assertThrows(IllegalArgumentException.class, () -> member.addTask(feedback));
    }
    @Test
    public void removeTask_Should_RemoveTaskFromTheList(){
        Member member = new MemberImpl(VALID_NAME);
        Feedback feedback = new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10);
        member.addTask(feedback);
        member.removeTask(feedback);
        Assertions.assertTrue(member.getTasks().isEmpty());
    }
    @Test
    public void removeTask_Should_ThrowExceptionWhenTheTaskDoesNotExist(){
        Member member = new MemberImpl(VALID_NAME);
        Feedback feedback = new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10);
        member.addTask(feedback);
        Assertions.assertThrows(IllegalArgumentException.class, () -> member.addTask(feedback));
    }
}
