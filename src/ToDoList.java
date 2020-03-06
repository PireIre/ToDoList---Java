import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private List<Task> toDo= new ArrayList<>();


    public void addToDo(Task task){
        toDo.add(task);
    }
    public void printList(){

        for (Task list: toDo){
            System.out.println("*  " + list.getTitle());
        }

    }
}
