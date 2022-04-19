public class Course 
{
    // Course limit is 5
    String courses[] = {"null", "null", "null", "null", "null"};
    
    public void setCourses(String[] courses){
        this.courses = courses;
    }

    public String  getCourses(){
        return courses[0] + "," +courses[1] + "," + courses[2] + "," + courses[3] + "," + courses[4];
    }

}
