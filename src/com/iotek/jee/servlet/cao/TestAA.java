package com.iotek.jee.servlet.cao;

public class TestAA {

    public static void main(String[] args) {
//        long jie = getJie(57);
//        System.out.println(jie);
//        long cmn = getCmn(12);
//        System.out.println(cmn);
        double a = 10.0;
        Double b = 10.0d;
        System.out.println(a==b);
    }

    static long getJie(long n){
        if(n==1){
            return 1;
        }else{
            return n*getJie(n-1);
        }
    }

    /*
            m个数组有多少个子可能
            m!/(n!*(m-n)!) +
     */
    static long sum = 0l;
    static long getCmn(long m){
        for(long n=1;n<m/2;n++){
            sum += ((getJie(m)/getJie(m-n))/getJie(n));
        }
        return sum;
    }


}
