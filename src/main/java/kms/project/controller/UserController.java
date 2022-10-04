package kms.project.controller;

import kms.project.controller.validation.UserValidator;
import kms.project.service.UserService;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserValidator validator;

    public UserController(UserService userRepository, UserValidator validator) {
        this.userService = userRepository;
        this.validator = validator;
    }

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(validator);
    }

    @PostMapping("/user/userCheck")
    @ResponseBody
    public String userCheck(String user_id,String user_pw, HttpServletRequest request){
        log.info("UserController.idcheck() user_id={} , user_pw={}",user_id,user_pw);
        UserVO findUserVO = userService.findUser(user_id);
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
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("UserController.logout");
        session.invalidate();

        return "redirect:/";
    }


    @PostMapping("user/idCheck")
    @ResponseBody
    public String idCheck(String user_id) {
        log.info("userController.idCheck start");
        UserVO findUser = userService.findUser(user_id);
        if(findUser==null){
            return "ok";
        }
        return "x";
    }

    @PostMapping("user/joinForm")
    public String joinForm(@ModelAttribute("user") UserVO user){
        log.info("user_phone={}",user.getUser_phone());
        return "joinForm";
    }
    @PostMapping("/user/join")
    public String join(@Validated @ModelAttribute("user") UserVO user, BindingResult result,HttpServletRequest request){
        log.info("UserController.join 시작");
        if(result.hasErrors()){

            log.info("error 발견 = {}" ,result);

            return "joinForm";
        }

        int seq = userService.userInsert(user);

        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        return "redirect:/";
    }

    @GetMapping("user/certification")
    public String certification(){
        return "certification";
    }

    @GetMapping("user/sendMessage")
    @ResponseBody
    public String sendMessage(String user_phone){
        /*Random random = new Random();
        String cer_num="";
        for(int i = 0 ; i < 4 ; i++){
            cer_num+=Integer.toString(random.nextInt(10));
        }

        log.info("수신자 번호 : {} , 인증번호 :{}",user_phone,cer_num);

        return cer_num;

         */
        return user_phone;
    }

}
