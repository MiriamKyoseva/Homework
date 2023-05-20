package boardr.commands.itemcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;

import java.util.List;

import static boardr.models.board.Board.*;

import static boardr.models.common.Errors.NEW_TITLE_ERROR;

public class ChangeItemTitle implements Command {
    @Override
    public String execute(List<String> parameters) {
        String oldTitle = parameters.get(0);
        String newTitle = parameters.get(1);
        int index = getItemIndex(oldTitle);
        return changeItemTitle(oldTitle, newTitle, index);
    }
    private String changeItemTitle(String oldTitle, String newTitle, int index) {
        if (oldTitle.equals(newTitle)) throw new IllegalArgumentException(NEW_TITLE_ERROR);
        else {
            changeItem().get(index).setTitle(newTitle);
            return String.format(CommandConstants.ITEM_TITLE_CHANGED, oldTitle, newTitle);
        }
    }
}
