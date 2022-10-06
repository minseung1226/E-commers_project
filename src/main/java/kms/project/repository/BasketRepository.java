package kms.project.repository;

import kms.project.repository.mapper.BasketMapper;
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


}
