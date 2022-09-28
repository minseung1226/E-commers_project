package kms.project.vo;

public class DetailVO {
    private int detail_code ;   // 상품 상세 인덱스
    private int product_code ;  // 상품 인덱스
    private String size ;   // 사이즈
    private String color ;  // 색상

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
}
