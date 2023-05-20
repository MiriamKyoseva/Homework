package boardr.models.boarditem;


import boardr.models.eventlog.EventLog;
import boardr.models.eventlog.Log;

import java.time.LocalDate;

import static boardr.commands.common.CommandConstants.BOARD_ITEM_CREATED;
import static boardr.models.common.Errors.*;

public class Issue extends BoardItem {
    private static final int MIN_DESCRIPTION_LENGTH = 5;
    private static final int MAX_DESCRIPTION_LENGTH = 60;

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
        super(title, dueDate);
        setDescription(description);
        String desc = String.format(BOARD_ITEM_CREATED, getInfo());
        Log itemCreated = new Log(desc);
        addToHistory(itemCreated);
    }
    public Issue(String title, String description, String dueDate) {
        super(title, dueDate);
        setDescription(description);
        String desc = String.format(BOARD_ITEM_CREATED, getInfo());
        Log itemCreated = new Log(desc);
        addToHistory(itemCreated);
    }
    @Override
    public String getInfo() {
        String info = String.format("Issue \"%s\", %s [%s | %s]", title, description, status.label, dueDate);
        return info;
    }
    @Override
    public void displayLocalHistory() {
        for (Log kur : localEvents) {
            kur.viewInfo();
        }
    }
}
