package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;

import static com.company.oop.dealership.utils.ValidationHelpers.validateIntRange;
import static java.lang.String.format;

public class CommentImpl implements Comment {

    private static final String COMMENT_SEPARATOR = "----------";

    public static final int CONTENT_LEN_MIN = 3;
    public static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    private String content;
    private final String author;

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public CommentImpl(String content, String author) {
        setContent(content);
        this.author = author;
    }

    public String toString() {
        return String.format("%s%n" +
                "%s%n" +
                "User: %s%n" +
                "%s%n",
                COMMENT_SEPARATOR,
                getContent(),
                getAuthor(),
                COMMENT_SEPARATOR);
    }

    private void setContent(String content) {
        validateIntRange(content.length(), CONTENT_LEN_MIN, CONTENT_LEN_MAX, CONTENT_LEN_ERR);
        this.content = content;
    }
}