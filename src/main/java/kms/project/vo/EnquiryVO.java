package kms.project.vo;

public class EnquiryVO {
    private int enquiry_code; // 문의사항 인덱스
    private int user_code ; // 회원 인덱스
    private int enquiry_status; // 질문 상태
    private String enquiry_qdate,enquiry_adate,enquriy_question,enquiry_answer;
        //          질문날짜        답변날짜        질문              답변

    public int getEnquiry_code() {
        return enquiry_code;
    }

    public void setEnquiry_code(int enquiry_code) {
        this.enquiry_code = enquiry_code;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
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

    public String getEnquriy_question() {
        return enquriy_question;
    }

    public void setEnquriy_question(String enquriy_question) {
        this.enquriy_question = enquriy_question;
    }

    public String getEnquiry_answer() {
        return enquiry_answer;
    }

    public void setEnquiry_answer(String enquiry_answer) {
        this.enquiry_answer = enquiry_answer;
    }
}
