package kms.project.repository;

import kms.project.dto.UserUpdateDto;
import kms.project.repository.mapper.UserMapper;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class UserRepository {
    private final UserMapper userMapper;

    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserVO findUser(String user_id){
        log.info("user_id = {}",user_id);
        return userMapper.findUser(user_id);
    }

    public int userInsert(UserVO user){
         log.info("user_id={}" , user.getUser_id());
        return userMapper.userInsert(user);

    }

    public void updatePw(UserVO user){
         userMapper.updatePw(user);
    }

    public void updateUser(UserUpdateDto user){
        userMapper.updateUser(user);
    }

    public void updateCon_date(int user_code){
        userMapper.updateCon_date(user_code);
    }
    public void updateUser_payment(Map<String,Object> map){
        userMapper.updateUser_payment(map);
    }
}
