package com.iotek.jee.servlet.best;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.*;

/**
 * 从一个数组中选择等于指定值的最快方案（自己写程序实现）
 */
public class SuanSum {


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
//            -3897.08,
//            -7432.86,
//            -47654.99,
//            -319.37,
//            -224.63,
//            -4116.7,
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
        long start = new Date().getTime();
        System.out.println("开始时："+MyUtils.getNowDate());
        calResult(source);
        long end = new Date().getTime();
        System.out.println("结束时："+MyUtils.getNowDate());
        System.out.println("共用时："+(end-start)+"m毫");
    }

    /**
     * 得到数组的所有的子组合数组
     * @param d
     */
    private static void calResult(Double[] d){
        if(isAllZheng){
            d = getRealArray(d, yao);
            sortDouble(d);
            minArray = getMinArray(d);
        }else{
            sortDouble(d);
        }

        getChildren(d);

        if(list.size()==0){
            System.out.println("没有符合条件的");
        }else{
            System.out.println("你要的结果：");
            printListDouble(list);
            System.out.println("共："+list.size()+"个");
        }
    }
    private static void printListDouble(List<Double[]> list) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] o1, Double[] o2) {
                return o1.length-o2.length;
            }
        });
        for (Double[] l : list) {
            System.out.println(Arrays.toString(l));
        }
    }


    private static void getChildren(Double[] d){
        for(int i=0;i<d.length;i++){
            Double[] d1 = new Double[d.length-1];
            int k = 0;
            for(int j = 0; j < d.length;j++){
                if(i != j){
                    d1[k++] = d[j];
                }
            }
            Double sumD1 = sumDouble(d1);
            if(isAllZheng){
                if(sumD1 < yao){
                    continue;
                }
                if(MyUtils.isEquals(sumD1, yao)){
                    System.out.println("^^得到结果："+Arrays.toString(d1));
                    list.add(d1);
                    continue;
                }
                if(d1.length>minArray){
                    getChildren(d1);
                }
            }else{
                if(MyUtils.isEquals(sumD1, yao)){
                    System.out.println("^-^得到结果："+Arrays.toString(d1));
                    list.add(d1);
                }
                if(d1.length>minArray){
                    getChildren(d1);
                }
            }
        }
    }


    private static Double sumDouble(Double[] d){
        Double sum = 0d;
        for(Double d1 : d){
            sum += d1;
        }
        return sum;
    }
    //从小到大排序
    private static void sortDouble(Double[] d) {
        for (int i = 0; i < d.length - 1; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if(d[i]>d[j]){
                    double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
    }



    /**
     * 得到从哪个数组中进行查询,如果数组都是正数时调用这个方法
     *
     * @param soure
     * @param yao
     * @return
     */
    private static Double[] getRealArray(Double[] soure, double yao) {
        int k = 0;
        for (Double d : soure) {
            if (d > yao) {
                k++;
            }
        }
        Double[] result = new Double[soure.length - k];
        int i = 0;
        for (Double d : soure) {
            if (d > yao) {
                continue;
            }
            result[i++] = d;
        }
        return result;
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
