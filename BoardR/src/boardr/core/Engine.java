package boardr.core;

import boardr.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static boardr.models.common.Errors.*;

public class Engine {
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            //try {
                String commandInput = sc.nextLine();
                if (commandInput.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(commandInput);
            //}catch (Exception ex) {
            //    System.out.println((ex.getMessage() != null && !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString()));
            //}
            //tova za kakvo e? wtf
        }
    }

    private void processCommand(String commandInput) {
        if (commandInput == null || commandInput.trim().equals("")) {
            throw new IllegalArgumentException(COMMAND_ERROR_INVALID_COMMAND);
        }
        String commandName = parseCommand(commandInput);
        Command command = CommandFactory.createCommand(commandName);
        List<String> parameters = parseParameters(commandInput);
        String executionResult = command.execute(parameters);
        System.out.println(executionResult);
    }

    public static String parseCommand(String fullCommand) {
        String commandName = fullCommand.split(" ")[0];
        return commandName;
    }
    public static List<String> parseParameters(String fullCommand) {
        String[] commandParts = fullCommand.split(" ");
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 1 ; i < commandParts.length ; i++) {
            parameters.add(commandParts[i]);
        }
        return parameters;
    }
}
