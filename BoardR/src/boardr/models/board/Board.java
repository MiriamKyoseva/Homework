package boardr.models.board;

import boardr.models.boarditem.BoardItem;
import boardr.models.boarditem.Issue;
import boardr.models.boarditem.Task;

import java.util.ArrayList;

import static boardr.models.common.Errors.*;

public class Board {
    private static final ArrayList<BoardItem> items = new ArrayList<>();
    public static ArrayList<BoardItem> getItems() {
        return new ArrayList<>(items);
    }
    private int totalItems = items.size();
    public int getTotalItems() {
        return totalItems;
    }
    public static int getItemIndex(BoardItem item) {
        return items.indexOf(item);
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
