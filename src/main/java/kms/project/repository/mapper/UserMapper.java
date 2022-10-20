package kms.project.repository.mapper;
import kms.project.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface UserMapper {

    UserVO findUser(String user_id);
    int userInsert(@Param("user") UserVO user);

    void updatePw(@Param("user") UserVO user);

    void updateUser(@Param("user")UserVO user);

    @Update("update project.user set user_con_date=current_date where user_code=#{user_code}")
    void updateCon_date(int user_code);

    @Update("update project.user set user_payment=#{user_payment} where user_code=#{user_code}")
    void updateUser_payment(Map<String,Object> map);
}
