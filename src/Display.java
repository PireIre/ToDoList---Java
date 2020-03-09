import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Display {

    private Scanner reader = new Scanner(System.in);
    private ToDoList toDoTask = new ToDoList();
    private FileHandler fileSave = new FileHandler();

    public void startingDisplay() {

        System.out.println("Welcome to ToDoLy");
        System.out.println("You have X (number) tasks todo and Y tasks are done!");
        System.out.println(" Pick an option:");
        System.out.println(" (1) Show Task List:");
        System.out.println(" (2) Add New Task");
        System.out.println(" (3) Edit Task (update, mark as done, remove");
        System.out.println(" (4) Save and Quit");
    }

    public void response() {
        while (true) {
            String answer = reader.nextLine();

            if (answer.equals("4")) {
                System.out.println("You have quit the application, your TO-DO list is saved");
                try {
                    fileSave.saveToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            } else if (answer.equals("2")) {
                System.out.println("Add New Task");
                Task task = new Task();
                task.setTitle(reader.nextLine());
                toDoTask.addToDo(task);

            } else if (answer.equals("1")) {
                System.out.println("Task List: ");
                toDoTask.printList();
            }


        }
    }
}