import java.util.Date;
import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private Date dueDate;
    private String status;
    private String projectName;



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

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String setStatus) {
        this.status = setStatus;
    }
}
