package ToDoApp;

import java.io.Serializable;

/**
 * This class is an enum which hold two possible
 * representation of statuses.
 *
 * @author  Irenej Bozovicar
 * @version 2020.03.26
 */

public enum Status implements Serializable {
    DONE, PENDING;
    private static final long serialVersionUID = 8367141910137788612L;

}
