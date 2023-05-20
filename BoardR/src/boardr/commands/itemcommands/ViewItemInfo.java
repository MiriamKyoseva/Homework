package boardr.commands.itemcommands;

import boardr.commands.common.Command;

import java.util.List;

import static boardr.models.board.Board.getItemIndex;
import static boardr.models.board.Board.getItems;

public class ViewItemInfo implements Command {
    @Override
    public String execute (List<String> parameters) {
        String title = parameters.get(0);
        int index = getItemIndex(title);
        return viewItemInfo(index);
    }
    private String viewItemInfo(int index) {
        return getItems().get(index).getInfo();
    }
}
