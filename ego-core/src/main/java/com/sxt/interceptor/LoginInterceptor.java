package com.sxt.interceptor;

import com.alibaba.fastjson.JSON;
import com.sxt.domain.Admin;
import com.sxt.util.CookieUtil;
import com.sxt.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //保存的Cookie名
    private static final String EGO_USS = "EGO-USS";

    @Autowired
    private JedisPool jedisPool;

    @Value("http://localhost:8082/login")
    private String sso;

    /**
     * 在进入之前拦截
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {


        System.out.println("进去拦截器");

        /*
         *判断用户是否登录，登录放行，没有登录拦截，跳到登录页面
         *
         */
        //获取用户的userkey
        String token = CookieUtil.getCookieValue(request, EGO_USS);
        if (token == null) {
            //说明不存在登录
            //提示去登录,跳到登录系统 "http://localhost:8082/login?redirectUrl=http://localhost:8080"
            response.sendRedirect(sso + "?redirectUrl=" + request.getRequestURL());
            //拦截
            return false;
        }
        //说明存在
        Jedis jedis = jedisPool.getResource();

        if (jedis.exists(token)) {
            //存在，该用户已经登录  ,放行
            String userKey = jedis.get(token);
            //获取用户
            Admin admin = JSON.parseObject(userKey, Admin.class);
            System.out.println("userKey:----->" + userKey);

            //线程锁传递user
            ThreadLocalUtil.setValue("user", admin);
            System.out.println("admin:----->" + admin);

            jedis.close();
            return true;
        } else {
//      不存在 ，该用户没登录
            //重定向登录yem
            response.sendRedirect(sso + "?redirectUrl=" + request.getRequestURL());
            System.out.println(request.getRequestURL());
            return false;
        }
    }

    /**
     * modelAndView  在实体渲染之前拦截
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 完成请求后拦截
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
