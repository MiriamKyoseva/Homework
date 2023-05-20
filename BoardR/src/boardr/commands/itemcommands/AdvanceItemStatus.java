package boardr.commands.itemcommands;


import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;

import java.util.List;

import static boardr.models.board.Board.*;

public class AdvanceItemStatus implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        int index = getItemIndex(title);
        return advanceItemStatus(title, index);
    }
    private String advanceItemStatus(String title, int index) {
        String previousStatus = getItems().get(index).getStatus().label;
        changeItem().get(index).advanceStatus();
        String currentStatus = getItems().get(index).getStatus().label;
        return String.format(CommandConstants.ITEM_STATUS_CHANGED, title, previousStatus, currentStatus);
    }
}
