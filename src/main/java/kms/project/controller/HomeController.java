package kms.project.controller;

import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HomeController {

    @GetMapping(value = {"/","user/home"})
    public String home(Model model){
        log.info("HomeController 시작");
/*
        model.addAttribute("user",new UserVO());
*/

        return "home";
    }
}
