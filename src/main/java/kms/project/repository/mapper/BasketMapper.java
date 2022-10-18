package kms.project.repository.mapper;

import kms.project.vo.BasketVO;
import kms.project.vo.BasketViewVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BasketMapper {
    @Select("select * from project.basket where user_code=#{basket.user_code} and detail_code=#{basket.detail_code}")
    BasketVO find_basket(@Param("basket") BasketVO basket);

    @Update("update project.basket set basket_quantity=basket_quantity+#{basket.basket_quantity} where basket_code=#{basket.basket_code}")
    void update_basket(@Param("basket")BasketVO basket);

    void insert_basket(@Param("basket") BasketVO basket);

    @Select("select * from project.basket_view where user_code=#{user_code}")
    List<BasketViewVO> select_basketView(int user_code);

    void delete_basket(String[] basket_code);

    void delete_basket2(Map<String,Object> map);

    List<BasketViewVO> select_choiceBasket_view(String[] array);

    List<BasketViewVO> select_choiceBasket_view2(Map<String,Object> map);



}
