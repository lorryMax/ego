package com.sxt.aspect.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */

@Aspect
@Component
public class ServiceAspect {

    private static Logger log = LoggerFactory.getLogger(ServiceAspect.class);

    @Around("execution(* com.sxt.service.impl.*.*(..))")
    private Object logging(ProceedingJoinPoint point) throws Throwable {
        String name = point.getSignature().getName();
        log.info("方法执行" + name);
        log.info("执行参数" + point.getArgs());
        Object proceed = point.proceed(point.getArgs());
        log.info("执行结束，结果：" + proceed);
        return proceed;
    }

}
