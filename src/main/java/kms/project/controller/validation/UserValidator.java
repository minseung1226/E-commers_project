package kms.project.controller.validation;

import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
@Slf4j
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserVO user = (UserVO) target;
        emptyError(errors,new String[]{"user_id","user_pw","user_name","user_phone","user_addr1","user_sex","user_birth"},"empty");


        if(!user.getUser_pw2().equals(user.getUser_pw())){
            errors.rejectValue("user_pw2","pwMismatch");
        }
        if(user.getUser_birth().length()!=6){
            errors.rejectValue("user_birth","misMatch");
        }
        if(user.getUser_phone().length()!=13){
            errors.rejectValue("user_phone","misMatch");
        }




    }


    //값을 입력하지않은 input error
    private void emptyError(Errors error,String[] param,String code){
        log.info("UserValidator.emptyError() 시작");
        for (String arr : param) {
            ValidationUtils.rejectIfEmptyOrWhitespace(error,arr,code);
        }
        log.info("UserValidator.emptyError() 종료");

    }
}
