package com.iotek.jee.servlet.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyUtils {

    /**
     * 把list i 位置上的数换成value
     */
    public static void replace(List<Object> l, int i, Object value){
        l.remove(i);
        l.add(i, value);
    }

    /**
     * 两个对象是否相等，只判断值，不根据地址判断
     * @param o1
     * @param o2
     * @return
     */
    public static boolean isEquals(Object o1,Object o2){
        return o1.toString().equals(o2.toString());
    }

    public static String getNowDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
