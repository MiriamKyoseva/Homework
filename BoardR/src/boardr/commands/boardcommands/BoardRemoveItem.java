package boardr.commands.boardcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;
import boardr.models.board.Bin;
import boardr.models.board.Board;
import boardr.models.eventlog.Log;

import java.util.List;

import static boardr.commands.common.CommandConstants.ITEM_REMOVED;
import static boardr.models.eventlog.EventLog.addLogToHistory;


public class BoardRemoveItem implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        int index = Board.getItemIndex(title);
        Bin.addTrashItem(Board.changeItem().get(index));
        Board.removeItem(Board.changeItem().get(index));
        String desc = String.format(ITEM_REMOVED, title);
        Log itemRemoved = new Log(desc);
        addLogToHistory(itemRemoved);
        return desc;
    }
}
