import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that loads and saves to a file .txt file.
 * @author  Irenej Bozovicar
 * @version 2020.03.26
 */


public class FileHandler {

    /**
     * Method that retrieves information from already created file.
     * @return List, representing previously saved Task objects.
     */


    public List<Task> loadFromFile() throws IOException, ClassNotFoundException {

        //TODO: handle FileNotFound
        //TODO: handle empty file

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("ToDo.txt"));
            List<Task> loadedTasks = (List<Task>) in.readObject();
            return loadedTasks;
        }
        catch (EOFException e){
            System.out.println("File is empty. First thing you need to do is create a task!");
        }
        catch (FileNotFoundException e){
            List<Task> list = new ArrayList<Task>();
            saveToFile(list);

        }

        return null;

    }

    /**
     * Method that updates the file and saves it for possibility of further manipulation.
     */

    public void saveToFile(List<Task> tasksToSave) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ToDo.txt"));
        out.writeObject(tasksToSave);

        System.out.println("TASKS SAVED:");
        System.out.println();
        tasksToSave.forEach(task -> System.out.println("* " + task.getTitle())
        );
    }

}
