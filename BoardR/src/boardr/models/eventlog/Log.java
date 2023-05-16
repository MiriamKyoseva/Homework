package boardr.models.eventlog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static boardr.models.common.Errors.*;

public class Log {
    private final String description;
    private final LocalDateTime timeStamp;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Log(String description) {
        if (description == null || description.isBlank() || description.isEmpty()) throw new IllegalArgumentException(EMPTY_STRING_ERROR);
        this.description = description;
        timeStamp = LocalDateTime.now();
    }

    public void viewInfo() {
        String formatDateTime = timeStamp.format(FORMATTER);
        String info = String.format("[%s] %s", formatDateTime, description);
        System.out.println(info);
    }

}
