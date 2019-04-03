package com.iotek.jee.servlet.cao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//从数组中选择n-1个的情况
public class CalExcel {

    public static void main(String[] args) {
        Double[] a = new Double[]{268.25d, 291.82d, 2.04d, 20918.48d, 159.56d, 3.71d, 16407.56d, 15667.35d, 25260.68d,
                15667.35d, 25260.68d, 3137.42d, 7981.88d, 17380.09d, 44962.2d, 58770.87d, 3897.08,
                7432.86, 47654.99, 319.37, 224.63, 4116.7, 25897.7, 47811d, 613.14, 4259.5,
                19426.62, 248.82, 54.64, 4698.79, 33.55, 2615d, 23d, 60.23};
        //a= new Double[]{1.0,2.0,3.0};
        Double[][] d = calD(a);
        /*for(Double[] d1 : d){
           System.out.println(Arrays.toString(d1));
        }*/
//        printD(d, 23861.2d);
        List<Double[]> l = new ArrayList<Double[]>();
        l.add(a);
        /*
        calF(l, 23861.2d);*/
        double yao = 23861.2d;
        List<Double[]> list = calG(l, l.get(0).length-1);
        System.out.println(list.size());

        list = calG(l, l.get(0).length-2);
        System.out.println(list.size());
        Double[] resultD = haveYao(list, yao);
        System.out.println("resultD1:"+resultD);

        list = calG(l, l.get(0).length-3);
        System.out.println(list.size());
        resultD=haveYao(list,yao);
        System.out.println("resultD2:"+resultD);

        list = calG(l, l.get(0).length-4);
        System.out.println(list.size());
        resultD=haveYao(list,yao);
        System.out.println("resultD3:"+resultD);

//        printList(list);
    }

    private  static Double[] haveYao(List<Double[]> list,Double yao){
        Double[] result = null;
        for(Double[] d : list){
            if(sumArray(d)==yao){
                return d;
            }
        }
        return null;
    }
    private static void printList(List<Double[]> list){
        for(Double[] d : list){
            System.out.println(Arrays.toString(d));
        }
    }

    //数组取出个次数组的所有可能
    private static Double[][] calD(Double[] array) {
        Double[][] result = new Double[array.length][array.length - 1];
        for (int i = 0; i < array.length; i++) {
            Double[] array1 = new Double[array.length - 1];
            boolean flag = false;
            for (int j = 0; j < array.length; j++) {
                if (j == i) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    array1[j - 1] = array[j];
                } else {
                    array1[j] = array[j];
                }
            }
            result[i] = array1;
        }
        return result;
    }

    //比给的数组小2的
    public static List<Double[]> calE(Double[] array) {
        List<Double[]> list = new ArrayList<Double[]>();
        Double[][] d = calD(array);
        for (Double[] d1 : d) {
            Double[][] d2 = calD(d1);
            for (Double[] d3 : d2) {
                list.add(d3);
            }
        }
        return list;
    }

    private static List<Double[]> calF(List<Double[]> l,Double yao) {
        boolean flagAll = true;
        List<Double[]> list = new ArrayList<Double[]>();
        for (Double[] array : l) {
            for (int i = 0; i < array.length; i++) {
                Double[] array1 = new Double[array.length - 1];
                boolean flag = false;
                for (int j = 0; j < array.length; j++) {
                    if (j == i) {
                        flag = true;
                        continue;
                    }
                    if (flag) {
                        array1[j - 1] = array[j];
                    } else {
                        array1[j] = array[j];
                    }
                }
                list.add(array1);
            }
        }
        for(Double[] d : list){
            if(sumArray(d)==yao){
                flagAll = true;
                list.clear();
                list.add(d);
                break;
            }
        }
        if(list.size()<3){
            list.clear();
            return list;
        }
        if(flagAll){
            calF(list, yao);
        }
        return list;
    }

    public static Double sumArray(Double[] d) {
        Double sum = 0d;
        for (Double d1 : d) {
            sum += d1;
        }
        return sum;
    }

    //n是指要得到的数据长度
    private static List<Double[]> calG(List<Double[]> l,int n) {
        List<Double[]> list = new ArrayList<Double[]>();
        for (Double[] array : l) {
            for (int i = 0; i < array.length; i++) {
                Double[] array1 = new Double[array.length - 1];
                boolean flag = false;
                for (int j = 0; j < array.length; j++) {
                    if (j == i) {
                        flag = true;
                        continue;
                    }
                    if (flag) {
                        array1[j - 1] = array[j];
                    } else {
                        array1[j] = array[j];
                    }
                }
                list.add(array1);
            }
        }
        if(list.get(0).length>n){
            list = calG(list, n);
        }
        return list;
    }

}
