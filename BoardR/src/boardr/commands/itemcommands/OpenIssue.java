package boardr.commands.itemcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;
import boardr.models.boarditem.Issue;

import java.util.List;

import static boardr.models.board.Board.getItems;
import static boardr.models.common.Errors.EXISTING_ITEM_ERROR;

public class OpenIssue implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        String description = parameters.get(1);
        String dueDate = parameters.get(2);
        return openIssue(title, description, dueDate);
    }
    private String openIssue(String title, String description, String dueDate) {
        if (getItems().stream().anyMatch(item -> item.getTitle().equals(title)))
            throw new IllegalArgumentException(EXISTING_ITEM_ERROR);
        Issue item = new Issue(title, description, dueDate);
        return String.format(CommandConstants.BOARD_ITEM_CREATED, item.getInfo());
    }
}
