package kms.project.repository;

import kms.project.repository.mapper.OrderMapper;
import kms.project.vo.OrderVO;
import kms.project.vo.OrderViewVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final OrderMapper orderMapper;

    public OrderRepository(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void insert_order(List<OrderVO> list){
        orderMapper.insert_order(list);
    }

    public List<OrderViewVO> select_order_view(int user_code){
        return orderMapper.select_order_view(user_code);
    }

    public OrderViewVO findOrderView(int order_code){
        return orderMapper.findOrderView(order_code);
    }
}
