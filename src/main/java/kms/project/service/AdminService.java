package kms.project.service;

import kms.project.aop.Trace;
import kms.project.repository.AdminRepository;
import kms.project.vo.AdminVO;
import org.springframework.stereotype.Service;

@Service
@Trace
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Trace
    public AdminVO adminLogin(String admin_id){
        return adminRepository.adminLogin(admin_id);
    }
}
