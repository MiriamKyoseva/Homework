package boardr.commands.boardcommands;

import boardr.commands.common.Command;
import boardr.models.board.Bin;

import java.util.List;

public class BinPrintList implements Command {
    @Override
    public String execute(List<String> parameters) {
        Bin.printTrashList();
        return "===";
    }
}
