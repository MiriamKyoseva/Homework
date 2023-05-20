package boardr.commands.boardcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;
import boardr.models.board.Bin;
import boardr.models.board.Board;
import boardr.models.eventlog.Log;

import java.util.List;

import static boardr.commands.common.CommandConstants.ITEM_ADDED;
import static boardr.models.eventlog.EventLog.addLogToHistory;

public class BoardAddItem implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        int index = Bin.getItemIndex(title);
        Board.addItem(Bin.changeTrashItem().get(index));
        Bin.removeTrashItem(Bin.changeTrashItem().get(index));
        String desc = String.format(ITEM_ADDED, title);
        Log itemAdded = new Log(desc);
        addLogToHistory(itemAdded);
        return desc;
    }
}
