package kms.project.repository.mapper;

import kms.project.dto.UserDto;
import kms.project.vo.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    UserVO findUser(String user_id);
    int userInsert(@Param("user") UserVO user);

    void updatePw(@Param("user") UserVO user);

}
