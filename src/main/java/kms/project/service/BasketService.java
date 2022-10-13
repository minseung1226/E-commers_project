package kms.project.service;

import kms.project.repository.BasketRepository;
import kms.project.repository.DetailRepository;
import kms.project.vo.BasketVO;
import kms.project.vo.DetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final DetailRepository detailRepository;

    public BasketService(BasketRepository basketRepository, DetailRepository detailRepository) {
        this.basketRepository = basketRepository;
        this.detailRepository = detailRepository;
    }

    @Transactional
    public void add_basket(BasketVO basket, DetailVO detail){
        Integer detail_code = detailRepository.select_code(detail);

        basket.setDetail_code(detail_code);

        BasketVO findBasket = basketRepository.find_basket(basket);
        if(findBasket==null){
            basketRepository.insert_basket(basket);
        }
        else{
            basketRepository.update_basket(basket);
        }
    }

}
