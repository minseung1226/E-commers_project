package kms.project.service;

import kms.project.repository.AdminRepository;
import kms.project.vo.AdminVO;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminVO adminLogin(String admin_id){
        return adminRepository.adminLogin(admin_id);
    }
}
