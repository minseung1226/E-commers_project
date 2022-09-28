package kms.project.vo;

public class BasketVO {

    private int basket_code ; //장바구니 인덱스
    private int user_code ; // 회원 인덱스
    private int detail_code; //상품 상세 인덱스
    private int basket_quantity; // 수량


    public int getBasket_code() {
        return basket_code;
    }

    public void setBasket_code(int basket_code) {
        this.basket_code = basket_code;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public int getDetail_code() {
        return detail_code;
    }

    public void setDetail_code(int detail_code) {
        this.detail_code = detail_code;
    }

    public int getBasket_quantity() {
        return basket_quantity;
    }

    public void setBasket_quantity(int basket_quantity) {
        this.basket_quantity = basket_quantity;
    }
}
