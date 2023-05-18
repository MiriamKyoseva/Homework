package boardr.core;

import boardr.commands.ChangeItemTitle;
import boardr.commands.Command;
import boardr.commands.CommandType;
import boardr.commands.CreateBoardItem;

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
            case CHANGEITEMTITLE:
                return new ChangeItemTitle();
            default:
                throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }
}
