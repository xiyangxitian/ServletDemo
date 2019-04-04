package com.iotek.jee.servlet.best;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.*;

/**
 * 从一个数组中选择等于指定值的最快方案（自己写程序实现）
 */
public class SuanSumOnlyLangOne {


//    private static Double[] source = {1.0, 2.0, 3.0,6.0,5.0,4.0,7.0,8.0,9.0,10.0,12.0 };
//    private static Double yao = 31.0;
    private static boolean isAllZheng = true;//是否全是正数
    static List<Double[]> list = new ArrayList<>();
    private static int minArray = 1;//拆分的最小数组

    static Double[] source = new Double[]{
            268.25,
            291.82,
            2.04,
            20918.48,
            159.56,
            3.71,
            16407.56,
            15667.35,
            25260.68,
            3137.42,
            7981.88,
            17380.09,
            44962.2,
            58770.87,
            -3897.08,
            -7432.86,
            -47654.99,
            -319.37,
            -224.63,
            -4116.7,
            25897.7,
            47811.0,
            613.14,
            4259.5,
            19426.62,
            248.82,
            54.64,
            4698.79,
            33.55,
            2615.23,
            60.23
    };
    static double yao = 118305.94;


    public static void main(String[] args) {
        //1. 排序 从小到大
        MyUtils.sortDouble(source);
        //MyUtils.reverseDouble(source);
        minArray = getMinArray(source);
        while (true){
            Double[] s = getNowSource(source, minArray++);
            boolean flag = MyUtils.getChildren2(s, yao);
            if(flag){
                break;
            }
            if(minArray>=source.length){
                System.out.println("未找到符合的数据");
                break;
            }
        }
    }

    private static Double[] getNowSource(Double[] source,int minArray){
        Double[] d = new Double[minArray];
        for(int i=0;i<minArray;i++){
            d[i] = source[i];
        }
        return d;
    }
    //传个已经排序好的数组
    static int getMinArray(Double[] d){
        double sum = 0d;
        int k = 1;
        for(int i = d.length-1;i>0;i--){
            sum += d[i];
            if(sum<yao){
                k++;
            }else{
                break;
            }
        }
        return k;
    }


}
