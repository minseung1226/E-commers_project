package kms.project.repository.mapper;

import kms.project.service.ProductService;
import kms.project.vo.DetailVO;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

}
