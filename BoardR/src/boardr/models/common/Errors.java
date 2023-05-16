package boardr.models.common;

public class Errors {
    public static final String NULL_TITLE_ERROR =
            "Title cannot be null.";
    public static final String BLANK_TITLE_ERROR =
            "Title cannot be blank.";
    public static final String TITLE_LENGTH_ERROR =
            "Title's length must be between %d symbols and %d symbols";
    public static final String DUE_DATE_ERROR =
            "Invalid due date; Due date cannot be in the past.";
    public static final String REVERT_STATUS_ERROR =
            "Status cannot be further reverted.";
    public static final String ADVANCE_STATUS_ERROR =
            "Status cannot be further advanced.";
    public static final String EMPTY_STRING_ERROR =
            "Description cannot be empty.";
    public static final String TERMINATION_COMMAND =
            "Exit";
    public static final String COMMAND_ERROR_INVALID_COMMAND =
            "Command cannot be null or empty.";
    public static final String EXISTING_ITEM_ERROR =
            "Item already exists.";
    public static final String FINDING_ITEM_ERROR =
            "Item does not exist.";
}
