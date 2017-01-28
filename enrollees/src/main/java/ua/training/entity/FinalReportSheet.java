package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class FinalReportSheet  extends Entity{
    private static final long serialVersionUID = -4678495797329352441L;

    String firstName;
    String lastName;
    String city;
    String region;
    String statusOfEducation;
    Integer summaryPoints;

    public FinalReportSheet(String firstName, String lastName, String city, String region,
                            Integer summaryPoints, String statusOfEducation) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.region = region;
        this.summaryPoints = summaryPoints;
        this.statusOfEducation = statusOfEducation;


    }
    public FinalReportSheet(Integer id, String firstName, String lastName, String city, String region,
                            Integer facultyId, Integer summaryPoints) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.region = region;
        this.summaryPoints = summaryPoints;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getSummaryPoints() {
        return summaryPoints;
    }
    public void setSummaryPoints(Integer summaryPoints) {
        this.summaryPoints = summaryPoints;
    }


    public String getStatusOfeducation() {
        return statusOfEducation;
    }
    public void setStatusOfeducation(String statusOfeducation) {
        this.statusOfEducation = statusOfeducation;
    }
    @Override
    public String toString() {
        return "FinalReportSheet [id="  + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
                + ", region=" + region + ", facultyId="  + ", summaryPoints=" + summaryPoints + "]";
    }


}
