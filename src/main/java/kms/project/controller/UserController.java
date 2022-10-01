package kms.project.controller;

import kms.project.dto.UserDto;
import kms.project.repository.UserRepository;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String idCheck(String user_id,String user_pw, HttpServletRequest request){
        log.info("UserController.idcheck() user_id={} , user_pw={}",user_id,user_pw);
        UserVO findUserVO = userRepository.findUser(user_id);
        log.info("findUserVO.user_id={} , findUserVO.user_pw={}",findUserVO.getUser_id(),findUserVO.getUser_pw());
        String result ="";
        if(findUserVO == null){
            result="잘못된 아이디 입니다";
        }
        else if(!findUserVO.getUser_pw().equals(user_pw)){
            result="잘못된 비밀번호 입니다"   ;
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("user", findUserVO);
            result="ok";
        }
        return result;

    }
    @GetMapping("/user/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect :";
    }
}
