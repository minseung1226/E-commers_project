package kms.project.service;

import kms.project.repository.UserRepository;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.apache.catalina.User;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserVO findUser(String user_id){
        log.info("user_id={}",user_id);
        return userRepository.findUser(user_id);
    }

    public int userInsert(UserVO user){
        return userRepository.userInsert(user);
    }

    //sms문자 보내기
    public void sendMessage(String phoneNumber,String cerNum){
        String api_key="NCSDPSCNG9CQLBVW";
        String api_secret="NOT2VRY1CMXTDP6T24N0YDYOMJMPCEGG";

        Message message = new Message(api_key,api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String,String> param = new HashMap<>();
        param.put("to",phoneNumber);
        param.put("from","01055645417");
        param.put("type","SMS");
        param.put("text","인증번호는 "+cerNum+" 입니다");
        JSONObject json =null;
        try {
             json = message.send(param);
        } catch (CoolsmsException e) {
            e.getMessage();
        }
        log.info("message.send ={}" , json);

    }

    public void updatePw(UserVO user){
        userRepository.updatePw(user);
    }
}
