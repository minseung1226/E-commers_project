package kms.project.controller.validation;

import kms.project.vo.AdminVO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Valid;
@Slf4j
@Component
public class AdminValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        emptyError(errors,new String[]{"admin_id","admin_pw"},"empty");
    }

    private void emptyError(Errors error,String[] param,String code){
        log.info("UserValidator.emptyError() 시작");
        for (String arr : param) {
            ValidationUtils.rejectIfEmptyOrWhitespace(error,arr,code);
        }
        log.info("UserValidator.emptyError() 종료");

    }
}
