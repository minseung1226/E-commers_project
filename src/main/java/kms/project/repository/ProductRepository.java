package kms.project.repository;

import kms.project.aop.Trace;
import kms.project.repository.mapper.ProductMapper;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import kms.project.vo.SalesStatusVO;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

@Repository
@Trace
public class ProductRepository {
    private final ProductMapper mapper;

    public ProductRepository(ProductMapper mapper) {

        this.mapper = mapper;
    }
    @Trace
    public List<DivisionVO> divisionList(){
        return mapper.divisionList();
    }

    @Trace
    public int productInsert(ProductVO product){
        return mapper.productInsert(product);
    }
    @Trace
    public List<ProductVO> recent_register(){
        return mapper.recent_register();
    }
    @Trace
    public void delete_product(int product_code){
        mapper.delete_product(product_code);
    }
    @Trace
    public void delete_detail(int product_code){
        mapper.delete_detail(product_code);
    }
    @Trace
    public ProductVO select_product(int product_code){
        return mapper.select_product(product_code);
    }
    @Trace
    public void update_product(ProductVO product){
        mapper.update_product(product);
    }
    @Trace
    public List<ProductVO> homeSelect(){
        return mapper.home_select();
    }
    @Trace
    public List<ProductVO> select_search(Map<String,String> map){
        return mapper.select_search(map);
    }
    @Trace
    public void update_count(Map<String,Object> map){
        mapper.update_count(map);
    }
    @Trace
    public List<SalesStatusVO> sale_status(Map<String,String> map){
        return mapper.sales_status(map);
    }

}
