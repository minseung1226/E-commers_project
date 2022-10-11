package kms.project.repository;

import kms.project.repository.mapper.AdminMapper;
import kms.project.vo.AdminVO;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    private final AdminMapper mapper;

    public AdminRepository(AdminMapper mapper) {
        this.mapper = mapper;
    }

    public AdminVO adminLogin(String admin_id){
        return mapper.adminLogin(admin_id);
    }
}
