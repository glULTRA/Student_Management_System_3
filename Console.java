import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    static String filename = "students.csv";

	public static void main(String[] args) throws Exception 
    {
        // Students
		ArrayList<Student> students =new ArrayList<Student>();
        Reader.load_from_file(students, filename);

        int option = -1;
        boolean is_exit = false;
        Scanner read = new Scanner(System.in);
        while (!is_exit) 
        {
            try {
                System.out.println("0- Exit :");
                System.out.println("1- Add new Student :");
                System.out.println("2- Edit :");
                System.out.println("3- Delete :");
                System.out.println("4- Show information :");
                System.out.println("5- Search :");
                System.out.println("Choose option :");
                option = read.nextInt();
            } catch (Exception e) {

            }
            
            switch (option) {
                case 0:
                    // exit
                    is_exit = true;
                    break;
                case 1:
                    // add new student
                    System.out.println("Enter ID:");
                    int id = read.nextInt();
                    while (!Student.id_taken(id, students)) {
                        System.out.println("ID is taken try a new one :");
                        id=read.nextInt();
                    }
                    System.out.println("Enter full name:");
                    String fullname = read.next();
                    System.out.println("Enter Address:");
                    String address = read.next();
                    System.out.println("Enter Stage:");
                    int stage = read.nextInt();
                    System.out.println("Enter Phone Number:");
                    String phone_number = read.next();

                    System.out.println("How many courses you want to add ?");
                    int course_option = read.nextInt();
                    while ((course_option > 5)) {
                        System.out.println("Maximum course u can add is 5 !\n Enter course numbers again :");
                        course_option = read.nextInt();
                    }
                    String courses[] = new String[5];
                    for(int i = 0; i < courses.length; i++){
                        if(course_option > i){
                            System.out.println("Enter course " + (i+1) + " :");
                            courses[i] = read.next();
                        }
                    }
                    Student student = new Student(id, fullname, address, stage, phone_number);
                    student.setCourses(courses);
                    Writer.import_data(filename, "\n" + student.toString());
                    students.add(student);
                    break;
                case 2:
                    // edit student
                    System.out.println("Which id you want to edit ?");
                    int selected_id = read.nextInt();
                    for (int i =0 ; i < students.size(); i++) {
                        if(selected_id == students.get(i).getId()){
                            System.out.println("Enter new full name:");
                            fullname = read.next();
                            System.out.println("Enter new Address:");
                            address = read.next();
                            System.out.println("Enter new Stage:");
                            stage = read.nextInt();
                            System.out.println("Enter new Phone Number:");
                            phone_number = read.next();

                            students.get(i).setFullname(fullname);
                            students.get(i).setAddress(address);
                            students.get(i).setMobile(phone_number);
                            students.get(i).setStage(stage);

                            Student.update_student_data(filename, students);
                           
                            break;
                        }
                    }
                    
                    break;
                case 3:
                    //delete student
                    System.out.println("Which id do u want to delete ?");
                    selected_id = read.nextInt(); 
                    for (int  i = 0; i < students.size(); i++) {
                        if(selected_id == students.get(i).getId()){
                            students.remove(i);
                            Student.update_student_data(filename, students);

                            break;
                        }
                    }
                    break;
                case 4:
                    // Show all students
                    for (Student st : students) {
                        System.out.println(st);
                    }
                    break;
                case 5:
                    System.out.println("Search by Name or Phone :");
                    String search = read.next().toLowerCase();
                    
                    for (Student st : students) {
                        if (search.equals(st.getFullname().toLowerCase()) || search.equals(st.getMobile().toLowerCase())) {
                            System.out.println(st);
                        }
                    }

                    break;
                default:
                    break;
            }
        }

	}	
}