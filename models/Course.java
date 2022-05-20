public class Course {
    private String courseName, courseId;
    private int courseCredits;
    private double quizzez, assignments, projects;
    private double courseGrade;

    public double getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(double courseGrade) {
        this.courseGrade = courseGrade;
    }

    public double getQuizzez() {
        return quizzez;
    }

    public void setQuizzez(double quizzez) {
        this.quizzez = quizzez;
    }

    public double getAssignments() {
        return assignments;
    }

    public void setAssignments(double assignments) {
        this.assignments = assignments;
    }

    public double getProjects() {
        return projects;
    }

    public void setProjects(double projects) {
        this.projects = projects;
    }

    public Course(String courseName, String courseId, int courseCredits) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseCredits = courseCredits;
    }

    public String getcourseName() {
        return this.courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getcourseId() {
        return this.courseId;
    }

    public void setcourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getcourseCredits() {
        return this.courseCredits;
    }

    public void setcourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }
}
