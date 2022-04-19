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

}
