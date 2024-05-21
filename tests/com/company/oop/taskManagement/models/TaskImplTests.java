package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Comment;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskImplTests {
    public static final String INVALID_TITLE_LENGTH_OVER = "c".repeat(101);
    public static final String INVALID_TITLE_LENGTH_BELOW = "c".repeat(9);
    public static final String VALID_TITLE_LENGTH = "c".repeat(50);
    public static final String INVALID_DESCRIPTION_LENGTH_OVER = "c".repeat(501);
    public static final String INVALID_DESCRIPTION_LENGTH_BELOW = "c".repeat(9);
    public static final String VALID_DESCRIPTION_LENGTH = "c".repeat(50);
    @Test
    public void setTitle_Should_ThrowException_WhenTitleIsLonger(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new FeedbackImpl(2, INVALID_TITLE_LENGTH_OVER, VALID_DESCRIPTION_LENGTH, 10));
    }
    @Test
    public void setTitle_Should_ThrowException_WhenTitleIsShorter(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new FeedbackImpl(2, INVALID_TITLE_LENGTH_BELOW, VALID_DESCRIPTION_LENGTH, 10));
    }
    @Test
    public void setTitle_Should_NotThrowException_WhenTitleIsValid(){
        Assertions.assertDoesNotThrow(() ->
                new FeedbackImpl(2, VALID_TITLE_LENGTH, VALID_DESCRIPTION_LENGTH, 10));
    }
    @Test
    public void setDescription_Should_ThrowException_WhenDescriptionIsLonger(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new FeedbackImpl(2, VALID_TITLE_LENGTH, INVALID_DESCRIPTION_LENGTH_OVER, 10));
    }
    @Test
    public void setDescription_Should_ThrowException_WhenDescriptionIsShorter(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new FeedbackImpl(2, VALID_TITLE_LENGTH, INVALID_DESCRIPTION_LENGTH_BELOW, 10));
    }
    @Test
    public void setDescription_Should_NotThrowException_WhenDescriptionIsValid(){
        Assertions.assertDoesNotThrow(() ->
                new FeedbackImpl(2, VALID_TITLE_LENGTH, VALID_DESCRIPTION_LENGTH, 10));
    }
    @Test
    public void addComment_Should_AddCommentToTheListOfTasks(){
        Task task = new FeedbackImpl(2, VALID_TITLE_LENGTH, VALID_DESCRIPTION_LENGTH, 10);
        Comment comment = new CommentImpl("Author", "Content");
        task.addComment(comment);
        Assertions.assertEquals(1, task.getComments().size());
    }
}
