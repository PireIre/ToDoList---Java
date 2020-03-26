import java.util.*;

/**
 * This class is part of the ToDo application.
 * ToDo is a very simple, text based todo list application.
 *
 * This class holds a list of tasks objects.
 * Users can add, remove tasks.
 *
 * @author  Irenej
 * @version 2020.03.26
 */

public class ToDoList {

    private List<Task> toDoList = new ArrayList<>();

    /**
     * Inserts a task in the list of task
     * @param task Task you want to insert in a list.
     */

    public void addToDo(Task task) { toDoList.add(task);}

    /**
     * Remove a task in the list of tasks
     * @param index Index of task you want to delete from a list.
     */

    public void remove(int index) {
        toDoList.remove(index);
    }

    /**
     * Sets list of Tasks.
     * @param newTasks list of Tasks.
     */

    public void setToDoList(List<Task> newTasks) {
        toDoList = newTasks;
    }


    /**
     * Return the list of tasks.
     * @return list of Tasks.
     */

    public List<Task> getToDoList() {
        return toDoList;
    }

    /**
     * Return the task in list of tasks.
     * @param index index of task you want to return.
     * @return task in list of task based on specific index.
     */

    public Task getTaskInToDo(int index) {
        return toDoList.get(index);
    }
}

