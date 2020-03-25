import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Print {

    private List<Task> listOfToDos;
    private SimpleDateFormat sdf;

    Print(List<Task> listOfToDos) {
        this.listOfToDos = listOfToDos;
        this.sdf = new SimpleDateFormat("MM-dd-yyyy");
    }

    public void printHeading() {
        System.out.print(String.format("%1$-27s", "TASK"));
        System.out.print(String.format("%1$-27s", "PROJECT"));
        System.out.print(String.format("%1$-27s", "STATUS"));
        System.out.print(String.format("%1$-27s", "DATE CREATED"));
        System.out.println("DUE DATE");
        System.out.println("--------------------------------" +
                "--------------------------------------------" +
                "----------------------------------------");
    }


    public void printEntireList() {
        printHeading();

        listOfToDos.forEach(this::printBody);
    }

    public void printTasksByStatus(Status status) {
        printHeading();

        listOfToDos.stream()
                .filter(task -> task.getStatus() == status)
                .forEach(this::printBody);

    }

    public void printTasksByProject() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a Project below, by typing its name:");

        printIndexAndNameAndProjectOfTask();
        String project = reader.nextLine().toLowerCase();

        printHeading();

        listOfToDos.stream()
                .filter(task -> task.getProjectName().toLowerCase().equals(project))
                .forEach(this::printBody);

    }

    public void printBody(Task task) {

        System.out.print(listOfToDos.indexOf(task) + 1 + ". ");
        System.out.print(String.format("%1$-25s", task.getTitle()));
        System.out.print(String.format("%1$-25s", task.getProjectName()));
        System.out.print(String.format("%1$-28s", task.getStatus()));
        System.out.print(String.format("%1$-25s", sdf.format(task.getCreatedDate())));
        System.out.print(String.format("%1$-25s", sdf.format(task.getDueDate())));
        System.out.println("");
    }

    public void printTaskByDate() {
        printHeading();
        listOfToDos.sort(Comparator.comparing(Task::getDueDate));
        listOfToDos.stream().forEach(this::printBody);
    }

    public void printOnlyIndexAndNameOfTask() {
        for (Task list : listOfToDos) {
            System.out.print(listOfToDos.indexOf(list) + 1 + ". ");
            System.out.println(String.format("%1$-25s", list.getTitle()));
        }
    }

    public void printIndexAndNameAndProjectOfTask() {
        for (Task list : listOfToDos) {
            System.out.print(listOfToDos.indexOf(list) + 1 + ". ");
            System.out.print(String.format("%1$-25s", list.getTitle()));
            System.out.print(String.format("%1$-25s", list.getProjectName()));
            System.out.println();
        }
    }

    public void printIndexAndNameAndDueDateOfTask() {
        for (Task list : listOfToDos) {
            System.out.print(listOfToDos.indexOf(list) + 1 + ". ");
            System.out.print(String.format("%1$-25s", list.getTitle()));
            System.out.print(String.format("%1$-25s", sdf.format(list.getDueDate())));
            System.out.println();
        }
    }

    public void printWelcome() {

        System.out.println("\n Welcome to TO-DO application");
        System.out.println(" Pending tasks: " + getBackAmount(Status.PENDING) + " | Completed tasks: " + getBackAmount(Status.DONE));
        System.out.println("\n Pick an option:");
    }

    public int getBackAmount(Status status){
        int counter = 0;

        for(Task list: listOfToDos){
            if(list.getStatus()== status){
                counter++;
            }
        }
        return counter;
    }

    public void printOptions() {
        System.out.println("---------------------------------------------");
        System.out.println(" (1) Show Task List:");
        System.out.println(" (2) Add New Task");
        System.out.println(" (3) Edit Task (remove, mark as done, update)");
        System.out.println(" (4) Save and Quit");
    }

    public void printNotValiableOption() {
        System.out.println("You have not entered a viable option. Let's try this again. \n");
    }

    public void printWrongDateFormat() {
        System.out.println("Input of date was in wrong format. REQUIRED FORMAT: (MM-dd-yyyy)");
    }

    public void printWhenQuitApplication() {
        System.out.println("You have quit the application, your TO-DO list is saved.");
    }

    public void printIndexOutOfReach() {
        System.out.println("Index selected is not in reach. Select number in front of task again:");
    }

    public void printUpdateOptions() {
        System.out.println("Press (1) for editing task name");
        System.out.println("Press (2) for editing project name of a specific task");
        System.out.println("Press (3) for editing due date of a task");
    }

    public void printEditTaskOptions() {
        System.out.println("Press (1) for removing items from the list");
        System.out.println("Press (2) for marking tasks as done");
        System.out.println("Press (3) for updating tasks");
    }

    public void printPrintOptions() {
        System.out.println("Here you can print list sorted by:");
        System.out.println("(1): Print ALL");
        System.out.println("(2): All tasks that are PENDING");
        System.out.println("(3): All tasks that are DONE");
        System.out.println("(4): Print task by PROJECT:");
        System.out.println("(5): Due Date");
    }

    public void printPressEnterForMenu() {
        System.out.println("\n Press ENTER to see options again");
    }
}
