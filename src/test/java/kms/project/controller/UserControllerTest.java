package kms.project.controller;

import kms.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserControllerTest {

    @Autowired
    UserService userService;

    @Test
    void sendMessage(){
        String phoneNumber="01055645417";
        String cer_num="";

        Random random = new Random();
        for(int i = 0 ; i <4;i++){
            cer_num+=random.nextInt(10);
        }
        log.info("sendMessage 시작");
        String api_key="NCSDPSCNG9CQLBVW";
        String api_secret="NOT2VRY1CMXTDP6T24N0YDYOMJMPCEGG";

        Message message = new Message(api_key,api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String,String> param = new HashMap<>();
        param.put("to",phoneNumber);
        param.put("from","01055645417");
        param.put("type","SMS");
        param.put("text","인증번호는" + cer_num + " 입니다");

        JSONObject json = null;
        try {
            json = message.send(param);
        } catch (CoolsmsException e) {
            e.getMessage();
        }
        log.info("json = {}",json);

        log.info("cer_num = {}",cer_num);
    }




}