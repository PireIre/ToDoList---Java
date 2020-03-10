import java.io.*;
import java.io.BufferedReader;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;


public class FileHandler {

    /*

    public void writeFile() {
        Task task;

        Vector<Task> v = new Vector<>();
        v.add(new Task());

        File f = new File("ToDo.txt");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(v);
            oos.close();
            System.out.println("Data write works");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void readFile(){


                File f = new File("ToDo.txt");
                try {
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);


                    Vector<Task> deserializeStudent = (Vector<Task>)ois.readObject();
                    System.out.println(deserializeStudent);
                    ois.close();

                    Iterator<Task> iter = deserializeStudent.iterator();
                    while(iter.hasNext()){
                        Task s = iter.next();
                        System.out.println("Task: " + s.getTitle() +
                                           " Project: " + s.getProjectName() +
                                           " Status: " + s.getStatus() +
                                           " Date " + s.getDueDate()
                        );

                    }

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }


            }
            */

    public List<Task> loadFromFile() throws IOException, ClassNotFoundException {

        //TODO: handle FileNotFound
        //TODO: handle empty file
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("ToDo.txt"));
        List<Task> loadedTasks = (List<Task>) in.readObject();
        return loadedTasks;
    }

    public void saveToFile(List<Task> tasksToSave) throws IOException, FileNotFoundException, ClassNotFoundException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ToDo.txt"));
        out.writeObject(tasksToSave);

        System.out.println("Tasks saved:");
        tasksToSave.forEach(task -> System.out.println("Task: " + task.getTitle() +
                        " Project: " + task.getProjectName() +
                        " Status: " + task.getStatus() +
                        " Date " + task.getDueDate()
                )

        );

        /*
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("ToDo.txt"));
        Task task2 = (Task) in.readObject();

        System.out.println("Task: " + task2.getTitle() +
                " Project: " + task2.getProjectName() +
                " Status: " + task2.getStatus() +
                " Date " + task2.getDueDate()
        );

         */

    }

}











 /*

    public void saveToFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ToDo.txt"));
        out.writeObject(task);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("ToDo.txt"));
        Task task2 = (Task) in.readObject(); */

       /*public void fileWriter(){
           File file = new File("ToDo.txt");

          try(BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
              br.write("This is line one");
              br.newLine();
              br.write("This is line two");
              br.newLine();
              br.write("Last line.");
          }
          catch (IOException e) {
              System.out.println("Unable to write file" + file.toString());
          }
    }

        public void fileReader(){
            File file = new File("ToDo.txt");
            BufferedReader br = null;

            try {
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);

                String line = br.readLine();

               while (line != null){
                    System.out.println(line);

                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.toString());
            }
            catch (IOException e) {
                System.out.println("Unable to read the file: " + file.toString());
            }

            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Unable to close the file");
            }

        }*/

