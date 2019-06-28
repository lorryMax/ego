package com.sxt.aspect.web;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class WebAspect {


    private static Logger log = LoggerFactory.getLogger(WebAspect.class);

    /**
     * web层的日志切面
     *
     * @param point
     * @return
     */

    @Around("execution(* com.sxt.controller.*.*(..)))")
    public Object webLogging(ProceedingJoinPoint point) throws Throwable {
//        用户访问的url
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRemoteAddr();
        log.info("用户的远程地址为" + url);
//        用户访问的方法
        String name = point.getSignature().getName();
        log.info("用户访问的方法" + name);
//          用户的参数
        Enumeration<String> names = request.getAttributeNames();
        int i = 1;
        Object[] args = point.getArgs();
        for (Object arg : args) {
            log.info("第" + i + "个请求参数为:" + arg);
            i++;
        }
//     用户访问是否成功
        Object proceed = point.proceed(point.getArgs());
        log.info("用户访问成功" + proceed);
        return proceed;
    }
}
