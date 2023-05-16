package boardr.models.board;

import boardr.models.boarditem.BoardItem;

import java.util.ArrayList;
import static boardr.models.common.Errors.*;

public class Board {
    private static final ArrayList<BoardItem> items = new ArrayList<>();
    public static int count = 0;

    public static void addItem(BoardItem item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException(EXISTING_ITEM_ERROR);
        }
        items.add(item);
        count++;
    }
    public static void removeItem(BoardItem item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException(FINDING_ITEM_ERROR);
        }
        items.remove(item);
        count--;
    }
    public static void printList() {
        for (BoardItem kur : items) {
            kur.viewInfo();
        }
    }

}
