package kms.project.service;

import kms.project.repository.UserRepository;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class UserService {
    UserRepository userRepository;

    public UserVO findUser(String user_id){
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
        param.put("app_version","test app 2.2");
        JSONObject json =null;
        try {
             json = message.send(param);
        } catch (CoolsmsException e) {
            e.getMessage();
        }
        log.info("message.send ={}" , json);

    }
}
