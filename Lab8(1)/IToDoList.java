package edu.ucalgary.oop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public interface IToDoList {
    public void addTask(Task task);
    public List<Task>listTasks();
    public void completeTask(String id);
    public void deleteTask(String id);
}
