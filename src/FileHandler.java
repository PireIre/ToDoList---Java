
import java.io.*;
import java.util.List;


public class FileHandler {


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

        return null;

    }

    public void saveToFile(List<Task> tasksToSave) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ToDo.txt"));
        out.writeObject(tasksToSave);

        System.out.println("TASKS SAVED:");
        System.out.println();
        tasksToSave.forEach(task -> System.out.println("* " + task.getTitle())
        );
    }

}
