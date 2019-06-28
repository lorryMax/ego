package com.sxt.aspect.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 运行时的时间统计，便于调优
 */

@Aspect
@Component
public class RuntimeAspect {

    private static Logger log = LoggerFactory.getLogger(RuntimeAspect.class);

    @Around("execution(* com.sxt.mapper.*.*(..))")
    public Object runLogging(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = point.proceed(point.getArgs());
        String name = point.getSignature().getName();
        long endTiem = System.currentTimeMillis();
        log.info("该方法" + name + "执行的时间为" + (endTiem - startTime));
        return obj;

    }

}
