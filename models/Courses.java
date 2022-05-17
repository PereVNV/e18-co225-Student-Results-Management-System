import java.util.ArrayList;
import java.util.List;

public class Courses {
    private List<Course> courses = new ArrayList<Course>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(Course course) {
        for (Course c : courses) {
            if (c.getcourseId().equalsIgnoreCase(course.getcourseId())) {
                c.setcourseName(course.getcourseName());
                c.setcourseCredits(course.getcourseCredits());
            }
        }
    }

    public void deleteCourse(Course course) {
        for (Course c : courses) {
            if (c.getcourseId().equalsIgnoreCase(course.getcourseId())) {
                courses.remove(c);
            }
        }
    }

    public int getnumberOfCourses() {
        return courses.size();
    }
}
