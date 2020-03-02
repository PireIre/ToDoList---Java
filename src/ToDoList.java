import java.util.ArrayList;


public class ToDoList {

    private ArrayList<String> toDo= new ArrayList<String>();

    public ToDoList(ArrayList<String> toDo){
        this.toDo = toDo;
    }

    public void addToDo(String task){
        toDo.add(task);
    }
    public void printList(){

        for (String list: toDo){
            System.out.println("*  " + list);
        }

    }
}
