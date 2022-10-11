package kms.project.repository.mapper;

import kms.project.vo.EnquiryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnquiryMapper {

    List<EnquiryVO> selectUser(String user_id);

    void enquiryInsert(@Param("enquiry")EnquiryVO enquiry);

    EnquiryVO enquirySelectOne(int enquiry_code);

    List<EnquiryVO> selectAll();

    void enquiryAnswer(@Param("enquiry") EnquiryVO enquiry);
}
