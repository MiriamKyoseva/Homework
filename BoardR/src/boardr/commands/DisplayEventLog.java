package boardr.commands;

import boardr.commands.common.Command;
import boardr.models.eventlog.EventLog;

import java.util.List;

public class DisplayEventLog implements Command {
    @Override
    public String execute (List<String> parameters) {
        EventLog.displayHistory();
        return "===";
    }
}
