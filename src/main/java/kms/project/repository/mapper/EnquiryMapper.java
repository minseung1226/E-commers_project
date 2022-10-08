package kms.project.repository.mapper;

import kms.project.vo.EnquiryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnquiryMapper {

    List<EnquiryVO> selectAll(int user_code);

    void enquiryInsert(@Param("enquiry")EnquiryVO enquiry);

    EnquiryVO enquirySelectOne(int enquiry_code);

}
