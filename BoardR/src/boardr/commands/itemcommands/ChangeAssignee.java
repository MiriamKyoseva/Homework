package boardr.commands.itemcommands;

import boardr.commands.common.Command;
import boardr.commands.common.CommandConstants;

import java.util.List;
import static boardr.models.board.Board.*;

public class ChangeAssignee implements Command {
    @Override
    public String execute(List<String> parameters) {
        String title = parameters.get(0);
        String previousAssignee = parameters.get(1);
        String newAssignee = parameters.get(2);
        int index = getItemIndex(title);
        return changeAssignee(title, previousAssignee, newAssignee, index);
    }
    private String changeAssignee(String title, String previousAssignee, String newAssignee, int index) {
        if (previousAssignee.equals(newAssignee)) throw new IllegalArgumentException();
        else {
            changeItem().get(index).setAssignee(newAssignee);
            return String.format(CommandConstants.ASSIGNEE_CHANGED, previousAssignee, newAssignee, title);
        }
    }
}
