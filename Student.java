import java.util.ArrayList;

public class Student extends Course {
    public String fullname,mobile,address;
    public int id,stage;

    Student(){}
    Student(int id, String fullname, String address, int stage, String mobile){
        setId(id);
        setFullname(fullname);
        setAddress(address);
        setStage(stage);
        setMobile(mobile);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public static boolean id_taken(int id, ArrayList<Student> students){
        for(Student student: students){
            if(id == student.getId()){
                return true;
            }
        }
        return false;
    }

    public static void update_student_data(String path, ArrayList<Student> students){
        String data = "";
        for (int i = 0; i < students.size(); i++) {
            if(i != students.size()-1)
                data +=  students.get(i).toString() + "\n";
            else
                data +=  students.get(i).toString();
        }
        Writer.clear_data(path);
        Writer.import_data(path, data);
    }

    @Override
    public String toString(){
        return getId()+ "," +getFullname() + "," +getAddress() + "," +getStage() + "," + getMobile() + "," + super.toString();
    }

}
