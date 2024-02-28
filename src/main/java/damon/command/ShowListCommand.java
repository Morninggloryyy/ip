package damon.command;

import damon.response.Response;
import damon.storage.Storage;
import damon.tasklist.TaskList;
import damon.ui.Ui;

/**
 * Represents ShowListCommand object which is corresponding to
 * user's input for showing the task list.
 */
public class ShowListCommand extends Command {
    public ShowListCommand(String command) {
        super(command);
    }

    /**
     * Executes ShowListCommand, i.e., shows current task list.
     *
     * @param tasks Current TaskList.
     * @param ui Ui object of Damon object.
     * @param storage Storage object of Damon object.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage, Response response) {
        ui.showShowTaskListCommand(tasks);

        response.showShowTaskListCommand(tasks);
    }
}
