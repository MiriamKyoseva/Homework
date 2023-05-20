package boardr.models.board;

import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;

import static boardr.models.common.Errors.*;

public class Board {
    private static final ArrayList<BoardItem> items = new ArrayList<>();
    private static final ArrayList<BoardItem> trashItems = new ArrayList<>();
    public static ArrayList<BoardItem> changeItem() {
        return items;
    }
    public static ArrayList<BoardItem> getItems() {
        return new ArrayList<>(items);
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

    public static ArrayList<BoardItem> changeTrashItem() {
        return trashItems;
    }
    public static ArrayList<BoardItem> getTrashItems() {
        return new ArrayList<>(trashItems);
    }
    public static int getTrashItemIndex(String oldTitle) {
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
