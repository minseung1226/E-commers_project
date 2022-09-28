package kms.project.controller;

import kms.project.dto.UserDto;
import kms.project.repository.UserRepository;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/idcheck")
    @ResponseBody
    public String idcheck(String user_id, String user_pw){
        log.info("user_id = {} ,  user_pw = {}",user_id,user_pw);

        UserVO findUserVO = userRepository.findUser(user_id);
        log.info("findUser_id={} , findUser_pw = {}",findUserVO.getUser_id(),findUserVO.getUser_pw());
        return "ok";
    }
}
