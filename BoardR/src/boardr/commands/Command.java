package boardr.commands;

import java.util.List;

public interface Command {
    String execute(List<String> parameters);
}