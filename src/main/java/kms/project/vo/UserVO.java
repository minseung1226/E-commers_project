package kms.project.vo;


public class UserVO {
    private int user_code; // 유저 인덱스
    private int user_status; // 회원 상태

    private int user_payment; // 총 결제 금액
    private String user_id, user_pw,user_pw2,user_name,user_phone,user_email,user_addr1,user_addr2,user_regdate,user_con_date , user_birth,user_sex;
    //              아이디   비밀번호  비번체크       회원명     전화번호    이메일      주소      주소      가입날짜        최근 접속날짜    생년월일     성별


    public int getUser_payment() {
        return user_payment;
    }

    public void setUser_payment(int user_payment) {
        this.user_payment = user_payment;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_pw2() {
        return user_pw2;
    }

    public void setUser_pw2(String user_pw2) {
        this.user_pw2 = user_pw2;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
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

    public String getUser_regdate() {
        return user_regdate;
    }

    public void setUser_regdate(String user_regdate) {
        this.user_regdate = user_regdate;
    }

    public String getUser_con_date() {
        return user_con_date;
    }

    public void setUser_con_date(String user_con_date) {
        this.user_con_date = user_con_date;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
}
