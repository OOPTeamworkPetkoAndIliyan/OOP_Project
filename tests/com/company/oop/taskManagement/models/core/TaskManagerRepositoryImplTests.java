package com.company.oop.taskManagement.models.core;

import com.company.oop.taskManagement.core.TaskManagerRepositoryImpl;
import com.company.oop.taskManagement.core.contracts.TaskManagerRepository;
import com.company.oop.taskManagement.models.Utils.CreateBaseConstants;
import com.company.oop.taskManagement.models.contracts.Bug;
import com.company.oop.taskManagement.models.contracts.Feedback;
import com.company.oop.taskManagement.models.contracts.Story;
import com.company.oop.taskManagement.models.enums.Priority;
import com.company.oop.taskManagement.models.enums.Severity;
import com.company.oop.taskManagement.models.enums.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerRepositoryImplTests {
    TaskManagerRepository taskManagerRepository;

    @BeforeEach
    public void beforeEach() {
        taskManagerRepository = new TaskManagerRepositoryImpl();
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
                ()-> Assertions.assertEquals(testBug.getTitle(), CreateBaseConstants.VALID_TITLE),
                ()-> Assertions.assertEquals(testBug.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                ()-> Assertions.assertEquals(testBug.getPriority(), Priority.HIGH),
                ()-> Assertions.assertEquals(testBug.getSeverity(), Severity.CRITICAL)
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
                ()-> Assertions.assertEquals(testStory.getTitle(), CreateBaseConstants.VALID_TITLE),
                ()-> Assertions.assertEquals(testStory.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                ()-> Assertions.assertEquals(testStory.getPriority(), Priority.HIGH),
                ()-> Assertions.assertEquals(testStory.getSize(), Size.LARGE)
        );
    }
    @Test
    public void createFeedBack_Should_ReturnFeedback_When_InputValid(){
        Feedback testfeedback = taskManagerRepository.createFeedback(
                CreateBaseConstants.VALID_TITLE,
                CreateBaseConstants.VALID_DESCRIPTION,
                CreateBaseConstants.FEEDBACK_RATING
        );
        Assertions.assertAll(
                ()-> Assertions.assertEquals(testfeedback.getTitle(), CreateBaseConstants.VALID_TITLE),
                ()-> Assertions.assertEquals(testfeedback.getDescription(), CreateBaseConstants.VALID_DESCRIPTION),
                ()-> Assertions.assertEquals(testfeedback.getRating(), CreateBaseConstants.FEEDBACK_RATING)
        );
    }
}
