package kms.project.repository.mapper;

import kms.project.vo.AdminVO;
import kms.project.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    AdminVO adminLogin(String admin_id);
}
