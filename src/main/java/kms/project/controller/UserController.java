package kms.project.controller;

import kms.project.controller.validation.UserValidator;
import kms.project.repository.UserRepository;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final UserValidator validator;

    public UserController(UserRepository userRepository, UserValidator validator) {
        this.userRepository = userRepository;
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
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("UserController.logout");
        session.invalidate();

        return "redirect:/";
    }


    @PostMapping("user/idCheck")
    @ResponseBody
    public String idCheck(String user_id){
        log.info("userController.idCheck start");
        UserVO findUser = userRepository.findUser(user_id);
        log.info("user_id = {} , findUser.getUser_id={}",user_id,findUser.getUser_id());
        String result="x";
        if(findUser.getUser_id().equals(user_id)){
            result="ok";

        }

    log.info("result = {}",result);
        return result;
    }

    @GetMapping("user/joinForm")
    public String edit(Model model){
        model.addAttribute("user",new UserVO());

        return "joinForm";
    }
    @PostMapping("/user/joinForm")
    public String join(@Validated @ModelAttribute("user") UserVO user, BindingResult result,Model model){
        log.info("UserController.join 시작");
        if(result.hasErrors()){

            log.info("error 발견 = {}" ,result);
            return "joinForm";
        }

        return "/";
    }
}
