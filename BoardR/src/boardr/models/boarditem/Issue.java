package boardr.models.boarditem;

import boardr.models.board.Board;
import boardr.models.common.Status;
import boardr.models.eventlog.Log;

import java.time.LocalDate;

import static boardr.models.common.Errors.*;

public class Issue extends BoardItem {
    private static final int MIN_DESCRIPTION_LENGTH = 5;
    private static final int MAX_DESCRIPTION_LENGTH = 60;
    private String description;

    public String getDescription() {
        return description;
    }
    private void setDescription(String description) {
        if (description == null)
            throw new IllegalArgumentException(NULL_DESCRIPTION_ERROR);
        if (description.isEmpty() || description.isBlank())
            throw new IllegalArgumentException(BLANK_DESCRIPTION_ERROR);
        if (description.length() < MIN_DESCRIPTION_LENGTH || description.length() > MAX_DESCRIPTION_LENGTH)
            throw new IllegalArgumentException(String.format(DESCRIPTION_LENGTH_ERROR, MIN_DESCRIPTION_LENGTH, MAX_DESCRIPTION_LENGTH));
        this.description = description;
    }
    public Issue(String title, String description, LocalDate dueDate) {
        setTitle(title);
        if (description == null)
            throw new IllegalArgumentException(NULL_DESCRIPTION_ERROR);
        if (description.isEmpty() || description.isBlank())
            throw new IllegalArgumentException(BLANK_DESCRIPTION_ERROR);
        if (description.length() < MIN_DESCRIPTION_LENGTH || description.length() > MAX_DESCRIPTION_LENGTH)
            throw new IllegalArgumentException(String.format(DESCRIPTION_LENGTH_ERROR, MIN_DESCRIPTION_LENGTH, MAX_DESCRIPTION_LENGTH));
        this.description = description;
        setDueDate(dueDate);
        status = Status.OPEN;
        Board.addItem(this);
        String desc = String.format("Item created: %s", getInfo());
        Log itemCreated = new Log(desc);
        addToHistory(itemCreated);
    }
    public Issue(String title, String description, String dueDate) {
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        status = Status.OPEN;
        Board.addItem(this);
        String desc = String.format("Item created: %s", getInfo());
        Log itemCreated = new Log(desc);
        addToHistory(itemCreated);
    }
    @Override
    public String getInfo() {
        String info = String.format("Issue \"%s\", %s [%s | %s]", title, description, status.label, dueDate);
        return info;
    }
}
