package kms.project;

import kms.project.springinterceptor.AdminInterceptor;
import kms.project.springinterceptor.UserInterceptor;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .order(1)
                .addPathPatterns("/mypage/**,/user/logout,/user/basket_insert,/user/orderForm,/user/product_order");
        registry.addInterceptor(new AdminInterceptor())
                .order(2)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin,/admin/login");

    }
}
