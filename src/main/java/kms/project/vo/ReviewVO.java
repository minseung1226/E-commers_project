package kms.project.vo;

public class ReviewVO {
    private int review_code ; // 리뷰 인덱스
    private int user_code ; // 회원 인덱스
    private String review_content; // 리뷰내용
    private int review_score; // 별점

    public int getReview_code() {
        return review_code;
    }

    public void setReview_code(int review_code) {
        this.review_code = review_code;
    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public int getReview_score() {
        return review_score;
    }

    public void setReview_score(int review_score) {
        this.review_score = review_score;
    }
}
