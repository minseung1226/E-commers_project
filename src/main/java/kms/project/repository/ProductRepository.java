package kms.project.repository;

import kms.project.repository.mapper.ProductMapper;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public class ProductRepository {
    private final ProductMapper mapper;

    public ProductRepository(ProductMapper mapper) {
        this.mapper = mapper;
    }

    public List<DivisionVO> divisionList(){
        return mapper.divisionList();
    }

    public int productInsert(ProductVO product){
        return mapper.productInsert(product);
    }

    public List<ProductVO> recent_register(){
        return mapper.recent_register();
    }

    public void delete_product(int product_code){
        mapper.delete_product(product_code);
    }

    public void delete_detail(int product_code){
        mapper.delete_detail(product_code);
    }

    public ProductVO select_product(int product_code){
        return mapper.select_product(product_code);
    }

}
