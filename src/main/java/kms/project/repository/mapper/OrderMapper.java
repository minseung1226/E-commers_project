package kms.project.repository.mapper;

import kms.project.vo.OrderVO;
import kms.project.vo.OrderViewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    void insert_order(@Param("list") List<OrderVO> list);

    @Select("select * from project.order_view where user_code=#{user_code} order by order_code desc")
    List<OrderViewVO> select_order_view(int user_code);

    @Select("select * from project.order_view where order_code=#{order_code}")
    OrderViewVO findOrderView(int order_code);
    @Update("update project.order set review_status=1 where order_code=#{order_code}")
    void update_status(int order_code);
}
