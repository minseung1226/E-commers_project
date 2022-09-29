package kms.project.repository.mapper;

import kms.project.dto.UserDto;
import kms.project.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from project.user where user_id=#{user_id}")
    UserVO findUser(String user_id);

}
