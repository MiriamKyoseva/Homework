package boardr.models.common;

public class Errors {
    public static final String INVALID_COMMAND =
            "Invalid command.";
    public static final String NULL_TITLE_ERROR =
            "Title cannot be null.";
    public static final String BLANK_TITLE_ERROR =
            "Title cannot be blank.";
    public static final String TITLE_LENGTH_ERROR =
            "Title's length must be between %d and %d symbols.";
    public static final String DUE_DATE_ERROR =
            "Invalid due date; Due date cannot be in the past.";
    public static final String REVERT_STATUS_ERROR =
            "Status cannot be further reverted.";
    public static final String ADVANCE_STATUS_ERROR =
            "Status cannot be further advanced.";
    public static final String EMPTY_STRING_ERROR =
            "Description cannot be empty.";
    public static final String EXISTING_ITEM_ERROR =
            "Item already exists.";
    public static final String EXISTING_ITEM_WITH_SAME_TITLE_ERROR =
            "Item with \"%s\" title already exists.";
    public static final String FINDING_ITEM_ERROR =
            "Item does not exist.";
    public static final String NEW_TITLE_ERROR =
            "The new title should not be the same as the current title.";
    public static final String NULL_ASSIGNEE_ERROR =
            "Assignee cannot be null.";
    public static final String BLANK_ASSIGNEE_ERROR =
            "Assignee cannot be blank.";
    public static final String ASSIGNEE_LENGTH_ERROR =
            "Assignee's length must be between %d and %d symbols.";
    public static final String NULL_DESCRIPTION_ERROR =
            "Description cannot be null.";
    public static final String BLANK_DESCRIPTION_ERROR =
            "Description cannot be blank.";
    public static final String DESCRIPTION_LENGTH_ERROR =
            "Description's length must be between %d and %d symbols.";
    public static final String SAME_DUE_DATE_ERROR =
            "New due date cannot be the same as the current one";
}
