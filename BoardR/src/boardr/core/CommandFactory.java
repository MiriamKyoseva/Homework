package boardr.core;

import boardr.commands.*;

import java.util.Arrays;

import static boardr.models.common.Errors.INVALID_COMMAND;


public class CommandFactory {
    public static Command createCommand(String commandInput) {
        if (Arrays.stream(CommandType.values()).noneMatch(command ->command.toString().equals(commandInput.toUpperCase()))) {
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
        CommandType commandType = CommandType.valueOf(commandInput.toUpperCase());
        switch (commandType) {
            case CREATEBOARDITEM:
                return new CreateBoardItem();
            case CREATETASK:
                return new CreateTask();
            case OPENISSUE:
                return new OpenIssue();
            case CHANGEITEMTITLE:
                return new ChangeItemTitle();
            // not implemented yet
            default:
                throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }
}
