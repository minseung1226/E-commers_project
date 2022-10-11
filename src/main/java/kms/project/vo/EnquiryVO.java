package kms.project.vo;

public class EnquiryVO {
    private int enquiry_code; // 문의사항 인덱스
    private String user_id ; // 회원 id
    private int enquiry_status; // 질문 상태
    private String enquiry_qdate,enquiry_adate,enquiry_question,enquiry_answer,enquiry_title;
        //          질문날짜        답변날짜        질문              답변          질문 제목

    public int getEnquiry_code() {
        return enquiry_code;
    }

    public void setEnquiry_code(int enquiry_code) {
        this.enquiry_code = enquiry_code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getEnquiry_status() {
        return enquiry_status;
    }

    public void setEnquiry_status(int enquiry_status) {
        this.enquiry_status = enquiry_status;
    }

    public String getEnquiry_qdate() {
        return enquiry_qdate;
    }

    public void setEnquiry_qdate(String enquiry_qdate) {
        this.enquiry_qdate = enquiry_qdate;
    }

    public String getEnquiry_adate() {
        return enquiry_adate;
    }

    public void setEnquiry_adate(String enquiry_adate) {
        this.enquiry_adate = enquiry_adate;
    }

    public String getEnquiry_question() {
        return enquiry_question;
    }

    public void setEnquiry_question(String enquiry_question) {
        this.enquiry_question = enquiry_question;
    }

    public String getEnquiry_answer() {
        return enquiry_answer;
    }

    public void setEnquiry_answer(String enquiry_answer) {
        this.enquiry_answer = enquiry_answer;
    }

    public String getEnquiry_title() {
        return enquiry_title;
    }

    public void setEnquiry_title(String enquiry_title) {
        this.enquiry_title = enquiry_title;
    }
}
