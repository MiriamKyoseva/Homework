package boardr.commands.itemcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;

import java.util.List;

import static boardr.models.board.Board.*;
import static boardr.models.common.Errors.SAME_DUE_DATE_ERROR;

public class ChangeItemDueDate implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        String newDueDate = parameters.get(1);
        int index = getItemIndex(title);
        return changeItemDueDate(title, newDueDate, index);
    }
    private String changeItemDueDate(String title, String newDueDate, int index) {
        String oldDueDate = String.valueOf(getItems().get(index).getDueDate());
        if (oldDueDate.equals(newDueDate)) throw new IllegalArgumentException(SAME_DUE_DATE_ERROR);
        else {
            changeItem().get(index).setDueDate(newDueDate);
            return String.format(CommandConstants.ITEM_DUE_DATE_CHANGED, title, oldDueDate, newDueDate);
        }
    }
}
