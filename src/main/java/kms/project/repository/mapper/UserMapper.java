package kms.project.repository.mapper;

import kms.project.dto.UserUpdateDto;
import kms.project.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserVO findUser(String user_id);
    int userInsert(@Param("user") UserVO user);

    void updatePw(@Param("user") UserVO user);

    void updateUser(@Param("user")UserUpdateDto user);
}
