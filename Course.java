import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course 
{
    // Course limit is 5
    String courses[] = {"null", "null", "null", "null", "null"};
    private int no_student;
    private String course_name;
    static final String stage_1_courses[] = {"FIS", "C++", "AutoCad", "Computer Organization", "English"};
    static final String stage_2_courses[] = {"Photoshop", "Java", "AdobeXD", "Web-design", "Assembly"};
    static final String stage_3_courses[] = {"Network", "Data Structures", "Adobe after effect", "Data base", "SQL"};
    static final String stage_4_courses[] = {"Network Advanced", "IS", "Blender", "Machine Learning", "Oracle"};

    Course(){}
    public void setCourses(String[] courses){
        this.courses = courses;
    }

    public void setNoStudent(int no_student){
        this.no_student = no_student;
    }
    public int getNoStudent()
    {
        return this.no_student;
    }

    public String[] getCourses()
    {
        return this.courses;
    }

    public void setCourseName(String course_name){
        this.course_name = course_name;
    }

    public String getCourseName(){
        return this.course_name;
    }

    public String  toString(){
        return courses[0] + "," +courses[1] + "," + courses[2] + "," + courses[3] + "," + courses[4];
    }
}
