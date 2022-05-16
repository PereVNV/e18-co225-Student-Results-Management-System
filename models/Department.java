import java.util.HashMap;

public class Department{
    private String departmentName;
    private HashMap<Integer,Courses> semester=new HashMap<>();

    public Department(String departmentName,HashMap<Integer,Courses> semester){
        this.departmentName=departmentName;
        this.semester=semester;
    }

    public String getdepartmentName(){
        return this.departmentName;
    }

    public void setdepartmentName(String departmentName){
        this.departmentName=departmentName;
    }

    public HashMap<Integer,Courses> getSemester(){
        return this.semester;
    }

    public void addSemesterCourses(int semesterNum,Courses courses){
        semester.put(semesterNum,courses);
    }

    public int getnumberOfSemesters(){
        return semester.size();
    }
}