package kms.project.vo;

public class OrderViewVO {
    private int order_code ,user_code,order_payment,review_status,order_quantity,detail_code,product_code;
    private String order_number,order_date,order_name,order_phone,order_addr1,order_addr2,order_request,size,color,
                    product_name,product_img1,order_delivery;

    public int getDetail_code() {
        return detail_code;
    }

    public void setDetail_code(int detail_code) {
        this.detail_code = detail_code;
    }

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public String getOrder_delivery() {
        return order_delivery;
    }

    public void setOrder_delivery(String order_delivery) {
        this.order_delivery = order_delivery;
    }

    public int getOrder_code() {
        return order_code;
    }

    public void setOrder_code(int order_code) {
        this.order_code = order_code;
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

    public int getReview_status() {
        return review_status;
    }

    public void setReview_status(int review_status) {
        this.review_status = review_status;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img1() {
        return product_img1;
    }

    public void setProduct_img1(String product_img1) {
        this.product_img1 = product_img1;
    }
}
