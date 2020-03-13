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

    public void start(){
        startingDisplay();
        response();
    }

    public void startingDisplay() {

        System.out.println("Welcome to ToDoLy");
        System.out.println("You have X (number) tasks todo and Y tasks are done!");
        System.out.println(" Pick an option:");
        System.out.println(" (1) Show Task List:");  //sort by Date and sort by Status
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

            } else if (answer.equals("1")) {
                printList();

            } else if (answer.equals("3")) {
                //UPDATE METHOD (Edit name, project, date - can be put in seperate submethods)
                //MARK AS DONE METHOD
                // REMOVE METHOD
                editTask();

            }

        }
    }

    public void addTask() {
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
        System.out.println("Task was added");
    }

    public void quitAndSave() {
        System.out.println("You have quit the application, your TO-DO list is saved.");
        try {
            fileSave.saveToFile(toDoTask.getToDo());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getProjectNumberAndMarkAsDone() {
        // ask what number of project they want to mark as done
        // change the task that is has an index of that number-1 to DONE
        System.out.println("What task do you want to mark as done?");
        toDoTask.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task");
        int getProjectByNumber = Integer.parseInt(reader.nextLine());

        Task searched = toDoTask.getTaskInToDo(getProjectByNumber-1);
        searched.setStatus(Status.DONE);
        System.out.println("Task is now set to DONE");
    }

    public void removeTask(){
        // ask for which project number they want to remove
        // get the project that has an index of (number-1)
        // use: toDo.remove();

        System.out.println("What of the below project do you want to delete?");
        toDoTask.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task");
        int removeProjectByNumber = Integer.parseInt(reader.nextLine());

        toDoTask.remove(removeProjectByNumber-1);
        System.out.println("Task is removed");

    }

    public void update(){
        //has a functionality of editing name, project and date of the project
        // get their name
        System.out.println("Press (1) for editing task name");
        System.out.println("Press (2) for editing project name of a specific task");
        System.out.println("Press (3) for editing due date of a task");
        String edit = reader.nextLine();

        if(edit.equals("1")){
            editName();
        }
        else if(edit.equals("2")){
            editProject();
        }
        else if(edit.equals("3")){
            editDate();
        }
    }
    public void editName(){
        System.out.println("Here you can edit a name for one of your tasks:");
        toDoTask.printOnlyIndexAndNameOfTask();
        System.out.println("Enter the number in front of the task which name you want to switch");
        int getProjectByNumber = Integer.parseInt(reader.nextLine());
        Task searched = toDoTask.getTaskInToDo(getProjectByNumber-1);
        System.out.println("What do you want to switch the name of " + searched.getTitle() + " to?");
        String newName = reader.nextLine();
        searched.setTitle(newName);
        System.out.println("Name edited to " + newName);
    }
    public void editProject(){
        System.out.println("Here you can edit a name of a project that your task is assigned to");
        toDoTask.printIndexAndNameAndProjectOfTask();
        System.out.println("Enter the number in front of the task you want to switch the project to");
        int getProjectByNumber = Integer.parseInt(reader.nextLine());
        Task searched = toDoTask.getTaskInToDo(getProjectByNumber-1);
        System.out.println("What project should " + searched.getTitle() + " belong to?");
        String newProject = reader.nextLine();
        searched.setProjectName(newProject);
        System.out.println(searched.getTitle() +" now belongs to project: " + newProject);
    }
    public void editDate() {
        System.out.println("Here you can edit due date of one of below tasks: ");
        toDoTask.printIndexAndNameAndDueDateOfTask();
        System.out.println("Enter the number in front of the task you want to switch due date");
        int getProjectByNumber = Integer.parseInt(reader.nextLine());
        Task searched = toDoTask.getTaskInToDo(getProjectByNumber-1);
        System.out.println("Enter new due date of task " + searched.getTitle() + " below (MM-dd-yyyy)");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        try {
            searched.setDueDate(sdf.parse(reader.nextLine()));
        } catch (ParseException e) {
            System.out.println("Format was entered wrongly");
        }
        System.out.println(searched.getTitle() +" Due Date is set to " + sdf.format(searched.getDueDate()));
    }

    public void editTask(){
        //class with all edit subclasses
        System.out.println("Press (1) for removing items from the list");
        System.out.println("Press (2) for marking tasks as done");
        System.out.println("Press (3) for updating tasks");

        String edit = reader.nextLine();

        if(edit.equals("1")){
            removeTask();
        }
        else if(edit.equals("2")){
            getProjectNumberAndMarkAsDone();
        }
        else if(edit.equals("3")){
            update();
        }
    }

    public void printList(){
        System.out.println("Here you can print list sorted by:");
        System.out.println("(1): Print ALL");
        System.out.println("(2): All tasks that are PENDING");
        System.out.println("(3): All tasks that are DONE");
        System.out.println("(4): Print task by PROJECT:");
        System.out.println("(5): Date");

        String howToSort = reader.nextLine();

        if (howToSort.equals("1")){
            toDoTask.printEntireList();
        }
        else if (howToSort.equals("2")){
            toDoTask.printTasksThatArePending();
        }
        else if(howToSort.equals("3")){
            toDoTask.printTasksThatAreDone();
        }
        else if(howToSort.equals("4")){
            toDoTask.printTasksByProject();
        }
        else if(howToSort.equals("5")){
            toDoTask.printTaskByDate();
        }

    }

}

