package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * This class is the bean for the entity of faculty.
 */
public class Faculty extends Entity {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -4086480183665579660L;

    /**
     * Field id.
     */
    private int id;
    /**
     * Field name of faculty.
     */
    private String nameOfFaculty;
    /**
     * Field budget Seats.
     */
    private int budgetSeats;
    /**
     * Field total Seats.
     */
    private int totalSeats;

    public Faculty() {
    }

    /**
     * Getter for the id.
     * @return int
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

    /**
     * Getter for the name of faculty.
     *
     * @return String
     */
    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    /**
     * Setter for the name of faculty.
     *
     * @param nameOfFaculty
     */
    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    /**
     * Getter for budget places.
     *
     * @return int
     */
    public int getBudgetSeats() {
        return budgetSeats;
    }

    /**
     * Setter for the number of budget places.
     *
     * @param budgetSeats
     */
    public void setBudgetSeats(int budgetSeats) {
        this.budgetSeats = budgetSeats;
    }

    /**
     * Getter for number of total places on the faculty.
     *
     * @return int
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     * Setter for the number of total places.
     *
     * @param totalSeats
     */
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (id != faculty.id) return false;
        return nameOfFaculty.equals(faculty.nameOfFaculty);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nameOfFaculty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", nameOfFaculty='" + nameOfFaculty + '\'' +
                ", budgetSeats=" + budgetSeats +
                ", totalSeats=" + totalSeats +
                '}';
    }

    /**
     * class for build class Faculty
     */
    public static class Builder{

        private int id;
        private String nameOfFaculty;
        private int budgetSeats;
        private int totalSeats;


        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNameOfFaculty(String nameOfFaculty) {
            this.nameOfFaculty = nameOfFaculty;
            return this;
        }

        public Builder setBudgetSeats(int budgetSeats) {
            this.budgetSeats = budgetSeats;
            return this;
        }

        public Builder setTotalSeats(int totalSeats) {
            this.totalSeats = totalSeats;
            return this;
        }

        public Faculty build(){
            Faculty faculty = new Faculty();
            faculty.setId(id);
            faculty.setNameOfFaculty(nameOfFaculty);
            faculty.setBudgetSeats(budgetSeats);
            faculty.setTotalSeats(totalSeats);
            return faculty;

        }
    }
}

