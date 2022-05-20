import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Students {
    List<Student> students = new ArrayList<Student>();

    public void addStudent(Student stu) {
        students.add(stu);
    }

    public int getRank(Student stu) {
        Collections.sort(students, new sortbyGPA());
        int rank = 0;
        for (Student s : students) {
            if (s.getregNo().equalsIgnoreCase(stu.getregNo())) {
                rank = students.indexOf(stu);
            }
        }
        return rank;
    }
}

class sortbyGPA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        return Double.compare(o1.getcurrentGPA(), o2.getcurrentGPA());
    }

}
