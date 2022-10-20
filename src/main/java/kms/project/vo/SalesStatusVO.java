package kms.project.vo;

public class SalesStatusVO {
    private String product_name;
    private String product_img1;
    private String division_mType;
    private String division_lType;
    private String order_date;
    private int order_quantity;
    private int order_payment;
    private int product_code;

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
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

    public String getDivision_mType() {
        return division_mType;
    }

    public void setDivision_mType(String division_mType) {
        this.division_mType = division_mType;
    }

    public String getDivision_lType() {
        return division_lType;
    }

    public void setDivision_lType(String division_lType) {
        this.division_lType = division_lType;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public int getOrder_payment() {
        return order_payment;
    }

    public void setOrder_payment(int order_payment) {
        this.order_payment = order_payment;
    }
}
