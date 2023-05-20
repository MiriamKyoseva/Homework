package boardr.models.boarditem;

import boardr.models.board.Board;
import boardr.models.common.Status;
import boardr.models.eventlog.EventLog;
import boardr.models.eventlog.Log;

import java.time.LocalDate;

import static boardr.commands.common.CommandConstants.ASSIGNEE_CHANGED;
import static boardr.commands.common.CommandConstants.BOARD_ITEM_CREATED;
import static boardr.models.common.Errors.*;

public class Task extends BoardItem {
    private static final int MIN_ASSIGNEE_LENGTH = 2;
    private static final int MAX_ASSIGNEE_LENGTH = 30;

    public String getAssignee() {
        return assignee;
    }
    @Override
    public void setAssignee(String newAssignee) {
        if (newAssignee == null)
            throw new IllegalArgumentException(NULL_ASSIGNEE_ERROR);
        if (newAssignee.isEmpty() || newAssignee.isBlank())
            throw new IllegalArgumentException(BLANK_ASSIGNEE_ERROR);
        if (newAssignee.length() < MIN_ASSIGNEE_LENGTH || newAssignee.length() > MAX_ASSIGNEE_LENGTH)
            throw new IllegalArgumentException(String.format(ASSIGNEE_LENGTH_ERROR, MIN_ASSIGNEE_LENGTH, MAX_ASSIGNEE_LENGTH));
        //wtf
        String previousAssignee = this.assignee;
        this.assignee = newAssignee;
        if (previousAssignee != null) {
            String desc = String.format(ASSIGNEE_CHANGED, previousAssignee, newAssignee, getTitle());
            Log assigneeChange = new Log(desc);
            addToHistory(assigneeChange);
        }
    }

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate);
        setAssignee(assignee);
        status = Status.TO_DO;
    }

    public Task(String title, String assignee, String dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        setAssignee(assignee);
        status = Status.TO_DO;
        Board.addItem(this);
        String desc = String.format(BOARD_ITEM_CREATED, getInfo());
        Log itemCreated = new Log(desc);
        addToHistory(itemCreated);
    }
    @Override
    public void revertStatus() {
        if (status == Status.TO_DO) throw new IllegalArgumentException(REVERT_STATUS_ERROR);
        super.revertStatus();
    }
    @Override
    public String getInfo() {
        String info = String.format("Task \"%s\", [%s | %s] Assignee: %s", title, status.label, dueDate, assignee);
        return info;
    }
    @Override
    public void displayLocalHistory() {
        for (Log kur : localEvents) {
            kur.viewInfo();
        }
    }
}
