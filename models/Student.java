import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Student {
    private String fullName;
    private String regNo;
    private boolean isAdmin = false;
    private String email;
    private int rank;
    private double currentGPA;
    private String departmentName;
    private HashMap<Course, String> courseGrades = new HashMap<>();
    private List<Department> departments = new ArrayList<Department>();

    String finalMessage = "";
    List<String> grades = new ArrayList<String>();

    Set<String> distinct = new HashSet<>(grades);

    public Student(String fullName, String regNo, boolean isAdmin) {
        this.fullName = fullName;
        this.regNo = regNo;
        this.isAdmin = isAdmin;
    }

    public String getfullName() {
        return this.fullName;
    }

    public String getregNo() {
        return this.regNo;
    }

    public boolean getisAdmin() {
        return this.isAdmin;
    }

    public String getemail() {
        return this.email;
    }

    public int getrank() {
        return this.rank;
    }

    public double getcurrentGPA() {
        return this.currentGPA;
    }

    public String departmentName() {
        return this.departmentName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public void setregNo(String regNo) {
        this.regNo = regNo;
    }

    public void setisAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setrank(int rank) {
        this.rank = rank;
    }

    public void setcurrentGPA(double currentGPA) {
        this.currentGPA = currentGPA;
    }

    public void setdepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public HashMap<Course, String> getGrades() {
        return this.courseGrades;
    }

    // Method to calculate GPA when final grades are given
    public double calculateGPA(String departmentName, HashMap<Course, String> marks) {
        boolean departmentExists = false;
        this.departmentName = departmentName;
        this.courseGrades = marks;
        double currGPA = 0.0;
        int totcredits = 0;
        for (Department d : departments) {
            if (d.getdepartmentName().equalsIgnoreCase(departmentName)) {
                departmentExists = true;
                break;
            }
        }

        Iterator<Entry<Course, String>> marksIterator = marks.entrySet().iterator();
        if (departmentExists) {
            while (marksIterator.hasNext()) {
                Map.Entry<Course, String> mp = (Map.Entry<Course, String>) marksIterator.next();
                String grade = (String) mp.getValue();
                int credits = ((Course) mp.getKey()).getcourseCredits();
                totcredits += credits;
                switch (grade) {
                    case "A+":
                        currGPA += (4.0 * credits);
                        break;
                    case "A":
                        currGPA += (4.0 * credits);
                        break;
                    case "A-":
                        currGPA += (3.7 * credits);
                        break;
                    case "B+":
                        currGPA += (3.3 * credits);
                        break;
                    case "B":
                        currGPA += (3.0 * credits);
                        break;
                    case "B-":
                        currGPA += (2.7 * credits);
                        break;
                    case "C+":
                        currGPA += (2.3 * credits);
                        break;
                    case "C":
                        currGPA += (2.0 * credits);
                        break;
                    case "C-":
                        currGPA += (1.7 * credits);
                        break;
                    case "D+":
                        currGPA += (1.3 * credits);
                        break;
                    case "D":
                        currGPA += (1.0 * credits);
                        break;
                    default:
                        currGPA += (0.0 * credits);
                        break;
                }
            }

            currentGPA = currGPA / totcredits;

        }
        return currentGPA;
    }

    // Method to calculate required marks for a particular course When continuous
    // assessment (quizzes, assignments, projects ) marks are entered for a
    // particular course for the expected grade of that course
    public double calculateRequiredMarks(int quizzes, int assignments, int projects, String expectedGrade) {
        double totSubMarks = quizzes + assignments + projects;
        double minExpectedMarks = 0.0;
        double requiredmarks = 0.0;
        switch (expectedGrade) {
            case "A+":
                minExpectedMarks = 85.0;
                break;
            case "A":
                minExpectedMarks = 75.0;
                break;
            case "A-":
                minExpectedMarks = 70.0;
                break;
            case "B+":
                minExpectedMarks = 65.0;
                break;
            case "B":
                minExpectedMarks = 60.0;
                break;
            case "B-":
                minExpectedMarks = 55.0;
                break;
            case "C+":
                minExpectedMarks = 50.0;
                break;
            case "C":
                minExpectedMarks = 45.0;
                break;
            case "C-":
                minExpectedMarks = 40.0;
                break;
            case "D+":
                minExpectedMarks = 35.0;
                break;
            case "D":
                minExpectedMarks = 30.0;
                break;
            default:
                minExpectedMarks = 0.0;
                break;
        }
        if (minExpectedMarks > totSubMarks) {
            requiredmarks = minExpectedMarks - totSubMarks;
        } else {
            requiredmarks = 0.0;
        }
        return requiredmarks;
    }
    // ******************************************************************************************************//
    // ******************************************************************************************************//
    Courses courses = new Courses();
    List<Course> newCourses = courses.getCourses();

    public List<String> calnesgrade(List<Course> newCourses, double expectedGPA) {
        List<String> gds = new ArrayList<String>();
        int totc = 0;
        String necessaryGrade = "";
        int numCourse = 0;
        for (Course c : newCourses) {
            totc += c.getcourseCredits();
            ++numCourse;
        }
        double exp = expectedGPA * totc;
        double agpa = exp / numCourse;
        for (Course c : newCourses) {
            double div = agpa / c.getcourseCredits();
            if (div > 4) {
                necessaryGrade = "A";
                gds.add(necessaryGrade);
            } else if (div > 3.7 && div <= 4.0) {
                necessaryGrade = "A";
                gds.add(necessaryGrade);
            } else if (div > 3.3 && div <= 3.7) {
                necessaryGrade = "A-";
                gds.add(necessaryGrade);
            } else if (div > 3.0 && div <= 3.3) {
                necessaryGrade = "B+";
                gds.add(necessaryGrade);
            } else if (div > 2.7 && div <= 3.0) {
                necessaryGrade = "B";
                gds.add(necessaryGrade);
            } else if (div > 2.3 && div <= 2.7) {
                necessaryGrade = "B-";
                gds.add(necessaryGrade);
            } else if (div > 2.0 && div <= 2.3) {
                necessaryGrade = "C+";
                gds.add(necessaryGrade);
            } else if (div > 1.7 && div <= 2.0) {
                necessaryGrade = "C";
                gds.add(necessaryGrade);
            } else if (div > 1.3 && div <= 1.7) {
                necessaryGrade = "C-";
                gds.add(necessaryGrade);
            } else if (div > 1.0 && div <= 1.3) {
                necessaryGrade = "D+";
                gds.add(necessaryGrade);
            } else if (div > 0.0 && div <= 1.0) {
                necessaryGrade = "D";
                gds.add(necessaryGrade);
            } else {
                necessaryGrade = "E";
                gds.add(necessaryGrade);
            }
        }
        return gds;
    }
}
