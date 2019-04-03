package com.iotek.jee.servlet.util;

import java.util.List;

public class MyUtils {

    /**
     * 把list i 位置上的数换成value
     */
    public static void replace(List<Object> l, int i, Object value){
        l.remove(i);
        l.add(i, value);
    }


}
