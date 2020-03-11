import java.util.Date;
import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private Date dueDate = new Date(); //TODO: consider using a constructor for this class
    private Status status = Status.PENDING;
    private String projectName;
    private static final long serialVersionUID = 8367141910137788612L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectName(){
        return projectName;
    }

    public void setProjectName(String setProjectName) {
        projectName = setProjectName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) { this.dueDate = dueDate;}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status setStatus) {
        this.status = setStatus;
   }

}
