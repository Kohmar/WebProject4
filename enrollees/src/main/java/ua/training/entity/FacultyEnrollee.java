package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 *  This class tells ablout concret enrolles, which are applied for the which faculty using their foreign keys.
 */
public class FacultyEnrollee extends Entity{
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 3575702946111571141L;

    /**
     * Field for id.
     */
    private int id;

    /**
     * Field for facultyId.
     */
    private int facultyId;

    /**
     * Field for enrolleeId.
     */
    private int enrolleeId;

    /**
     * Field for first Name.
     */
    private String firstName;

    /**
     * Field for last Name.
     */
    private String lastName;
    /**
     * Filed for city.
     */
    private String city;
    /**
     * Field for region.
     */
    private String region;
    /**
     * Field for summary points.
     */
    private Integer summaryPoints;


    public FacultyEnrollee() {

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
     * Getter for faculty id.
     *
     * @return
     */
    public int getFacultyId() {
        return facultyId;
    }

    /**
     * Setter for faculty id.
     *
     * @param facultyId
     */
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * Getter for Enrollee id.
     *
     * @return
     */
    public int getEnrolleeId() {
        return enrolleeId;
    }

    /**
     * Setter for enrollee id.
     *
     * @param enrolleeId
     */
    public void setEnrolleeId(int enrolleeId) {
        this.enrolleeId = enrolleeId;
    }


    /**
     * Getter for first Name.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the first Name.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the Lase name.
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last Name.
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the city.
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the City.
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the region.
     *
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     * Setter for the region.
     *
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Getter for the SummaryPoints.
     *
     * @return Integer
     */
    public Integer getsummaryPoints() {
        return summaryPoints;
    }

    /**
     * Setter for the summaty Points.
     *
     * @param summaryPoints
     */
    public void setsummaryPoints(Integer summaryPoints) {
        this.summaryPoints = summaryPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultyEnrollee that = (FacultyEnrollee) o;

        if (id != that.id) return false;
        if (facultyId != that.facultyId) return false;
        if (enrolleeId != that.enrolleeId) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!city.equals(that.city)) return false;
        if (!region.equals(that.region)) return false;
        return summaryPoints.equals(that.summaryPoints);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + facultyId;
        result = 31 * result + enrolleeId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + summaryPoints.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FacultyEnrollee [facultyId=" + facultyId + ", enrolleeId=" + enrolleeId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", city=" + city + ", region=" + region + ", summaryPoints="
                + summaryPoints + "]";
    }

    /**
     * class for build class FacultyEnrollee
     */
    public static class Builder{

        private int id;
        private int facultyId;
        private int enrolleeId;
        private String firstName;
        private String lastName;
        private String city;
        private String region;
        private Integer summaryPoints;


        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setFacultyId(int facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setEnrolleeId(int enrolleeId) {
            this.enrolleeId = enrolleeId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder setsummaryPoints(Integer summaryPoints) {
            this.summaryPoints = summaryPoints;
            return this;
        }

        public FacultyEnrollee build() {
            FacultyEnrollee facultyEnrollee = new FacultyEnrollee();
            facultyEnrollee.setId(id);
            facultyEnrollee.setFacultyId(facultyId);
            facultyEnrollee.setEnrolleeId(enrolleeId);
            facultyEnrollee.setFirstName(firstName);
            facultyEnrollee.setLastName(lastName);
            facultyEnrollee.setCity(city);
            facultyEnrollee.setRegion(region);
            facultyEnrollee.setsummaryPoints(summaryPoints);

            return facultyEnrollee;
        }
    }

}
