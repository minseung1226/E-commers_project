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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/idcheck")
    @ResponseBody
    public String idcheck(String user_id, HttpServletRequest request){
        log.info("UserController.idcheck()");
        UserVO findUserVO = userRepository.findUser(user_id);
        String result ="";
        if(findUserVO == null){
            result="잘못된 아이디 입니다";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",findUserVO);
        return "ok";

    }
}
