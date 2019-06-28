package com.sxt.aspect.web;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 错误信息处理日志切面
 */
@Aspect
@Component
public class WebErrorHandler {


    private static Logger log = LoggerFactory.getLogger(WebErrorHandler.class);

    /**
     * 返回错误友好信息给用户页面
     *
     * @param e
     * @return 若用@RequestBody 则返回给用户一个json数据
     */

    @ExceptionHandler(RuntimeException.class)
    public String errorLogging(RuntimeException e) {
        log.error("发送错误" + e.getMessage());
        //prefix /WEB-INF/views/  +error+ suffix.jsp

        return "error";
    }
}
