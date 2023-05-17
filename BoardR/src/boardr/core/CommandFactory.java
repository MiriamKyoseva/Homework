package boardr.core;

import boardr.commands.Command;
import boardr.commands.CommandType;
import boardr.commands.CreateBoardItem;

import static boardr.models.common.Errors.INVALID_COMMAND;


public class CommandFactory {
    public static Command createCommand(String commandInput) {
        CommandType commandType = CommandType.valueOf(commandInput.toUpperCase());
        switch (commandType) {
            case CREATEBOARDITEM:
                return new CreateBoardItem();
            default:
                throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }
}
