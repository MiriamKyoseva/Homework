package boardr.commands.boardcommands;

import boardr.commands.common.Command;

import java.util.List;

import static boardr.models.board.Board.printTrashList;

public class BinPrintList implements Command {
    @Override
    public String execute(List<String> parameters) {
        printTrashList();
        return "===";
    }
}
