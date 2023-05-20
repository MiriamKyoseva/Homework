package boardr.models.board;

import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;

import static boardr.models.common.Errors.EXISTING_ITEM_ERROR;
import static boardr.models.common.Errors.FINDING_ITEM_ERROR;

public class Bin {
    private static final ArrayList<BoardItem> trashItems = new ArrayList<>();
    public static ArrayList<BoardItem> changeTrashItem() {
        return trashItems;
    }
    public static ArrayList<BoardItem> getTrashItems() {
        return new ArrayList<>(trashItems);
    }
    public static int getItemIndex(String oldTitle) {
        if (getTrashItems().stream().noneMatch(item -> item.getTitle().equals(oldTitle)))
            throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        ArrayList<BoardItem> searchItem = getTrashItems();
        int index = 0;
        for (BoardItem kur : searchItem) {
            if (kur.getTitle().equals(oldTitle))  index=getTrashItems().indexOf(kur);
        }
        return index;
    }

    public static void addTrashItem(BoardItem item) {
        if (trashItems.contains(item)) {
            throw new IllegalArgumentException(EXISTING_ITEM_ERROR);
        }
        trashItems.add(item);
    }
    public static void removeTrashItem(BoardItem item) {
        if (!trashItems.contains(item)) {
            throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        }
        trashItems.remove(item);
    }
    public static void printTrashList() {
        for (BoardItem kur : trashItems) {
            kur.viewInfo();
        }
    }


}
