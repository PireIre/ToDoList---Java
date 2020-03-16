import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList {

    private List<Task> toDo = new ArrayList<>();

    public void addToDo(Task task) {
        toDo.add(task);
    }


    public void remove(int index) {
        toDo.remove(index);
    }


    public void setToDo(List<Task> newTasks) {
        toDo = newTasks;
    }

    public List<Task> getToDo() {
        return toDo;
    }

    public Task getTaskInToDo(int index) {
        return toDo.get(index);
    }
}

