package kms.project.vo;

public class Order_completedVO {
    private int oc_code;
    private int order_code;
    private int detail_code;
    private int oc_quantity;

    private int review_status;

    public int getReview_status() {
        return review_status;
    }

    public void setReview_status(int review_status) {
        this.review_status = review_status;
    }

    public int getOc_code() {
        return oc_code;
    }

    public void setOc_code(int oc_code) {
        this.oc_code = oc_code;
    }

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

    public int getOc_quantity() {
        return oc_quantity;
    }

    public void setOc_quantity(int oc_quantity) {
        this.oc_quantity = oc_quantity;
    }
}
