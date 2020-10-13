package com.robot.admin.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author robot
 * @date 2020/1/8 11:29
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这里过滤不需要token的请求
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/userLogin/index")
                .excludePathPatterns("/product/uploadFile");
    }

}
