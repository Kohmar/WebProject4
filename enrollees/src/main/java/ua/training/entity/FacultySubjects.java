package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * Faculty subjects entity. The main purpose is to tell what subjects are need to the Enrollee.
 */
public class FacultySubjects extends Entity{
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -7922018570068748685L;

    /**
     * id of subject.
     */
    private int subjectId;
    /**
     * id of faculty.
     */
    private int facultyId;

    public FacultySubjects() {

    }

    public FacultySubjects(Subject subject, Faculty faculty) {
        this(subject.getId(), faculty.getId());
    }

    public FacultySubjects(int subjectId, int facultyId) {
        super();
        this.subjectId = subjectId;
        this.facultyId = facultyId;
    }


    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    /**
     * Setter for FacultyId.
     * @param facultyId
     */
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

}
