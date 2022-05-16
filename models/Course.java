public class Course {
    private String courseName,courseId;
    private int courseCredits;

    public Course(String courseName, String courseId,String courseCredits) {
        this.courseName=courseName;
        this.courseId=courseId;
        this.courseCredits=courseCredits;
    }

    public String getcourseName(){
        return this.courseName;
    }

    public void setcourseName(String coureseName){
        this.courseName=courseName;
    }

    public String getcourseId(){
        return this.courseId;
    }

    public void setcourseId(String courseId){
        this.courseId=courseId;
    }

    public int getcourseCredits(){
        return this.courseCredits;
    }

    public void setcourseCredits(int courseCredits){
        this.courseCredits=courseCredits;
    }
}
