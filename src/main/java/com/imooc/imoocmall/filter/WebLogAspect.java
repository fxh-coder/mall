package com.imooc.imoocmall.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 打印请求和响应信息
 */
@Aspect
@Component
public class WebLogAspect {
    private final Logger log= LoggerFactory.getLogger(WebLogAspect.class);
    @Pointcut("execution(public * com.imooc.imoocmall.controller.*.*(..))")
    public void weblog(){

    }
    /*
    请求之前信息
     */
    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint){
        // 收到请求记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("URL:" + request.getRequestURL().toString());
        log.info("HTPP_METHOD:" + request.getMethod());
        log.info("IP:" + request.getRemoteAddr());
        log.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS:" + Arrays.toString(joinPoint.getArgs()));
    }
    /**
     * 请求之后信息
     */
    @AfterReturning(returning = "res",pointcut = "weblog()")
    public void doAfterReturning(Object res) throws JsonProcessingException {
        //处理完成请求，返回内容
        log.info("RESPONSE:" + new ObjectMapper().writeValueAsString(res));

    }
}
