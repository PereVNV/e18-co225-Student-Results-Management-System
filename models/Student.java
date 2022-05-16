import java.util.ArrayList;
import java.util.List;

public class Student {
    private String fullName;
    private String regNo;
    private boolean isAdmin=false;
    private String email;
    private int rank;
    private double currentGPA;
    private String departmentName;
    private HashMap<Course,String> grades=new HashMap<>();
    
    public Student(String fullName,String regNo,boolean isAdmin){
        this.fullName=fullName;
        this.regNo=regNo;
        this.isAdmin=isAdmin;
    }

    public String getfullName(){
        return this.fullName;
    }

    public String getregNo(){
        return this.regNo;
    }

    public boolean getisAdmin(){
        return this.isAdmin;
    }

    public String getemail(){
        return this.email;
    }

    public int getrank(){
        return this.rank;
    }

    public double getcurrentGPA(){
        return this.currentGPA;
    }

    public String departmentName(){
        return this.departmentName;
    }

    public void setfullName(String fullName){
        this.fullName=fullName;
    }

    public void setregNo(String regNo){
        this.regNo=regNo;
    }

    public void setisAdmin(boolean isAdmin){
        this.isAdmin=isAdmin;
    }

    public void setemail(String email){
        this.email=email;
    }

    public void setrank(){
        this.rank=rank;
    }

    public void setcurrentGPA(){
        this.currentGPA=currentGPA;
    }

    public void setdepartmentName(String departmentName){
        this.departmentName=departmentName;
    }
    public double calculateGPA(String departmentName,HashMap<Course,String> marks){
        boolean departmentExists=false;
        this.departmentName=departmentName;
        this.grades=marks;
        double currGPA=0.0;
        int totcredits=0;
        for(Department d:Departments){
            if(d.getdepartmentName().equalsIgnoreCase(departmentName)){
                departmentExists=true;
                break;
            }
        }

        Iterator marksIterator=marks.entrySet().iterator();
        if(departmentExists){
            while(marksIterator.hasNext()){
                Map.Entry mp=(Map.Entry)marksIterator.next();
                String grade=(String)mp.getValue();
                int credits=mp.getKey().getcourseCredits();
                totcredits+=credits;
                switch(grade){
                    case "A+":
                            currGPA+=(4.0*credits);
                            break;
                    case "A":
                            currGPA+=(4.0*credits);
                            break;
                    case "A-":
                            currGPA+=(3.7*credits);
                            break;
                    case "B+":
                            currGPA+=(3.3*credits);
                            break;
                    case "B":
                            currGPA+=(3.0*credits);
                            break;
                    case "B-":
                            currGPA+=(2.7*credits);
                            break;
                    case "C+":
                            currGPA+=(2.3*credits);
                            break;
                    case "C":
                            currGPA+=(2.0*credits);
                            break;
                    case "C-":
                            currGPA+=(1.7*credits);
                            break;
                    case "D+":
                            currGPA+=(1.3*credits);
                            break;
                    case "D":
                            currGPA+=(1.0*credits);
                            break;
                    default:
                            currGPA+=(0.0*credits);
                            break;
                }
            }

            currentGPA=currGPA/totcredits;
            return currentGPA;
        }
    }
}