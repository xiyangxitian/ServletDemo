package com.iotek.jee.servlet.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyUtils {

    /**
     * 把list i 位置上的数换成value
     */
    public static void replace(List<Object> l, int i, Object value) {
        l.remove(i);
        l.add(i, value);
    }

    /**
     * 两个对象是否相等，只判断值，不根据地址判断
     *
     * @param o1
     * @param o2
     * @return
     */
    public static boolean isEquals(Object o1, Object o2) {
        return o1.toString().equals(o2.toString());
    }

    public static String getNowDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    //Double数组从小到大排序
    public static void sortDouble(Double[] d) {
        for (int i = 0; i < d.length - 1; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[i] > d[j]) {
                    double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
    }

    //反序
    public static void reverseDouble(Double[] d) {
        for (int i = 0, j = d.length - 1; i < d.length / 2; i++, j--) {
            Double temp = d[i];
            d[i] = d[j];
            d[j] = temp;
        }
    }

    /**
     * 数组的和
     * @param d
     */
    public static Double sumDouble(Double[] d) {
        Double sum = 0d;
        for(Double d1 : d){
            sum += d1;
        }
        return sum;
    }

    private static long l = 0l;
    /**
     * 数组所有的子数组
     * 11个数要6分钟
     * 10个数36秒
     * 9  3m
     * 8  470ms
     *
     * 所以尽量小一些的数
     * @param d
     */
    public static void getAllChildren(Double[] d) {
        for (int i = 0; i < d.length; i++) {
            Double[] d1 = new Double[d.length - 1];
            int k = 0;
            for (int j = 0; j < d.length; j++) {
                if (i != j) {
                    d1[k++] = d[j];
                }
            }
            System.out.println(l+++"\t"+Arrays.toString(d1));
            if(d1.length>1){
                getAllChildren(d1);
            }
        }
    }

    /**
     * 数组所有的子数组
     *
     * @param d
     */
    public static boolean getChildren(Double[] d,Double yao) {
        for (int i = 0; i < d.length; i++) {
            Double[] d1 = new Double[d.length - 1];
            int k = 0;
            for (int j = 0; j < d.length; j++) {
                if (i != j) {
                    d1[k++] = d[j];
                }
            }
            if(isEquals(yao, sumDouble(d1))){
                System.out.println("^^1找到结果"+Arrays.toString(d1));
                return true;
            }else if (d1.length > 1) {
                boolean c = getChildren(d1, yao);
                if(c){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 包含最大元素的子数组
     * @param d
     * @param yao
     * @return
     */
    public static boolean getChildren2(Double[] d,Double yao) {
        for (int i = 0; i < d.length-1; i++) {
            Double[] d1 = new Double[d.length - 1];
            int k = 0;
            for (int j = 0; j < d.length; j++) {
                if (i != j) {
                    d1[k++] = d[j];
                }
            }
            if(isEquals(yao, sumDouble(d1))){
                System.out.println("^^2找到结果"+Arrays.toString(d1));
                return true;
            }else if(d1.length>3){
                boolean c1 = getChildren(d1, yao);
                if(c1){
                    return true;
                }
            }
        }
        return false;
    }

}
