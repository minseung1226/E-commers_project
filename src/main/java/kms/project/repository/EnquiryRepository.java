package kms.project.repository;

import kms.project.aop.Trace;
import kms.project.repository.mapper.EnquiryMapper;
import kms.project.vo.EnquiryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Trace
public class EnquiryRepository {
    private final EnquiryMapper mapper;

    public EnquiryRepository(EnquiryMapper mapper) {
        this.mapper = mapper;
    }
    @Trace
    public List<EnquiryVO> selectUser(String user_id){
        return mapper.selectUser(user_id);
    }
    @Trace
    public void enquiryInsert(EnquiryVO enquiry){
        mapper.enquiryInsert(enquiry);
    }
    @Trace
    public EnquiryVO enquirySelectOne(int enquiry_code){
        return mapper.enquirySelectOne(enquiry_code);
    }
    @Trace
    public List<EnquiryVO> selectAll(){
        return mapper.selectAll();
    }
    @Trace
    public void enquiryAnswer(EnquiryVO enquiry){
        mapper.enquiryAnswer(enquiry);
    }
}
