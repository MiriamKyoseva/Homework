package boardr.models.boarditem;

import boardr.models.board.Board;
import boardr.models.common.Status;
import boardr.models.eventlog.EventLog;
import boardr.models.eventlog.Log;

import java.time.LocalDate;
import java.util.ArrayList;

import static boardr.models.common.Errors.*;

public class BoardItem {
    private static final int MIN_TITLE_LENGTH = 5;
    private static final int MAX_TITLE_LENGTH = 30;
    protected String title;
    protected LocalDate dueDate;
    protected Status status;
    protected final ArrayList<Log> localEvents = new ArrayList<>();

    public BoardItem (String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        status = Status.OPEN;
        Board.addItem(this);
        String description = String.format("Item created: %s", getInfo());
        Log itemCreated = new Log(description);
        addToHistory(itemCreated);
    }
    public BoardItem (String title, String dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        status = Status.OPEN;
        Board.addItem(this);
        String description = String.format("Item created: %s", getInfo());
        Log itemCreated = new Log(description);
        addToHistory(itemCreated);
    }
    public String getTitle(){
        return title;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public Status getStatus(){
        return status;
    }

    public void setTitle(String newTitle){
        if (newTitle == null)
            throw new IllegalArgumentException(NULL_TITLE_ERROR);
        if (newTitle.isEmpty() || newTitle.isBlank())
            throw new IllegalArgumentException(BLANK_TITLE_ERROR);
        if (newTitle.length() < MIN_TITLE_LENGTH || newTitle.length() > MAX_TITLE_LENGTH)
            throw new IllegalArgumentException(String.format(TITLE_LENGTH_ERROR, MIN_TITLE_LENGTH, MAX_TITLE_LENGTH));
        String previousTitle = this.title;
        this.title = newTitle;
        if (previousTitle != null) {
            String description = String.format("Title changed from \"%s\" to \"%s\"", previousTitle, newTitle);
            Log itemTitleChange = new Log(description);
            addToHistory(itemTitleChange);
        }
    }

    public void setDueDate(LocalDate newDueDate){
        if (newDueDate.isBefore(LocalDate.now())) throw new IllegalArgumentException(DUE_DATE_ERROR);
        LocalDate previousDueDate = this.dueDate;
        this.dueDate = newDueDate;
        if (previousDueDate != null) {
            String description = String.format("Due Date changed from %s to %s", previousDueDate, newDueDate);
            Log itemDueDateChange = new Log(description);
            addToHistory(itemDueDateChange);
        }
    }
    public void setDueDate(String newDueDate) {
        setDueDate(LocalDate.parse(newDueDate));
    }

    public void revertStatus() {
        if (status.ordinal() == 0) throw new IllegalArgumentException(REVERT_STATUS_ERROR);
        String previousStatus = status.label;
        status = Status.values()[status.ordinal()-1];
        String description = String.format("Status changed from %s to %s", previousStatus, status.label);
        Log itemStatusChange = new Log(description);
        addToHistory(itemStatusChange);
    }

    public void advanceStatus() {
        if (status.ordinal() == Status.values().length-1) throw new IllegalArgumentException(ADVANCE_STATUS_ERROR);
        String previousStatus = status.label;
        status = Status.values()[status.ordinal()+1];
        String description = String.format("Status changed from %s to %s", previousStatus, status.label);
        Log itemStatusChange = new Log(description);
        addToHistory(itemStatusChange);
    }

    public String getInfo() {
        String info = String.format("\"%s\", [%s | %s]", title, status.label, dueDate);
        return info;
    }

    public void viewInfo() {
        System.out.println(getInfo());
    }

    protected void addToHistory(Log log) {
        localEvents.add(log);
        EventLog.addLogToHistory(log);
    }

    public void displayLocalHistory() {
        for (Log kur : localEvents) {
            kur.viewInfo();
        }
    }
}
