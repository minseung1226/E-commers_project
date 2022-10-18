package kms.project.repository.mapper;

import kms.project.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {

    void insert_review(@Param("review")ReviewVO review);
}
