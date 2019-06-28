package com.sxt.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {


    private static SimpleDateFormat sdf = new SimpleDateFormat();
    private static String DEFAUT_PATTERN = "yyyy-MM-dd HH:mm:ss:sss";


    /**
     * 获取日期 例如:yyyy-MM-dd HH:mm:ss:sss
     *
     * @return
     */

    public static String getTodayDate() {
       sdf.applyPattern(DEFAUT_PATTERN);
        String date = sdf.format(new Date());
        return  date;
    }

    /**
     *
     * @param pattern  自定义格式
     */
    public  static  String getDate(String pattern){
        sdf.applyPattern(pattern);
        return  sdf.format(new Date());
    }

    /**
     * 获取下个月的时间
     */
    public  static  String  getNextMonth(){
            return  null;
    }


    /**
     * 获取上个月的时间
     */
    public  static  String  getUpMonth(){

        return  null;

    }
    /**
     * 获取一个月的开始时候，一个月的结束时间
     */





    
//    public static void main(String[] args){
//        System.out.println(getDate("yyyyMMDD"));
//    }


}
