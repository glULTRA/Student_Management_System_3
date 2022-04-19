public class Course 
{
    // Course limit is 5
    String courses[] = {"null", "null", "null", "null", "null"};
    static final String stage_1_courses[] = {"FIS", "C++", "AutoCad", "Computer Organization", "English"};
    static final String stage_2_courses[] = {"Photoshop", "Java", "AdobeXD", "Web-design", "Assembly"};
    static final String stage_3_courses[] = {"Network", "Data Structures", "Adobe after effect", "Data base", "SQL"};
    static final String stage_4_courses[] = {"Network Advanced", "IS", "Blender", "Machine Learning", "Oracle"};

    public void setCourses(String[] courses){
        this.courses = courses;
    }

    

    public String  getCourses(){
        return courses[0] + "," +courses[1] + "," + courses[2] + "," + courses[3] + "," + courses[4];
    }

}
