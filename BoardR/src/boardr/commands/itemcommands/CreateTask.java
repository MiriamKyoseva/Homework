package boardr.commands.itemcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;
import boardr.models.boarditem.Task;

import java.util.List;

import static boardr.models.board.Board.getItems;
import static boardr.models.common.Errors.EXISTING_ITEM_ERROR;

public class CreateTask implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        String assignee = parameters.get(1);
        String dueDate = parameters.get(2);
        return createTask(title, assignee, dueDate);
    }
    private String createTask(String title, String assignee, String dueDate) {
        if (getItems().stream().anyMatch(item -> item.getTitle().equals(title)))
            throw new IllegalArgumentException(EXISTING_ITEM_ERROR);
        Task item = new Task(title, assignee, dueDate);
        return String.format(CommandConstants.BOARD_ITEM_CREATED, item.getInfo());
    }
}
