package kms.project.repository;

import kms.project.repository.mapper.EnquiryMapper;
import kms.project.vo.EnquiryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnquiryRepository {
    private final EnquiryMapper mapper;

    public EnquiryRepository(EnquiryMapper mapper) {
        this.mapper = mapper;
    }

    public List<EnquiryVO> selectAll(int user_code){
        return mapper.selectAll(user_code);
    }

    public void enquiryInsert(EnquiryVO enquiry){
        mapper.enquiryInsert(enquiry);
    }

    public EnquiryVO enquirySelectOne(int enquiry_code){
        return mapper.enquirySelectOne(enquiry_code);
    }
}
