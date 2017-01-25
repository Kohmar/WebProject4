package ua.training.entity;

import java.io.Serializable;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public abstract class Entity implements Serializable {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1369008817919379847L;
    /**
     * Field id.
     */
    private int id;

    /**
     * Getter for id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
