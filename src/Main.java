import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> list= new ArrayList<String>();
        ToDoList toDoTask = new ToDoList(list);

        System.out.println("Welcome to ToDoLy");
        System.out.println(">> You have X tasks todo and Y tasks are done!");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");


        while(true){
            String answer = reader.nextLine();

            if (answer.equals("4")){
                System.out.println("You have quit the application");
                break;
            }

            else if (answer.equals("2")){
                System.out.println("Add New Task");
                toDoTask.addToDo(reader.nextLine());
            }

            else if (answer.equals("1")){
                System.out.println("Task List: ");
                toDoTask.printList();
            }
        }



    }
}
