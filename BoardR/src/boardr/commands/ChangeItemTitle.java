package boardr.commands;

import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;
import java.util.List;

import static boardr.models.board.Board.getItems;
import static boardr.models.common.Errors.FINDING_ITEM_ERROR;
import static boardr.models.common.Errors.NEW_TITLE_ERROR;

public class ChangeItemTitle implements Command {
    @Override
    public String execute(List<String> parameters) {
        String oldTitle = parameters.get(0);
        String newTitle = parameters.get(1);
        int index = getItemIndex(oldTitle);
        return changeItemTitle(oldTitle, newTitle, index);
    }
    private int getItemIndex(String oldTitle) {
        if (getItems().stream().noneMatch(item -> item.getTitle().equals(oldTitle)))
            throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        ArrayList<BoardItem> searchItem = getItems();
        int index = 0;
        for (BoardItem kur : searchItem) {
            if (kur.getTitle().equals(oldTitle))  index=getItems().indexOf(kur);
        }
        return index;
    }
    private String changeItemTitle(String oldTitle, String newTitle, int index) {
        if (oldTitle.equals(newTitle)) throw new IllegalArgumentException(NEW_TITLE_ERROR);
        else {
            getItems().get(index).setTitle(newTitle);
            return String.format(CommandConstants.ITEM_TITLE_CHANGED, oldTitle, newTitle);
        }
    }
}
