package damon.command;

import damon.response.Response;
import damon.storage.Storage;

import damon.task.*;

import damon.tasklist.TaskList;
import damon.ui.Ui;

import java.time.LocalDate;

/**
 * Represents AddCommand object which is corresponding to user's adding Task input.
 */
public class AddCommand extends Command {
    public AddCommand(String command) {
        super(command);
    }

    /**
     * Executes AddCommand, i.e., adds a new Task to current TaskList.
     *
     * @param tasks Current TaskList.
     * @param ui Ui object of Damon object.
     * @param storage Storage object of Damon object.
     * @param response Response object of Damon object.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage, Response response) {
        Task newTask = this.getNewTask();

        tasks.addTask(newTask);
        ui.showAddCommand(newTask, tasks);
        storage.writeFile(tasks);

        response.showAddCommand(newTask, tasks);
    }

    private Task addToDo(String inputString) {
        String description = inputString.substring(5);

        return new ToDo(description);
    }

    private Task addDeadline(String inputString) {
        String[] splittedString = inputString.substring(9)
                .split(" /by ");
        String description = splittedString[0];
        String by = splittedString[1];

        return new Deadline(description, LocalDate.parse(by));
    }

    private Task addEvent(String inputString) {
        String[] firstSplittedString = inputString.substring(6)
                .split(" /from ");
        String description = firstSplittedString[0];

        String[] secondSplittedString = firstSplittedString[1].split(" /to ");
        String startTime = secondSplittedString[0];
        String endTime = secondSplittedString[1];

        return new Event(description, startTime, endTime);
    }

    private Task addFixedDuration(String inputString) {
        String[] splittedString = inputString.substring(14)
                .split(" /needs ");
        String description = splittedString[0];
        String duration = splittedString[1];

        return new FixedDuration(description, duration);
    }

    private Task getNewTask() {
        Task newTask;

        assert this.command.startsWith("todo") || this.command.startsWith("deadline")
                || this.command.startsWith("event") || this.command.startsWith("fixedduration");
        if (this.command.startsWith("todo")) {
            newTask = addToDo(this.command);
        } else if (this.command.startsWith("deadline")) {
            newTask = addDeadline(this.command);
        } else if (this.command.startsWith("event")) {
            newTask = addEvent(this.command);
        } else {
            newTask = addFixedDuration(this.command);
        }

        return newTask;
    }
}
