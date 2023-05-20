package boardr.commands.itemcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;

import java.util.List;

import static boardr.models.board.Board.*;
import static boardr.models.board.Board.getItems;

public class RevertItemStatus implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        int index = getItemIndex(title);
        return revertItemStatus(title, index);
    }
    private String revertItemStatus(String title, int index) {
        String previousStatus = getItems().get(index).getStatus().label;
        changeItem().get(index).revertStatus();
        String currentStatus = getItems().get(index).getStatus().label;
        return String.format(CommandConstants.ITEM_STATUS_CHANGED, title, previousStatus, currentStatus);
    }
}
