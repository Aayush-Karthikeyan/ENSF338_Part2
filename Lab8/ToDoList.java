package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks = new ArrayList<>();
    private Stack<List<Task>> history = new Stack<>();

    private List<Task> deepCopy(List<Task> list) {
        List<Task> copy = new ArrayList<>();
        for (Task t : list) {
            copy.add(t.copy());
        }
        return copy;
    }

    @Override
    public void addTask(Task task) {
        history.push(deepCopy(tasks));
        tasks.add(task);
    }

    @Override
    public void completeTask(String id) {
        history.push(deepCopy(tasks));
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setCompleted(true);
                return;
            }
        }
    }

    @Override
    public void deleteTask(String id) {
        history.push(deepCopy(tasks));
        tasks.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public void editTask(String id, String newTitle, boolean isCompleted) {
        history.push(deepCopy(tasks));
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setTitle(newTitle);
                t.setCompleted(isCompleted);
                return;
            }
        }
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
