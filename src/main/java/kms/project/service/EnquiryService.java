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

    public List<EnquiryVO> selectAll(int user_code){
        return enquiryRepository.selectAll(user_code);
    }

    public void enquiryInsert(EnquiryVO enquiry){
        enquiryRepository.enquiryInsert(enquiry);
    }

    public EnquiryVO enquiryselectOne(int enquiry_code){
        return enquiryRepository.enquirySelectOne(enquiry_code);
    }
}
