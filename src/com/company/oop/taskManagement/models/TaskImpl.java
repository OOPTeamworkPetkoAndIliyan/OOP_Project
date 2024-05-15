package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Comment;
import com.company.oop.taskManagement.models.contracts.Member;
import com.company.oop.taskManagement.models.contracts.Task;
import com.company.oop.taskManagement.models.enums.BugEnums.Status;
import com.company.oop.taskManagement.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskImpl implements Task {
    public static final int TASK_TITLE_MIN_LENGTH = 10;
    public static final int TASK_TITLE_MAX_LENGTH = 100;
    public static final String TASK_TITLE_ERR_MESSAGE = "Task title must be between %d and %d".formatted(
            TASK_TITLE_MIN_LENGTH, TASK_TITLE_MAX_LENGTH
    );
    public static final int TASK_DESCRIPTION_MIN_LENGTH = 10;
    public static final int TASK_DESCRIPTION_MAX_LENGTH = 500;
    public static final String TASK_DESCRIPTION_ERR_MESSAGE = "Task description must be between %d and %d".formatted(
            TASK_DESCRIPTION_MIN_LENGTH, TASK_DESCRIPTION_MAX_LENGTH
    );
    private int id;
    private String title;
    private String description;
    private final List<Comment> comments = new ArrayList<>();
    private final List<EventLog> history = new ArrayList<>();

    protected TaskImpl( int id, String title, String description) {
        this.id = id;
        setTitle(title);
        setDescription(description);
    }


    private void setTitle(String title) {
        ValidationHelpers.validateIntRange(title.length(),
                TASK_TITLE_MIN_LENGTH,
                TASK_TITLE_MAX_LENGTH,
                TASK_TITLE_ERR_MESSAGE);
        this.title = title;
    }

    private void setDescription(String description) {
        ValidationHelpers.validateIntRange(description.length(),
                TASK_DESCRIPTION_MIN_LENGTH,
                TASK_DESCRIPTION_MAX_LENGTH,
                TASK_DESCRIPTION_ERR_MESSAGE);
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public List<EventLog> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public abstract void advanceStatus();

    @Override
    public abstract void revertStatus();

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public abstract void showDetails();
}
 /*за репозиторито
    List<Task>tasks = new ArrayList<>(tasks);
    List<Bug>bugs = new ArrayList<>(bugs);
    List<Story>storys = new ArrayList<>(storys);
    List<FeedBack>feedbacks = new ArrayList<>(feedbacks);

    private void createBug(Параметрите за бъга){
        *тук имаш проверки и др глупости*
        bugs.add(bug) -> съхраняваш новият бъг в листа от бъгове
        tasks.add(tasks) -> съхраняваш новият бъг в листа от таскове
        return new BugImpl(Параметрите за бъга)
    }
  */