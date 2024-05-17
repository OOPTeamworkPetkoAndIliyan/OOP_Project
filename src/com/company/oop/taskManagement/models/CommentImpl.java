package com.company.oop.taskManagement.models;

import com.company.oop.taskManagement.models.contracts.Comment;

public class CommentImpl implements Comment {
    private String author;
    private String content;

    public CommentImpl(String author, String content) {
        this.author = author;
        this.content = content;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }
    @Override
    public String toString(){
        return """
        ----------
        %s
        User: %s
        ----------""".formatted(content,author);
    }
}
