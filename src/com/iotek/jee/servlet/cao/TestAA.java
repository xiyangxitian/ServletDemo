package com.iotek.jee.servlet.cao;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.Date;

public class TestAA {

    public static void main(String[] args) {
//        long jie = getJie(57);
//        System.out.println(jie);
//        long cmn = getCmn(12);
//        System.out.println(cmn);
        Double[] d = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
//        System.out.println(Arrays.toString(d));
        long start = new Date().getTime();
        MyUtils.getAllChildren(d);
        long end = new Date().getTime();
        long s = end - start;
        System.out.println("共用时:" + s + "毫秒");
        long miao = s / 1000;
        System.out.println("共用时:" + miao + "秒");
        long minute = miao / 60;
        long hour = minute / 60;
        System.out.println("共用时:" + minute + "分钟");
        System.out.println("共用时:" + hour + "小时");
    }

    static long getJie(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getJie(n - 1);
        }
    }

    /*
            m个数组有多少个子可能
            m!/(n!*(m-n)!) +
     */
    static long sum = 0l;

    static long getCmn(long m) {
        for (long n = 1; n < m / 2; n++) {
            sum += ((getJie(m) / getJie(m - n)) / getJie(n));
        }
        return sum;
    }


}
