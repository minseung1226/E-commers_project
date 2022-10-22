package kms.project.repository;

import kms.project.aop.Trace;
import kms.project.repository.mapper.UserMapper;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;


@Repository
@Trace
public class UserRepository {
    private final UserMapper userMapper;

    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Trace
    public UserVO findUser(String user_id){
        return userMapper.findUser(user_id);
    }
    @Trace
    public int userInsert(UserVO user){
        return userMapper.userInsert(user);

    }
    @Trace
    public void updatePw(UserVO user){
         userMapper.updatePw(user);
    }
    @Trace
    public void updateUser(UserVO user){
        userMapper.updateUser(user);
    }
    @Trace
    public void updateCon_date(int user_code){

        userMapper.updateCon_date(user_code);
    }
    @Trace
    public void updateUser_payment(Map<String,Object> map){
        userMapper.updateUser_payment(map);
    }
}
