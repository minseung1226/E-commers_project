package kms.project.service;

import kms.project.repository.EnquiryRepository;
import kms.project.vo.EnquiryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;

    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    public List<EnquiryVO> selectUser(String user_id){
        return enquiryRepository.selectUser(user_id);
    }

    public void enquiryInsert(EnquiryVO enquiry){
        enquiryRepository.enquiryInsert(enquiry);
    }

    public EnquiryVO enquiryselectOne(int enquiry_code){
        return enquiryRepository.enquirySelectOne(enquiry_code);
    }

    public List<EnquiryVO> selectAll(){
        return enquiryRepository.selectAll();
    }

    public void enquiryAnswer(EnquiryVO enquiry){
        enquiryRepository.enquiryAnswer(enquiry);
    }
}
