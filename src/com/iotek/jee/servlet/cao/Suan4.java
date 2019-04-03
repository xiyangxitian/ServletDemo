package com.iotek.jee.servlet.cao;

import java.util.Arrays;
//从多个数中取出指定的几个，数据量太大的时候不支持
public class Suan4 {

    public static void main(String[] args) {
      /*  Double[] a = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,
                16.0,17.0,18.0,19.0,20.0,
                21.0,22.0,23.0,24.0,25.0,26.0,27.0,28.0,29.0,
                30.0,31.0,32.0,33.0,34.0,35.0,};*/
        Double[] a = new Double[]{1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0};
        Double[][] result = getResult(a, 6);
        printDoubleArray(result);
    }

    static void printDoubleArray(Double[][] d){
        for(Double[] d1 : d){
            System.out.println(Arrays.toString(d1));
        }
    }

    /**
     *
     * @param d  数组
     * @param num 取多少个数
     * @return
     */
    public static Double[][] getResult(Double[] d,int num){
        if(d.length==num){
            return new Double[][]{d};
        }
        Double[][] result = new Double[getKinds(d.length, num)][num];
        int k = 0;
        if(num == 1){
            for(int i=0;i<d.length;i++){
                result[k++] = new Double[]{d[i]};
            }
            return result;
        }
        num--;
        for(int i=0;i<d.length-num;i++){
            Double temp = d[i];
            Double[][] zResult = getResult(jieDuan(d, i), num);
            for(Double[] d1 : zResult){
                result[k++] = getNew(d1,temp);
            }
        }
        return result;
    }

    private static Double[] getNew(Double[] a,Double b){
        Double[] d = new Double[a.length+1];
        int k = 0;
        d[k++] = b;
        for(Double d1 : a){
            d[k++] = d1;
        }
        return d;
    }

    private static Double[] jieDuan(Double[] a,int r) {
        Double[] result = new Double[a.length-r-1];
        int k = 0;
        for(int i= r+1;i<a.length;i++){
            result[k++] = a[i];
        }
        return result;
    }

    //从m个数中取n个数有多少种可能
    static int getKinds(int m,int n){
        return (getJie(m)/getJie(m-n))/getJie(n);
    }

    //求一个数据的阶乘
    static int getJie(int n){
        if(n==1){
            return 1;
        }else{
            return n * getJie(n - 1);
        }
    }



}
