import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList {

    private List<Task> toDo = new ArrayList<>();

    public void addToDo(Task task) {
        toDo.add(task);
    }

    public void printList() {
        System.out.println("\tTASKS" + "\t\t\t\t" + "\tPROJECT" + "\t\t\t\t" + "\tSTATUS" + "\t\t\t\t" + "\tDUE DATE");
        System.out.println("-----------------------------------------------------------------------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");


        for (Task list : toDo) {
            System.out.println(toDo.indexOf(list) + 1 + "  " + list.getTitle() + "\t\t\t\t" + list.getProjectName() +
                    "\t\t\t\t" + list.getStatus() + "\t\t\t\t" + sdf.format(list.getDueDate())); //TODO: use String.format() instead
        }

    }

    public void setToDo(List<Task> newTasks) {
        toDo = newTasks;
    }

    public List<Task> getToDo() {
        return toDo;
    }
}
