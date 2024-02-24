package damon.tasklist;

import java.util.ArrayList;

import damon.task.Task;

public class TaskList {
    private ArrayList<Task> taskList;


    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int size() {
        return this.taskList.size();
    }

    public Task get(int index) {
        return this.taskList.get(index);
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    public void markTask(int index) {
        this.taskList.get(index).markAsDone();
    }

    public void unMarkTask(int index) {
        this.taskList.get(index).markBackNotDone();
    }

    public TaskList findTasks(String keyword) {
        TaskList searchedTaskList = new TaskList();

        for (int i = 0; i < this.size(); i++) {
            Task currentTask = this.get(i);
            if (currentTask.isContainKeyword(keyword)) {
                searchedTaskList.addTask(currentTask);
            }
        }

        return searchedTaskList;
    }

    public ArrayList<Task> getArrayList() {
        return this.taskList;
    }
}
