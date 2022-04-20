import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader 
{
    public static String reader(String path){
        String data = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int i;
            while((i = reader.read()) != -1){
                data += (char)i;
            }
            return data;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "File is empty!");
            System.out.println("File is empty !");
            return null;
        }
    }
    
    public static boolean isEmpty(String path)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            if (reader.readLine() == null) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "File is empty!");
            System.out.println("File is empty !");
            Writer.import_data(path, null);
            return true;
        }
    }

    public static void load_from_file(ArrayList<Student> students, String student_file)
    {
        try {
            String student_data = reader(student_file);
            String []student_data_array = student_data.split("[, \n]");
            int j = 0;
            for (int i = 0; i < student_data_array.length/10; i++) 
            {
                Student student = new Student();
                String courses[] = new String[5];
                student.setId(Integer.parseInt(student_data_array[j++]));
                student.setFullname(student_data_array[j++]);
                student.setAddress(student_data_array[j++]);
                student.setStage(Integer.parseInt(student_data_array[j++]));
                student.setMobile(student_data_array[j++]);
                courses[0] = student_data_array[j++];
                courses[1] = student_data_array[j++];
                courses[2] = student_data_array[j++];
                courses[3] = student_data_array[j++];
                courses[4] = student_data_array[j++];
                student.setCourses(courses);
                students.add(student);
            }

        } catch (Exception e) {

        }
    }

    public static void load_course_file(ArrayList<Course> courses,String course_file){
        try {
            String course_data = reader(course_file);
            String []course_data_array = course_data.split(",");
            int j = 0;
            for (int i = 0; i < course_data_array.length/2; i++) 
            {
                Course course = new Course();
                course.setCourseName(course_data_array[j++]);
                course.setNoStudent(Integer.parseInt(course_data_array[j++]));
                courses.add(course);
            }

        } catch (Exception e) {

        }
    }
    
    
}
