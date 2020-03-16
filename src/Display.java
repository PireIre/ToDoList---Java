import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Display {

    private Scanner reader;
    private ToDoList toDoList;
    private FileHandler fileSave;
    private Print printer;

    Display() throws IOException, ClassNotFoundException {
        reader = new Scanner(System.in);
        toDoList = new ToDoList();
        fileSave = new FileHandler();

        FileHandler fileHandler = new FileHandler();
        toDoList.setToDo(fileHandler.loadFromFile());
        printer = new Print(toDoList.getToDo());
    }

    public void start() {
        startingDisplay();
        response();
    }

    public void startingDisplay() {

        System.out.println("Welcome to ToDoLy");
        System.out.println("You have X (number) tasks todo and Y tasks are done!");
        System.out.println(" Pick an option:");
        printOptions();
    }

    public void printOptions() {
        System.out.println("---------------------------------------------");
        System.out.println(" (1) Show Task List:");
        System.out.println(" (2) Add New Task");
        System.out.println(" (3) Edit Task (update, mark as done, remove)");
        System.out.println(" (4) Save and Quit");
    }

    public void response() {
        while (true) {
            String answer = reader.nextLine();

            if (answer.equals("4")) {
                quitAndSave();
                break;

            } else if (answer.equals("2")) {
                addTask();
                printOptions();

            } else if (answer.equals("1")) {
                printList();
                printOptions();

            } else if (answer.equals("3")) {
                editTask();
                printOptions();
            }
            else{
                System.out.println("You have not entered a viable option. Let's try this again. \n");
                printOptions();
                response();
            }

        }
    }

    public void addTask() {
        System.out.println("Add New Task \n");
        System.out.println("Name of Task:");
        Task task = new Task();
        task.setTitle(reader.nextLine());
        System.out.println("Name of Project");
        task.setProjectName(reader.nextLine());
        System.out.println("Due date? (MM-dd-yyyy)");

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        while (true) {
            try {
                task.setDueDate(sdf.parse(reader.nextLine()));
                break;
            } catch (ParseException e) {
                System.out.println("Input of date was in wrong format. REQUIRED FORMAT: (MM-dd-yyyy)");
            }
        }

        toDoList.addToDo(task);
        System.out.println("Task was added");
    }

    public void quitAndSave() {
        System.out.println("You have quit the application, your TO-DO list is saved.");
        try {
            fileSave.saveToFile(toDoList.getToDo());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getProjectNumberAndMarkAsDone() {

        System.out.println("What task do you want to mark as done?");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task");
        Task searched;

        while (true){
            try{
                int getProjectByNumber = Integer.parseInt(reader.nextLine());
                searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
                break;
            }
            catch (Exception e){
                System.out.println("Index selected is not in reach. Select number in front of task again:");
            }
        }

        searched.setStatus(Status.DONE);
        System.out.println("Task is now set to DONE");
    }

    public void removeTask() {
        System.out.println("What of the below project do you want to delete? \n");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("\n Enter the number in front of the task");

        while (true){
            try{
                int removeProjectByNumber = Integer.parseInt(reader.nextLine());
                toDoList.remove(removeProjectByNumber-1);
                break;
            }
            catch (Exception e){
                System.out.println("Index selected is not in reach. Select number in front of task again:");
            }
        }

        System.out.println("Task is removed");

    }

    public void update() {
        //has a functionality of editing name, project and date of the project
        // get their name
        System.out.println("Press (1) for editing task name");
        System.out.println("Press (2) for editing project name of a specific task");
        System.out.println("Press (3) for editing due date of a task");
        String edit = reader.nextLine();

        if (edit.equals("1")) {
            editName();
        } else if (edit.equals("2")) {
            editProject();
        } else if (edit.equals("3")) {
            editDate();
        }
        else{
            System.out.println("You have not entered viable option. Let's try this again. \n");
            update();
        }
    }

    public void editName() {
        System.out.println("Here you can edit a name for one of your tasks:");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task which name you want to switch");
        Task searched;

        while (true){
            try{
                int getProjectByNumber = Integer.parseInt(reader.nextLine());
                searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
                break;
            }
            catch (Exception e){
                System.out.println("Index selected is not in reach. Select number in front of task again:");
            }
        }

        System.out.println("What do you want to switch the name of " + searched.getTitle() + " to?");
        String newName = reader.nextLine();
        searched.setTitle(newName);
        System.out.println("Name edited to " + newName);
    }

    public void editProject() {
        System.out.println("Here you can edit a name of a project that your task is assigned to");
        printer.printIndexAndNameAndProjectOfTask();
        System.out.println("Enter the number in front of the task you want to switch the project to");
        Task searched;

        while (true){
            try{
                int getProjectByNumber = Integer.parseInt(reader.nextLine());
                searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
                break;
            }
            catch (Exception e){
                System.out.println("Index selected is not in reach. Select number in front of task again:");
            }
        }

        System.out.println("What project should " + searched.getTitle() + " belong to?");
        String newProject = reader.nextLine();
        searched.setProjectName(newProject);
        System.out.println(searched.getTitle() + " now belongs to project: " + newProject);
    }

    public void editDate() {
        System.out.println("Here you can edit due date of one of below tasks: ");
        printer.printIndexAndNameAndDueDateOfTask();
        System.out.println("Enter the number in front of the task you want to switch due date");
        int getProjectByNumber = Integer.parseInt(reader.nextLine());

        Task searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
        System.out.println("Enter new due date of task " + searched.getTitle() + " below (MM-dd-yyyy)");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        try {
            searched.setDueDate(sdf.parse(reader.nextLine()));
        } catch (ParseException e) {
            System.out.println("Format was entered wrongly");
        }
        System.out.println(searched.getTitle() + " Due Date is set to " + sdf.format(searched.getDueDate()));
    }

    public void editTask() {
        //class with all edit subclasses
        System.out.println("Press (1) for removing items from the list");
        System.out.println("Press (2) for marking tasks as done");
        System.out.println("Press (3) for updating tasks");

        String edit = reader.nextLine();

        if (edit.equals("1")) {
            removeTask();
        } else if (edit.equals("2")) {
            getProjectNumberAndMarkAsDone();
        } else if (edit.equals("3")) {
            update();
        }
        else{
            System.out.println("You have not entered viable option. Let's try this again. \n");
            editTask();
        }
    }

    public void printList() {
        System.out.println("Here you can print list sorted by:");
        System.out.println("(1): Print ALL");
        System.out.println("(2): All tasks that are PENDING");
        System.out.println("(3): All tasks that are DONE");
        System.out.println("(4): Print task by PROJECT:");
        System.out.println("(5): Date");

        String howToSort = reader.nextLine();

        if (howToSort.equals("1")) {
            printer.printEntireList();
        } else if (howToSort.equals("2")) {
            printer.printTasksThatArePending();
        } else if (howToSort.equals("3")) {
            printer.printTasksThatAreDone();
        } else if (howToSort.equals("4")) {
            printer.printTasksByProject();
        } else if (howToSort.equals("5")) {
            printer.printTaskByDate();
        }
        else{
            System.out.println("You have not entered a viable option. Let's try this again. \n");
            printList();
        }

    }

}

