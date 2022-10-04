package kms.project.repository;

import kms.project.repository.mapper.UserMapper;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
public class UserRepository {
    @Autowired
    private UserMapper userMapper;

    public UserVO findUser(String user_id){
        return userMapper.findUser(user_id);
    }

    @Transactional
    public int userInsert(UserVO user){
         log.info("user_id={}" , user.getUser_id());
        return userMapper.userInsert(user);

    }
}
