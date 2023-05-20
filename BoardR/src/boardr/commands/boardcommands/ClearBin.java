package boardr.commands.boardcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;
import boardr.models.boarditem.BoardItem;
import boardr.models.eventlog.Log;

import java.util.List;

import static boardr.commands.common.CommandConstants.CLEARED_BIN;
import static boardr.models.board.Bin.changeTrashItem;
import static boardr.models.board.Bin.removeTrashItem;
import static boardr.models.eventlog.EventLog.addLogToHistory;

public class ClearBin implements Command {
    @Override
    public String execute(List<String> parameters) {
        for (BoardItem trash : changeTrashItem()) {
            removeTrashItem(trash);
        }
        String desc = CLEARED_BIN;
        Log BinCleared = new Log(desc);
        addLogToHistory(BinCleared);
        return desc;
    }
}
