package com.robot.admin.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.robot.admin.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author robot
 * @date 2020/1/8 11:14
 * JWT拦截器
 */
@Slf4j
@Component
@Configuration
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
        response.setHeader("Access-Control-Max-Age", "24 * 60 * 60");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,JSONP");
//        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Authorization , Access-Control-Request-Headers");
        response.setHeader("Access-Control-Allow-Origin", "*");
        if ("OPTIONS".equals(request.getMethod())) {//这里通过判断请求的方法，判断此次是否是预检请求，如果是，立即返回一个204状态吗，标示，允许跨域；预检后，正式请求，这个方法参数就是我们设置的post了
            // 是预检请求则设置响应状态并返回
            if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
                response.setStatus(HttpStatus.OK.value());
                return true;
            }
        }

        //获取请求头中的authorization信息
        final String authHeader = request.getHeader("Authorization");
        log.info(" ---- authHeader：{} ---- ", authHeader);
        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(StaticUtil.TOKEN_PREFIX)) {
            log.info(" ---- 用户未登录，请先登录 ---- ");
            Message message = Message.error(ErrorType.USER_NOT_LOGIN);
            sendJsonMessage(response, message);
            return false;
        }
        //获取token
        String token = authHeader.substring(7);
        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        Message message = JWTUtil.parseJWT(token, StaticUtil.base64Secret);
        if (!StringUtils.equals(message.getCode(), ErrorType.SUCCESS.getErrorCode())) {
            sendJsonMessage(response, message);
            return false;
        }
        String uid = JWTUtil.getUserId(token, StaticUtil.base64Secret);
        LocalUserUtil.setUid(uid);
        log.info("JwtInterceptor uid:{}  use token login ", uid);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUserUtil.deleteUid();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                log.info("初始化 corsConfigurer 配置");
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*")
                        .allowCredentials(true);

            }
        };
    }

    public static void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
    }
}
