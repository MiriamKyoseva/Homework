package boardr.models.board;

import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;

import static boardr.models.common.Errors.*;

public class Board {
    private static final ArrayList<BoardItem> items = new ArrayList<>();
    private static final ArrayList<BoardItem> trashItems = new ArrayList<>();
    private static ArrayList<BoardItem> searchTrashItem = getTrashItems();
    private static ArrayList<BoardItem> searchItem = getItems();
    public static ArrayList<BoardItem> changeItem() {
        return items;
    }
    public static ArrayList<BoardItem> getItems() {
        return new ArrayList<>(items);
    }
    public static int getItemIndex(String oldTitle) {
        BoardItem item = searchItem.stream().filter(kur -> kur.getTitle().equals(oldTitle)).findFirst().orElse(null);
        if (item == null) throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        return searchItem.indexOf(item);
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
        BoardItem item = searchTrashItem.stream().filter(kur -> kur.getTitle().equals(oldTitle)).findFirst().orElse(null);
        if (item == null) throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        return searchTrashItem.indexOf(item);
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
