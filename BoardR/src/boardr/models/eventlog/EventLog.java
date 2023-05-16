package boardr.models.eventlog;

import java.util.ArrayList;

public class EventLog {
    private static final ArrayList<Log> events = new ArrayList<>();
    public static void addLogToHistory(Log log) {
        events.add(log);
    }
    public static void displayHistory() {
        for (Log kur : events) {
            kur.viewInfo();
        }
    }
}
