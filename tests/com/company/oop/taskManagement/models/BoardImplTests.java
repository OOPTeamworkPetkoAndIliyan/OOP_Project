package com.company.oop.taskManagement.models;
import com.company.oop.taskManagement.models.contracts.Board;
import com.company.oop.taskManagement.models.contracts.Feedback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class BoardImplTests {
    public static final String INVALID_NAME = "c".repeat(11);
    public static final String VALID_NAME = "c".repeat(7);
    @Test
    public void constructor_Should_ThrowException_WhenNameIsInvalid(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BoardImpl(INVALID_NAME));
    }
    @Test
    public void constructor_Should_NotThrowException_WhenNameIsValid(){
        Assertions.assertDoesNotThrow(() -> new BoardImpl(VALID_NAME));
    }
    @Test
    public void addTask_Should_AddTaskToTheListOfTasks(){
        Board board = new BoardImpl(VALID_NAME);
        board.addTask(new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10));
        Assertions.assertEquals(1, board.getTasks().size());
    }
    @Test
    public void addTask_Should_ThrowExceptionWhenTheSameTaskExistInTheList(){
        Board board = new BoardImpl(VALID_NAME);
        Feedback feedback = new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10);
        board.addTask(feedback);
        Assertions.assertThrows(IllegalArgumentException.class, () -> board.addTask(feedback));
    }
    @Test
    public void removeTask_Should_RemoveTaskFromTheList(){
        Board board = new BoardImpl(VALID_NAME);
        Feedback feedback = new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10);
        board.addTask(feedback);
        board.removeTask(feedback);
        Assertions.assertTrue(board.getTasks().isEmpty());
    }
    @Test
    public void removeTask_Should_ThrowExceptionWhenTheTaskDoesNotExist(){
        Board board = new BoardImpl(VALID_NAME);
        Feedback feedback = new FeedbackImpl(2, "s".repeat(10), "s".repeat(15), 10);
        board.addTask(feedback);
        Assertions.assertThrows(IllegalArgumentException.class, () -> board.addTask(feedback));
    }
}
