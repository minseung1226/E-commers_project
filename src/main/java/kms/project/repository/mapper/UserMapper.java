package kms.project.repository.mapper;

import kms.project.dto.UserDto;
import kms.project.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserVO findUser(String user_id);

}
