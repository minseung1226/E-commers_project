package kms.project.repository;

import kms.project.repository.mapper.ReviewMapper;
import kms.project.vo.ReviewVO;
import kms.project.vo.ReviewViewVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {
    private final ReviewMapper reviewMapper;

    public ReviewRepository(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public void insert_review(ReviewVO review){
        reviewMapper.insert_review(review);
    }

    public ReviewViewVO find_review_view(int order_code){
        return reviewMapper.find_review_view(order_code);
    }

    public void update_review(ReviewVO review){
        reviewMapper.update_review(review);
    }

    public List<ReviewVO> selectList(int product_code){
        return reviewMapper.selectList(product_code);
    }
}
