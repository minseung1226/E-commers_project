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
        log.info("UserValidator 시작");
        UserVO user = (UserVO) target;

        emptyError(errors,new String[]{"user_id","user_pw","user_name","user_phone","user_addr1","user_sex"},"empty");
        log.info("UserValidator 종료");
    }

    private void emptyError(Errors error,String[] param,String code){
        log.info("UserValidator.emptyError() 시작");
        for (String arr : param) {
            ValidationUtils.rejectIfEmptyOrWhitespace(error,arr,code);
        }
        log.info("UserValidator.emptyError() 종료");

    }
}
