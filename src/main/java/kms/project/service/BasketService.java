package kms.project.service;

import kms.project.aop.Trace;
import kms.project.repository.BasketRepository;
import kms.project.repository.DetailRepository;
import kms.project.vo.BasketVO;
import kms.project.vo.BasketViewVO;
import kms.project.vo.DetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Trace
@Slf4j
public class BasketService {
    private final BasketRepository basketRepository;
    private final DetailRepository detailRepository;

    public BasketService(BasketRepository basketRepository, DetailRepository detailRepository) {
        this.basketRepository = basketRepository;
        this.detailRepository = detailRepository;
    }

    @Trace
    @Transactional
    public void add_basket(BasketVO basket, DetailVO detail) {
        Integer detail_code = detailRepository.select_code(detail);

        basket.setDetail_code(detail_code);

        BasketVO findBasket = basketRepository.find_basket(basket);
        if (findBasket == null) {
            basketRepository.insert_basket(basket);
        } else {
            basketRepository.update_basket(basket);
        }
    }

    @Trace
    @Transactional
    public List<BasketViewVO> add_basket_order(BasketVO basket, DetailVO detail) {
        Integer detail_code = detailRepository.select_code(detail);

        basket.setDetail_code(detail_code);

        basketRepository.insert_basket(basket);
        log.info("basket.basket_code={}",basket.getBasket_code());
        String[] codeArray = new String[1];
                codeArray[0]=String.valueOf(basket.getBasket_code());

        return basketRepository.select_choiceBasket_view(codeArray);

    }

    @Trace
    public List<BasketViewVO> select_basketView(int user_code) {
        return basketRepository.select_basketView(user_code);
    }

    @Trace
    public void delete_basket(String basket_check) {
        String[] basket_code = basket_check.split(",");

        basketRepository.delete_basket(basket_code);
    }

    @Trace
    public List<BasketViewVO> select_choiceBasket_view(String basket_check) {
        String[] codeArray = basket_check.split(",");


        return basketRepository.select_choiceBasket_view(codeArray);
    }

}
