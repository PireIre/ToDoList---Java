package ToDoApp;

import java.io.IOException;

/**
 *  This class is the main class of the ToDo application.
 *  ToDo is a very simple, text based todo list application.
 *
 *  Users can create new tasks, assign them a title and due date,
 *  and choose a project for that task to belong to.
 *  Users can also edit, mark as done or remove tasks.
 *
 *  The application saves the current task list to file when the user quits,
 *  and then restarts with the former state restored.
 *
 * @author  Irenej
 * @version 2020.03.26
 */


/**
 *  Main routine. Starts the application and
 *  loops until user quits the application.
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Display display = new Display();
        display.start();
    }
}