package kms.project.service;

import kms.project.aop.Trace;
import kms.project.repository.OrderRepository;
import kms.project.repository.ReviewRepository;
import kms.project.vo.ReviewVO;
import kms.project.vo.ReviewViewVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Trace
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final OrderRepository orderRepository;

    public ReviewService(ReviewRepository reviewRepository, OrderRepository orderRepository) {
        this.reviewRepository = reviewRepository;
        this.orderRepository = orderRepository;
    }
    @Trace
    @Transactional
    public void insert_review(ReviewVO review){
        reviewRepository.insert_review(review);
        orderRepository.update_status(review.getOrder_code());
    }
    @Trace
    public ReviewViewVO find_review_view(int order_code){
        return reviewRepository.find_review_view(order_code);
    }
    @Trace
    public void update_review(ReviewVO review){
        reviewRepository.update_review(review);
    }
    @Trace
    public List<ReviewVO> selectList(int product_code){
        return reviewRepository.selectList(product_code);
    }
}
