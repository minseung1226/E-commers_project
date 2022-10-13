package kms.project.service;

import kms.project.repository.DetailRepository;
import kms.project.repository.ProductRepository;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<DivisionVO> divisionList(){
        return productRepository.divisionList();
    }

    public int productInsert(ProductVO product){
        return productRepository.productInsert(product);
    }

    public List<ProductVO> recent_register(){
        return productRepository.recent_register();
    }

    @Transactional
    public void delete_productAndDetail(int product_code){
        productRepository.delete_product(product_code);
        productRepository.delete_detail(product_code);
    }

    public ProductVO select_product(int product_code){
        return productRepository.select_product(product_code);
    }

    public void update_product(ProductVO product){
        productRepository.update_product(product);
    }

    public List<ProductVO> home_select(){
        return productRepository.homeSelect();
    }

    public List<ProductVO> select_search(String division_mType,String division_lType,String search){
        Map<String,String> map = new HashMap<>();
        map.put("division_mType",division_mType);
        map.put("division_lType",division_lType);
        map.put("search",search);
        return productRepository.select_search(map);
    }
}
