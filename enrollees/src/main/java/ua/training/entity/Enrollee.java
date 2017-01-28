package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * This class is the bean for Enrollee entity.
 */
public class Enrollee  extends Entity{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6230795066664903440L;

    /**
     * Id of Enrollee.
     */
    private int id;
    /**
     * City of enrollee.
     */
    private String city;
    /**
     * Region of Enrollee.
     */
    private String region;
    /**
     * User id of Enrollee.
     */
    private int userId;
    /**
     * Status of enrollee.
     */
    private boolean blockedStatus;


    public Enrollee() {

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

    /** Getting city.
     * @return String
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for field city.
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getting region.
     * @return String
     */
    public String getRegion() {
        return region;
    }

    /**Setter for field region.
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Getter for the user id field.
     * @return int
     */
    public int getUserId() {
        return userId;
    }


    /**
     * Setter for user id field.
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the status of the enrollee.
     * @return boolean
     */
    public boolean isBlockedStatus() {
        return blockedStatus;
    }

    /**
     * Setter for the field blockStatus.
     * @param blockedStatus
     */
    public void setBlockedStatus(boolean blockedStatus) {
        this.blockedStatus = blockedStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollee enrollee = (Enrollee) o;

        if (id != enrollee.id) return false;
        if (userId != enrollee.userId) return false;
        if (!city.equals(enrollee.city)) return false;
        return region.equals(enrollee.region);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + city.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Enrollee [id=" + id + ", city=" + city + ", region=" + region + ", userId=" + userId
                + ", blockedStatus=" + blockedStatus + "]";
    }

    /**
     * class for build class Enrollee
     */
    public static class Builder{
        private int id;
        private String city;
        private String region;
        private int userId;
        private boolean blockedStatus;

        public Builder setId(int id) {
            this.id = id;
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

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setBlockedStatus(boolean blockedStatus) {
            this.blockedStatus = blockedStatus;
            return this;
        }

        public Enrollee build(){
            Enrollee enrollee = new Enrollee();
            enrollee.setId(id);
            enrollee.setCity(city);
            enrollee.setRegion(region);
            enrollee.setUserId(userId);
            enrollee.setBlockedStatus(blockedStatus);
            return enrollee;

        }


    }

}
