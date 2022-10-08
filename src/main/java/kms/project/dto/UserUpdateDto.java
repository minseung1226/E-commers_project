package kms.project.dto;

public class UserUpdateDto {
    private String user_name , user_birth,user_phone,user_addr1,user_addr2,user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_addr1() {
        return user_addr1;
    }

    public void setUser_addr1(String user_addr1) {
        this.user_addr1 = user_addr1;
    }

    public String getUser_addr2() {
        return user_addr2;
    }

    public void setUser_addr2(String user_addr2) {
        this.user_addr2 = user_addr2;
    }
}
