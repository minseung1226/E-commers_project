package kms.project.service;

import kms.project.aop.Trace;
import kms.project.repository.EnquiryRepository;
import kms.project.vo.EnquiryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Trace
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;

    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }
    @Trace
    public List<EnquiryVO> selectUser(String user_id){
        return enquiryRepository.selectUser(user_id);
    }
    @Trace
    public void enquiryInsert(EnquiryVO enquiry){
        enquiryRepository.enquiryInsert(enquiry);
    }
    @Trace
    public EnquiryVO enquiryselectOne(int enquiry_code){
        return enquiryRepository.enquirySelectOne(enquiry_code);
    }
    @Trace
    public List<EnquiryVO> selectAll(){
        return enquiryRepository.selectAll();
    }
    @Trace
    public void enquiryAnswer(EnquiryVO enquiry){
        enquiryRepository.enquiryAnswer(enquiry);
    }
}
