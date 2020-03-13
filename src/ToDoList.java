import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList {

    private List<Task> toDo = new ArrayList<>();

    public void addToDo(Task task) {
        toDo.add(task);
    }

    public void printHeading() {
        System.out.print(String.format("%1$-27s", "TASK"));
        System.out.print(String.format("%1$-27s", "PROJECT"));
        System.out.print(String.format("%1$-27s", "STATUS"));
        System.out.println("DUE DATE");
        System.out.println("-----------------------------------------------------------------------------------------");
    }


    public void printEntireList() {
        printHeading();

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        for (Task list : toDo) {
            printBody(list);
        }

    }

    public void printTasksThatArePending() {
        printHeading();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        for (Task list : toDo) {
            if (list.getStatus() == Status.PENDING) {
                printBody(list);
            }
        }
    }

    public void printTasksByProject() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Select a Project below, by typing its name:");
        printIndexAndNameAndProjectOfTask();
        String project = reader.nextLine();

        printHeading();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        for (Task list : toDo) {
            if (list.getProjectName().equals(project)) {
                printBody(list);
            }
        }
    }

    public void printBody(Task task){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        System.out.print(toDo.indexOf(task) + 1 + ". ");
        System.out.print(String.format("%1$-25s", task.getTitle()));
        System.out.print(String.format("%1$-25s", task.getProjectName()));
        System.out.print(String.format("%1$-25s", task.getStatus()));
        System.out.print(String.format("%1$-25s", sdf.format(task.getDueDate())));
        System.out.println("");
    }

    public void printTasksThatAreDone() {
        printHeading();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        for (Task list : toDo) {
            if (list.getStatus() == Status.DONE) {
                printBody(list);
            }
        }
    }

    public void printTaskByDate() {
        printHeading();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        toDo.sort(Comparator.comparing(o -> o.getDueDate()));

        for (Task list : toDo) {
            printBody(list);
            }
        }

    public void printOnlyIndexAndNameOfTask() {
        for (Task list : toDo) {
            System.out.print(toDo.indexOf(list) + 1 + ". ");
            System.out.println(String.format("%1$-25s", list.getTitle()));
        }
    }

    public void printIndexAndNameAndProjectOfTask() {
        for (Task list : toDo) {
            System.out.print(toDo.indexOf(list) + 1 + ". ");
            System.out.print(String.format("%1$-25s", list.getTitle()));
            System.out.print(String.format("%1$-25s", list.getProjectName()));
            System.out.println();
        }
    }

    public void printIndexAndNameAndDueDateOfTask() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        for (Task list : toDo) {
            System.out.print(toDo.indexOf(list) + 1 + ". ");
            System.out.print(String.format("%1$-25s", list.getTitle()));
            System.out.print(String.format("%1$-25s", sdf.format(list.getDueDate())));
            System.out.println();
        }
    }

    public void remove(int index) {
        toDo.remove(index);
    }


    public void setToDo(List<Task> newTasks) {
        toDo = newTasks;
    }

    public List<Task> getToDo() {
        return toDo;
    }

    public Task getTaskInToDo(int index) {
        return toDo.get(index);
    }
}

