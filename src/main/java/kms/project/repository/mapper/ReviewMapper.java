package kms.project.repository.mapper;

import kms.project.vo.ReviewVO;
import kms.project.vo.ReviewViewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ReviewMapper {

    void insert_review(@Param("review")ReviewVO review);
    @Select("select * from project.review_view where order_code=#{order_code}")
    ReviewViewVO find_review_view(int order_code);

    void update_review(@Param("review") ReviewVO review);

    @Select("select * from project.review where product_code=#{product_code}")
    List<ReviewVO> selectList(int product_code);
}
