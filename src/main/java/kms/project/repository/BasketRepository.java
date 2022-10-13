package kms.project.repository;

import kms.project.repository.mapper.BasketMapper;
import kms.project.vo.BasketVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Slf4j
public class BasketRepository {
    private final BasketMapper basketMapper;

    public BasketRepository(BasketMapper basketMapper) {
        this.basketMapper = basketMapper;
    }


    public BasketVO find_basket(BasketVO basket){
        return basketMapper.find_basket(basket);
    }
    public void update_basket(BasketVO basket){
        basketMapper.update_basket(basket);
    }
    public void insert_basket(BasketVO basket){
        basketMapper.insert_basket(basket);
    }

}
