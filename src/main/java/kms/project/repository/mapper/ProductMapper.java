package kms.project.repository.mapper;

import kms.project.service.ProductService;
import kms.project.vo.DetailVO;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Profile;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    @Select("select * from project.division")
    List<DivisionVO> divisionList();

    int productInsert(@Param("product") ProductVO product);

    List<ProductVO> recent_register();

    @Delete("delete from project.product where product_code=#{product_code}")
    void delete_product(int product_code);

    @Delete("delete from project.detail where product_code=#{product_code}")
    void delete_detail(int product_code);

    @Select("select * from project.product where product_code=#{product_code}")
    ProductVO select_product(int product_code);

    void update_product(@Param("product") ProductVO product);

    @Select("select * from project.product order by product_count desc limit 12")
    List<ProductVO> home_select();


    List<ProductVO> select_search(Map<String,String> map);


//    update project.product p,project.detail d set p.product_count=2 where p.product_code=d.product_code and d.detail_code=19;
    void update_count(Map<String,Object> map);
}
