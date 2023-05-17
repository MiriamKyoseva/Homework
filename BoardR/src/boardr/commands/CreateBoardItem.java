package boardr.commands;


import boardr.models.boarditem.BoardItem;

import java.time.LocalDate;
import java.util.List;

import static boardr.models.board.Board.*;
import static boardr.models.common.Errors.*;

public class CreateBoardItem implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        String dueDate = parameters.get(1);
        return createBoardItem(title, dueDate);
    }
    private String createBoardItem(String title, String dueDate) {
        if (getItems().contains(title)) throw new IllegalArgumentException(EXISTING_ITEM_ERROR);
        BoardItem item = new BoardItem(title, dueDate);
        return String.format(CommandConstants.BOARD_ITEM_CREATED, item.getInfo());
    }
}
