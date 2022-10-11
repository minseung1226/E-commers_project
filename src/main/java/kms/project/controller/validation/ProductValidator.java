package kms.project.controller.validation;

import kms.project.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@Slf4j
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductVO product =(ProductVO) target;
        log.info("division_mType={}",product.getDivision_mType());
        emptyError(errors,new String[]{"product_name","product_detail","product_img1","product_img2","product_price"},"empty");
        if(product.getProduct_price()==0 || product.getProduct_price()>100000){
            errors.rejectValue("product_price","range");
        }
        if(product.getDivision_mType().equals("분류")){
            errors.rejectValue("division_mType","empty");
        }

    }

    private void emptyError(Errors error,String[] param,String code){
        for (String arr : param) {
            ValidationUtils.rejectIfEmptyOrWhitespace(error,arr,code);
        }

    }
}
