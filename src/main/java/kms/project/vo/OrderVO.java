package kms.project.vo;

public class OrderVO { //구매정보
    private int order_code ;
    private int detail_code ; //상품상세 인덱스
    private int user_code; //회원 인덱스
    private int order_payment; // 가격
    private String order_date , order_name,order_phone,order_addr1,order_addr2,order_request;
    //              구매날짜      구매자      구매자 번호     주소        주소          요청사항


    public int getOrder_code() {
        return order_code;
    }

    public void setOrder_code(int order_code) {
        this.order_code = order_code;
    }

    public int getDetail_code() {
        return detail_code;
    }

    public void setDetail_code(int detail_code) {
        this.detail_code = detail_code;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public int getOrder_payment() {
        return order_payment;
    }

    public void setOrder_payment(int order_payment) {
        this.order_payment = order_payment;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone;
    }

    public String getOrder_addr1() {
        return order_addr1;
    }

    public void setOrder_addr1(String order_addr1) {
        this.order_addr1 = order_addr1;
    }

    public String getOrder_addr2() {
        return order_addr2;
    }

    public void setOrder_addr2(String order_addr2) {
        this.order_addr2 = order_addr2;
    }

    public String getOrder_request() {
        return order_request;
    }

    public void setOrder_request(String order_request) {
        this.order_request = order_request;
    }
}
