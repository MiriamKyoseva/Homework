package boardr.models.boarditem;

import boardr.models.board.Board;
import boardr.models.common.Status;
import boardr.models.eventlog.Log;

import java.time.LocalDate;

import static boardr.models.common.Errors.*;

public class Task extends BoardItem {
    private static final int MIN_ASSIGNEE_LENGTH = 2;
    private static final int MAX_ASSIGNEE_LENGTH = 30;
    private String assignee;

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String newAssignee) {
        if (newAssignee == null)
            throw new IllegalArgumentException(NULL_ASSIGNEE_ERROR);
        if (newAssignee.isEmpty() || newAssignee.isBlank())
            throw new IllegalArgumentException(BLANK_ASSIGNEE_ERROR);
        if (newAssignee.length() < MIN_ASSIGNEE_LENGTH || newAssignee.length() > MAX_ASSIGNEE_LENGTH)
            throw new IllegalArgumentException(String.format(ASSIGNEE_LENGTH_ERROR, MIN_ASSIGNEE_LENGTH, MAX_ASSIGNEE_LENGTH));
        String previousAssignee = this.assignee;
        this.assignee = newAssignee;
        if (previousAssignee != null) {
            String desc = String.format("Assignee changed from %s to %s", previousAssignee, newAssignee);
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
        super(title, dueDate);
        setAssignee(assignee);
        status = Status.TO_DO;
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
}
