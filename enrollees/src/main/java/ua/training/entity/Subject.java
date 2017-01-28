package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * The bean for the subject, which student have to pass.
 */
public class Subject extends Entity{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1834683719186355656L;

    /**
     * id of subject.
     */
    private int id;
    /**
     * name of subject.
     */
    private String nameOfSubject;

    /**
     * Constructor.
     *
     * @param nameOfSubject
     */
    public Subject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    /**
     * Getter for the name of subject.
     *
     * @return String
     */
    public String getNameOfSubject() {
        return nameOfSubject;
    }

    /**
     * Setter for the name of subject.
     *
     * @param nameOfSubject
     */
    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    @Override
    public String toString() {
        return "Subject [nameOfSubject=" + nameOfSubject + "]";
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

}
