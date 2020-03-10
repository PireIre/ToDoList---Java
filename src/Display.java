import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Display {

    private Scanner reader;
    private ToDoList toDoTask;
    private FileHandler fileSave;

    Display() throws IOException, ClassNotFoundException {
        reader = new Scanner(System.in);
        toDoTask = new ToDoList();
        fileSave = new FileHandler();

        FileHandler fileHandler = new FileHandler();
        toDoTask.setToDo(fileHandler.loadFromFile());
    }

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
                    fileSave.saveToFile(toDoTask.getToDo());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            } else if (answer.equals("2")) {
                System.out.println("Add New Task");
                System.out.println("");
                System.out.println("Name of Task:");
                Task task = new Task();
                task.setTitle(reader.nextLine());
                System.out.println("Name of Project");
                task.setProjectName(reader.nextLine());
                System.out.println("Due date? (MM-dd-yyyy)");

                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                try {
                    task.setDueDate(sdf.parse(reader.nextLine()));
                } catch (ParseException e) {
                    System.out.println("Input of date was in wrong format , currently input is added to list anyway (needs to be corrected)");
                }
                toDoTask.addToDo(task);

            } else if (answer.equals("1")) {
                toDoTask.printList();
            }


        }
    }

}