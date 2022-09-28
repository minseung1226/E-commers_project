package kms.project.vo;

public class ProductVO {
    private int product_code ;// 상품 인덱스
    private int division_code ; //분류 인덱스
    private int product_price ; // 상품 가격
    private int product_count ; //판매량
    private String product_name,product_img1,product_img2,product_img3,product_detail,product_date;
    //              상품이름        상품이미지                               상세설명        상품 등록 날짜

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public int getDivision_code() {
        return division_code;
    }

    public void setDivision_code(int division_code) {
        this.division_code = division_code;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
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

    public String getProduct_img2() {
        return product_img2;
    }

    public void setProduct_img2(String product_img2) {
        this.product_img2 = product_img2;
    }

    public String getProduct_img3() {
        return product_img3;
    }

    public void setProduct_img3(String product_img3) {
        this.product_img3 = product_img3;
    }

    public String getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(String product_detail) {
        this.product_detail = product_detail;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }
}
