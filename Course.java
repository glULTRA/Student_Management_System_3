import java.util.ArrayList;

public class Course 
{
    // Course limit is 5
    String courses[] = {"null", "null", "null", "null", "null"};
    static final String stage_1_courses[] = {"FIS", "C++", "AutoCad", "Computer Organization", "English"};
    static final String stage_2_courses[] = {"Photoshop", "Java", "AdobeXD", "Web-design", "Assembly"};
    static final String stage_3_courses[] = {"Network", "Data Structures", "Adobe after effect", "Data base", "SQL"};
    static final String stage_4_courses[] = {"Network Advanced", "IS", "Blender", "Machine Learning", "Oracle"};
    public static ArrayList<String> course_collect_data = new ArrayList<String>();

    public void setCourses(String[] courses){
        this.courses = courses;
        if(course_collect_data.isEmpty()){
            for (String course : courses) {
                course_collect_data.add(course);
            }
            return;
        }
        for (String course : courses) 
        {
            for (String alive_course : course_collect_data) {
                if(course == alive_course){
                    course_collect_data.add(course);
                }
            }
        }
        
    }

    public static String getCourseDataList(int index){
        return course_collect_data.get(index);
    }

    public String  toString(){
        return courses[0] + "," +courses[1] + "," + courses[2] + "," + courses[3] + "," + courses[4];
    }
}
