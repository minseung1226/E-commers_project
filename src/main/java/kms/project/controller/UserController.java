package kms.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    @PostMapping("/user/idcheck")
    @ResponseBody
    public String idcheck(String user_id, String user_pw){
        log.info("user_id = {} ,  user_pw = {}",user_id,user_pw);
        return "ok";
    }
}
