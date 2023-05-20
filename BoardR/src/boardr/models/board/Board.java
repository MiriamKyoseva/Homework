package boardr.models.board;

import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;

import static boardr.models.common.Errors.*;

public class Board {
    private static final ArrayList<BoardItem> items = new ArrayList<>();
    public static ArrayList<BoardItem> changeItem() {
        return items;
    }
    public static ArrayList<BoardItem> getItems() {
        return new ArrayList<>(items);
    }
    private int totalItems = items.size();
    public int getTotalItems() {
        return totalItems;
    }
    public static int getItemIndex(String oldTitle) {
        if (getItems().stream().noneMatch(item -> item.getTitle().equals(oldTitle)))
            throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        ArrayList<BoardItem> searchItem = getItems();
        int index = 0;
        for (BoardItem kur : searchItem) {
            if (kur.getTitle().equals(oldTitle))  index=getItems().indexOf(kur);
        }
        return index;
    }

    public static void addItem(BoardItem item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException(EXISTING_ITEM_ERROR);
        }
        items.add(item);
    }
    public static void removeItem(BoardItem item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        }
        items.remove(item);
    }
    public static void printList() {
        for (BoardItem kur : items) {
            kur.viewInfo();
        }
    }

}
