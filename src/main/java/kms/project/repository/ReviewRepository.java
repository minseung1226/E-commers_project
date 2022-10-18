package kms.project.repository;

import kms.project.repository.mapper.ReviewMapper;
import kms.project.vo.ReviewVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {
    private final ReviewMapper reviewMapper;

    public ReviewRepository(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public void insert_review(ReviewVO review){
        reviewMapper.insert_review(review);
    }
}
