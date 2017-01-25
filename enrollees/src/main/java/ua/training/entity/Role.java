package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * User role type.
 */
public enum Role {
    ADMIN,CLIENT;

    /**
     * getter for enum.
     * @return
     */
    public String getName(){
        return name().toLowerCase();
    }

}
