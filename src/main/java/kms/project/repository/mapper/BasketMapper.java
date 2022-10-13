package kms.project.repository.mapper;

import kms.project.vo.BasketVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BasketMapper {
    @Select("select * from project.basket where user_code=#{basket.user_code} and detail_code=#{basket.detail_code}")
    BasketVO find_basket(@Param("basket") BasketVO basket);

    @Update("update project.basket set basket_quantity=basket_quantity+#{basket.basket_quantity} where basket_code=#{basket.basket_code}")
    void update_basket(@Param("basket")BasketVO basket);

    void insert_basket(@Param("basket") BasketVO basket);

    @Select("select * from project.user ")
    List<BasketVO> select_basketList(String user_code);

}
