package kms.project.service;

import kms.project.repository.BasketRepository;
import kms.project.repository.OrderRepository;
import kms.project.repository.ProductRepository;
import kms.project.repository.UserRepository;
import kms.project.vo.BasketViewVO;
import kms.project.vo.OrderVO;
import kms.project.vo.OrderViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final BasketRepository basketRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, BasketRepository basketRepository,
                        UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void insert_order(OrderVO order, String detail_codeList){
        String[] code_array = detail_codeList.split(",");

        HashMap<String,Object> map = new HashMap<>();
        log.info("user_code={}" ,order.getUser_code());


        map.put("user_code",order.getUser_code())   ;
        map.put("code_array",code_array);
        List<BasketViewVO> basket_viewList = basketRepository.select_choiceBasket_view(map);

        List<OrderVO>   list = makeOrderList(order, basket_viewList);

        orderRepository.insert_order(list); // 주문 저장

        basketRepository.delete_basket(map); //basket 삭제


        List<Map<String, Object>> count_list = product_count(basket_viewList);// 상품별 판매 수량, detail_code,basket_quantity
        for(int i = 0 ; i <count_list.size() ; i++) {
            productRepository.update_count(count_list.get(i));
        }
        Map<String,Object> userMap= new HashMap<>();
        map.put("user_code",order.getUser_code());
        map.put("user_payment",all_payment(basket_viewList));

        userRepository.updateUser_payment(userMap); // user 판매금액 +

    }

    private List<Map<String, Object>> product_count(List<BasketViewVO> list){
        List<Map<String,Object>> product_count = new ArrayList<>();
        for(int i=0; i < list.size();i++){
            Map<String,Object> map = new HashMap<>();
            map.put("product_code",list.get(i).getProduct_code());
            map.put("product_count",list.get(i).getBasket_quantity());
            product_count.add(map);
        }
        return product_count;
    }

    private int all_payment(List<BasketViewVO> list){
        int result=0;
        for(int i =0; i <list.size() ; i++){
            result+=list.get(i).getBasket_quantity()* list.get(i).getProduct_price();
        }

        return result;
    }

    private List<OrderVO> makeOrderList(OrderVO order, List<BasketViewVO> basket_viewList) {
        List<OrderVO> list = new ArrayList<>();

        for(int i = 0 ; i <basket_viewList.size() ; i++){
            OrderVO o = new OrderVO();
            o.setOrder_addr1(order.getOrder_addr1());
            o.setOrder_addr2(order.getOrder_addr2());
            o.setOrder_name(order.getOrder_name());
            o.setOrder_number(order.getOrder_number());
            o.setOrder_request(order.getOrder_request());
            o.setOrder_phone(order.getOrder_phone());
            o.setUser_code(order.getUser_code());
            o.setDetail_code(basket_viewList.get(i).getDetail_code());
            o.setOrder_payment(basket_viewList.get(i).getBasket_quantity()* basket_viewList.get(i).getProduct_price());
            o.setOrder_quantity(basket_viewList.get(i).getBasket_quantity());

            list.add(o);
        }
        return list;
    }

    public List<OrderViewVO> select_order_view(int user_code){
        return orderRepository.select_order_view(user_code);
    }

    public OrderViewVO findOrderView(int order_code){
        return orderRepository.findOrderView(order_code);
    }
}
