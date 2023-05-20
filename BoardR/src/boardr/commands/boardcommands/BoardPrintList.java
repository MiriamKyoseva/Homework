package boardr.commands.boardcommands;

import boardr.commands.common.Command;
import boardr.models.board.Board;

import java.util.List;

public class BoardPrintList implements Command {
    @Override
    public String execute(List<String> parameters) {
        Board.printList();
        return "===";
    }
}
