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

    /**
     *Getter for SubjectId.
     * @return int
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Setter for SubjectId.
     * @param subjectId
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     *Getter for FacultyId.
     * @return int
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultySubjects that = (FacultySubjects) o;

        if (subjectId != that.subjectId) return false;
        return facultyId == that.facultyId;

    }

    @Override
    public int hashCode() {
        int result = subjectId;
        result = 31 * result + facultyId;
        return result;
    }

    @Override
    public String toString() {
        return "FacultySubjects{" +
                "subjectId=" + subjectId +
                ", facultyId=" + facultyId +
                '}';
    }

    /**
     * class for build class FacultySubjects
     */
    public static class Builder{

        private int subjectId;
        private int facultyId;

        public Builder setSubjectId(int subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setFacultyId(int facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public FacultySubjects build() {
            FacultySubjects facultySubjects = new FacultySubjects();
            facultySubjects.setSubjectId(subjectId);
            facultySubjects.setFacultyId(facultyId);

            return facultySubjects;

        }


    }


}
