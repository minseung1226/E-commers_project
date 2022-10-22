package kms.project.service;

import kms.project.aop.Trace;
import kms.project.repository.DetailRepository;
import kms.project.repository.ProductRepository;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import kms.project.vo.SalesStatusVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Trace
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Trace
    public List<DivisionVO> divisionList(){
        return productRepository.divisionList();
    }
    @Trace
    public int productInsert(ProductVO product){
        return productRepository.productInsert(product);
    }
    @Trace
    public List<ProductVO> recent_register(){
        return productRepository.recent_register();
    }
    @Trace
    @Transactional
    public void delete_productAndDetail(int product_code){
        productRepository.delete_product(product_code);
        productRepository.delete_detail(product_code);
    }
    @Trace
    public ProductVO select_product(int product_code){
        return productRepository.select_product(product_code);
    }
    @Trace
    public void update_product(ProductVO product){
        productRepository.update_product(product);
    }
    @Trace
    public List<ProductVO> home_select(){
        return productRepository.homeSelect();
    }
    @Trace
    public List<ProductVO> select_search(String division_mType,String division_lType,String search){
        Map<String,String> map = new HashMap<>();
        map.put("division_mType",division_mType);
        map.put("division_lType",division_lType);
        map.put("search",search);
        return productRepository.select_search(map);
    }
    @Trace
    public List<SalesStatusVO> sale_status(Map<String,String> map){
        // 같은 상품끼리 묶기
        List<SalesStatusVO> list = productRepository.sale_status(map); // 검색조건에 해당하는 판매현황
        int now_index=0;
        int compare_index=1;
        while (true){
            if(list.size()<=1)break;
            if(list.get(now_index).getProduct_code()==list.get(compare_index).getProduct_code()){
                list.get(now_index).setOrder_quantity(list.get(now_index).getOrder_quantity()+list.get(compare_index).getOrder_quantity());
                list.get(now_index).setOrder_payment(list.get(now_index).getOrder_payment()+list.get(compare_index).getOrder_payment());
                list.remove(compare_index);
            }
            else{
                now_index++;
                compare_index++;
            }
            if(list.size()==now_index+1)break;
        }
        return list;
    }
}
