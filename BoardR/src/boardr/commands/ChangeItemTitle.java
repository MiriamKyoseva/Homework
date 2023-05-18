package boardr.commands;

import boardr.models.board.Board;
import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;
import java.util.List;

import static boardr.models.boarditem.BoardItem.*;
import static boardr.models.board.Board.getItems;
import static boardr.models.board.Board.items;
import static boardr.models.common.Errors.*;

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
        items.get(index).setTitle(newTitle);
        return String.format(CommandConstants.ITEM_TITLE_CHANGED, oldTitle, newTitle);
    }
}
