import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Display {

    private Scanner reader;
    private ToDoList toDoList;
    private FileHandler fileSave;
    private Print printer;
    private SimpleDateFormat sdf;


    Display() throws IOException, ClassNotFoundException {
        reader = new Scanner(System.in);
        toDoList = new ToDoList();
        fileSave = new FileHandler();
        sdf = new SimpleDateFormat("MM-dd-yyyy");

       FileHandler fileHandler = new FileHandler();
       toDoList.setToDoList(fileHandler.loadFromFile());
        printer = new Print(toDoList.getToDoList());
    }



    public String userInput() {
        return reader.nextLine();
    }

    public void start() throws IOException, ClassNotFoundException {
        printer.printWelcome();
        response();
    }

    public void response() {
        while (true) {
            printer.printOptions();

            switch (userInput()) {
                case "1":
                    printList();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    editTask();
                    break;
                case "4":
                    quitAndSave();
                    return;
                default:
                    printer.printNotValiableOption();
            }
            printer.printPressEnterForMenu();
            userInput();
        }

    }


    public void addTask() {
        System.out.println("Add New Task \n");
        System.out.println("Name of Task:");

        Task task = new Task();
        task.setTitle(userInput());
        System.out.println("Name of Project");
        task.setProjectName(userInput());
        System.out.println("Due date? (MM-dd-yyyy)");

        while (true) {
            try {
                task.setDueDate(sdf.parse(userInput()));
                break;
            } catch (ParseException e) {
                printer.printWrongDateFormat();
            }
        }

        Date date = new Date();
        String strDate= sdf.format(date);
        try {
            task.setCreatedDate(sdf.parse(strDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        toDoList.addToDo(task);
        System.out.println("Task: " + task.getTitle() + " was added");
    }

    public void quitAndSave() {
        printer.printWhenQuitApplication();
        try {
            fileSave.saveToFile(toDoList.getToDoList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getProjectNumberAndMarkAsDone() {

        System.out.println("What task do you want to mark as done?");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task");
        Task searched;

        while (true) {
            try {
                int getProjectByNumber = Integer.parseInt(userInput());
                searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
                break;
            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        searched.setStatus(Status.DONE);
        System.out.println("Task is now set to DONE");
    }

    public void removeTask() {
        System.out.println("What of the below project do you want to delete? \n");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("\n Enter the number in front of the task");

        while (true) {
            try {
                int removeProjectByNumber = Integer.parseInt(userInput());
                toDoList.remove(removeProjectByNumber - 1);
                break;
            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        System.out.println("Task is removed");

    }

    public void update() {
        //has a functionality of editing name, project and date of the project
        // get their name
        printer.printUpdateOptions();
        switch (userInput()) {
            case "1":
                editName();
                break;
            case "2":
                editProject();
                break;
            case "3":
                editDate();
                break;
            default:
                printer.printNotValiableOption();
                update();
        }
    }

    public void editName() {
        System.out.println("Here you can edit a name for one of your tasks:");
        printer.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task which name you want to switch");
        Task searched;

        while (true) {
            try {
                int getTitleByNumber = Integer.parseInt(userInput());
                searched = toDoList.getTaskInToDo(getTitleByNumber - 1);
                break;
            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        System.out.println("What do you want to switch the name of " + searched.getTitle() + " to?");
        String newName = userInput();
        searched.setTitle(newName);
        System.out.println("Name edited to " + newName);
    }

    public void editProject() {
        System.out.println("Here you can edit a name of a project that your task is assigned to");
        printer.printIndexAndNameAndProjectOfTask();
        System.out.println("Enter the number in front of the task you want to switch the project to");
        Task searched;

        while (true) {
            try {
                int getProjectByNumber = Integer.parseInt(userInput());
                searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
                break;
            } catch (Exception e) {
                printer.printIndexOutOfReach();
            }
        }

        System.out.println("What project should " + searched.getTitle() + " belong to?");
        String newProject = userInput();
        searched.setProjectName(newProject);
        System.out.println(searched.getTitle() + " now belongs to project: " + newProject);
    }

    public void editDate() {
        System.out.println("Here you can edit due date of one of below tasks: ");
        printer.printIndexAndNameAndDueDateOfTask();
        System.out.println("Enter the number in front of the task you want to switch due date");

        try {
            int getProjectByNumber = Integer.parseInt(userInput());
            Task searched = toDoList.getTaskInToDo(getProjectByNumber - 1);
            System.out.println("Enter new due date of task " + searched.getTitle() + " below (MM-dd-yyyy)");

            while (true) {
                try {
                    searched.setDueDate(sdf.parse(userInput()));
                    break;
                } catch (ParseException e) {
                    printer.printWrongDateFormat();
                }
            }
            System.out.println(searched.getTitle() + " Due Date is set to " + sdf.format(searched.getDueDate()));
        }

        catch (NumberFormatException e) {
            printer.printIndexOutOfReach();
            editDate();
        }
    }

    public void editTask() {
        //class with all edit subclasses
        printer.printEditTaskOptions();

        switch (userInput()) {
            case "1":
                removeTask();
                break;
            case "2":
                getProjectNumberAndMarkAsDone();
                break;
            case "3":
                update();
                break;
            default:
                printer.printNotValiableOption();
                editTask();
        }
    }

    public void printList() {
        printer.printPrintOptions();

        switch (userInput()) {
            case "1":
                printer.printEntireList();
                break;
            case "2":
                printer.printTasksByStatus(Status.PENDING);
                break;
            case "3":
                printer.printTasksByStatus(Status.DONE);
                break;
            case "4":
                printer.printTasksByProject();
                break;
            case "5":
                printer.printTaskByDate();
                break;
            default:
                printer.printNotValiableOption();
                printList();
        }
    }

}

