package kms.project.service;

import kms.project.repository.ReviewRepository;
import kms.project.vo.ReviewVO;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void insert_review(ReviewVO review){
        reviewRepository.insert_review(review);
    }
}
