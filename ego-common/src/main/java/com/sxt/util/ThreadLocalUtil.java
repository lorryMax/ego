package com.sxt.util;


import java.util.HashMap;
import java.util.Map;

/**
 * 在线程里面传递值的工具类
 * <p>
 * 在springmvc 里面，怎么保证类的变量安全？ 使用ThreadLocalUtil
 * 面试的
 * 线程中传递数据工具类
 */
public class ThreadLocalUtil {

    /**
     * 初始化Threadlocal
     */
    private static ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>() {

        /**
         * 重写init方法 初始化map的值
         * @return
         */
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };


    /**
     * 给线程里面设置一个值
     */
    public static void setValue(String name, Object object) {
        Map<String, Object> map = local.get();
        map.put(name, object);
    }

    /**
     * 从线程里面取一个值
     *
     * @param name
     * @return
     */
    public static Object getValue(String name) {
        Map<String, Object> map = local.get();
        if (!map.containsKey(name)) {
            return null;
        }
        return map.get(name);
    }


    public static void clear() {
        Map<String, Object> map = local.get();
        map.clear();
        map = null;
    }

    public static void main(String[] args) {
        setValue("zS", "ahh");
        System.out.println( getValue("zS"));

    }

}

