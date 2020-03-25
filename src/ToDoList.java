import java.util.*;

public class ToDoList {

    private List<Task> toDoList = new ArrayList<>();

    public void addToDo(Task task) { toDoList.add(task);}

    public void remove(int index) {
        toDoList.remove(index);
    }

    public void setToDoList(List<Task> newTasks) {
        toDoList = newTasks;
    }

    public List<Task> getToDoList() {
        return toDoList;
    }

    public Task getTaskInToDo(int index) {
        return toDoList.get(index);
    }
}

