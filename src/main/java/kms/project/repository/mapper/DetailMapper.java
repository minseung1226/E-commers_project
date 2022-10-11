package kms.project.repository.mapper;

import kms.project.vo.DetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DetailMapper {
    void detailInsert(@Param("list")List<DetailVO> list);

    @Select("select * from project.detail where product_code=#{product_code}")
    List<DetailVO> select_detail(int product_code);
}
