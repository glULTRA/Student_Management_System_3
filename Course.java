import java.util.ArrayList;

public class Course 
{
    // Course limit is 5
    String courses[] = {"null", "null", "null", "null", "null"};
    private int no_student;
    private String course_name;
    static final String stage_1_courses[] = {"FIS", "Cpp", "AutoCad", "Computer_Organization", "English"};
    static final String stage_2_courses[] = {"Photoshop", "Java", "AdobeXD", "Web-design", "Assembly"};
    static final String stage_3_courses[] = {"Network", "Data_Structures", "Adobe_after_effect", "PHP", "SQL"};
    static final String stage_4_courses[] = {"Cyber_Security", "IS", "Blender", "Machine_Learning", "Oracle"};

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

    public static void update_courses(String file, ArrayList<Course> courses ){
        String data = "";
        for (int i = 0; i < courses.size(); i++) {
            if(i != courses.size()-1)
                data +=  courses.get(i).getNoStudent() + "," + courses.get(i).getCourseName() + "\n";
            else
                data +=  courses.get(i).getNoStudent() + "," + courses.get(i).getCourseName();
        }   
        Writer.clear_data(file);
        Writer.import_data(file, data);

    }

    public String  toString(){
        return courses[0] + "," +courses[1] + "," + courses[2] + "," + courses[3] + "," + courses[4];
    }
}
