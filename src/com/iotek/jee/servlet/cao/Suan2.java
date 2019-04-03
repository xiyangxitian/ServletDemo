package com.iotek.jee.servlet.cao;

import java.util.Arrays;

public class Suan2 {

    public static void main(String[] args) {
        Double[] soruce = new Double[]{268.25d, 291.82d, 2.04d, 20918.48d, 159.56d, 3.71d, 16407.56d, 15667.35d, 25260.68d,
                15667.35d, 25260.68d, 3137.42d, 7981.88d, 17380.09d, 44962.2d, 58770.87d, 3897.08,
                7432.86, 47654.99, 319.37, 224.63, 4116.7, 25897.7, 47811d, 613.14, 4259.5,
                19426.62, 248.82, 54.64, 4698.79, 33.55, 2615d, 23d, 60.23};

        sort(soruce);
        Double yao = 23861.2d;

        Double[] a = null;
        int newALength = 0;
        for (int i = 0; i < soruce.length; i++) {
            if(i>yao){
                continue;
            }
            if(a==null){
                a = new Double[soruce.length-i];
            }
            a[newALength++] = soruce[i];
        }


        Double sumA = 0D;
        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
        }
        if (sumA == yao) {
            System.out.println("原始数据就是想要的数");
            return;
        }
        if (sumA < yao) {
            System.out.println("所有的数加起来都没有你想要的数大");
            return;
        }
        for (int i = 2; i < 30; i++) {
            Double sum = 0d;
            Double[] a1 = new Double[a.length - i];
            for (int j = 0; j < a.length - i; j++) {
                a1[j] = a[j];
                sum += a[j];
            }
            if (sum == yao) {
                System.out.println("想要的数据就是：数据的前" + (a.length - i) + "个");
                return;
            }
            if (sum > yao) {
                System.out.println("数比要想要的还大，进行下一轮");
                continue;
            } else {
                System.out.println("数比想要的数据要小了");
            }
            Double[] b = new Double[i];
            for (int k = 0; k < i; k++) {
                b[k] = a[a.length - i + k];
            }
            Double[][] doubles = calD(b);
            for (Double[] d1 : doubles) {
                Double bSum = sumDouble(d1);
                Double sumAB = sum + bSum;
                if (sumAB == yao) {
                    System.out.println("想要的数据是:" + Arrays.toString(a1) + "\t" + Arrays.toString(d1));
                    return;
                }
            }

        }
    }


    //排序  从大到小
    private static void sort(Double[] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[i] < d[j]) {
                    Double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
    }


    private static Double sumDouble(Double[] d) {
        Double sum = 0D;
        for (Double d1 : d) {
            sum += d1;
        }
        return sum;
    }


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

}
