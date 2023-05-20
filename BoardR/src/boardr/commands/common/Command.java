package boardr.commands.common;

import java.util.List;

public interface Command {
    String execute(List<String> parameters);
}
