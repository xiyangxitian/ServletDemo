package com.iotek.jee.servlet.cao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//用随机来解决 要不要启动多线程来做。

/**
 * 终于实现了功能，这样虽然很奇怪，不过的确是解决了问题。  希望以后能找到好的方法吧。
 * 这个问题加个线程来算会提升效率吧。
 */
public class Suan5 {

    public static void main(String[] args) throws InterruptedException {
//        Double[] a = new Double[]{1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0};
/*        Double[] soure = new Double[]{268.25d, 291.82d, 2.04d, 20918.48d, 159.56d, 3.71d, 16407.56d, 15667.35d, 25260.68d,
                15667.35d, 25260.68d, 3137.42d, 7981.88d, 17380.09d, 44962.2d, 58770.87d, 3897.08,
                7432.86, 47654.99, 319.37, 224.63, 4116.7, 25897.7, 47811d, 613.14, 4259.5,
                19426.62, 248.82, 54.64, 4698.79, 33.55, 2615d, 23d, 60.23};
        double yao = 23861.2d;*/
        Double[] soure = new Double[]{
                1.13,
                88.02,
                4957.97,
                7304.82,
                63.59,
                19496.75,
                565.32,
                1176.16,
                756.43,
                201.49,
                12660.53,
                1803.29,
                58979.65,
                340.71,
                15708.11,
                26569.53,
                34827.76,
                2179.21,
                10086.74,
                57432.2,
                10493.73,
                325.17,
                1765.24,
                8531.67,
                99.07,
                146.31,
                11413.63,
                109.38,
                1081.23,
                7714.69,
                676.66,
                9.41,
                734.76,
                2736.86,
                33.88,
                0.44,
                159.65,
                34.68,
                108.45,
                2643.99,
                19184.23,
                29657.95,
                3762.09,
                4026.74,
                947.04,
                17794.92,
                48.31,
                546.95,
                23.93,
                228.28,
                1864.71,
                11480.66,
                489.11,
                23223.58,
                297.86,
                206.51,
                2034.71,
                16105.04,
                3399.65,
                38125.23,
                642.88,
                1205.13,
                5909.44,
                2027.64,
                841.86,
                13041.86,
                26.05,
                30.77,
                0.38,
                2680.47,
                75.8,
                485.67
        };
        double yao = 35933.09;

        List<List<Double>> listAll = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<Double> list = getCaoXiaoJie(soure, yao);
            if (!listAll.contains(list)) {
                listAll.add(list);
            }
        }

        System.out.println("共有"+listAll.size()+"条数据符合要求。");
        printListListDouble(listAll);

    }

    public static List<Double> getCaoXiaoJie(Double[] soure, double yao) {
        Random random = new Random();
        Double[] a = getRealArray(soure, yao);
        List<Integer> list = new ArrayList<>();
        List<Double> l = new ArrayList<>();
        while (true) {
            int i = random.nextInt(a.length);
            if (list.contains(i)) {
                continue;
            }
            double d1 = a[i];
            list.add(i);
            l.add(d1);
            double sum = 0d;
            for (Double d : l) {
                sum += d;
            }
            if(list.size() >= soure.length){
                list.clear();
                l.clear();
                continue;
            }
            //都是正数的时候
            if(sum > yao){
                list.clear();
                l.clear();
                continue;
            }
            if (sum == yao) {
                String result = "";
                //先对l进行排序
                Collections.sort(l);
                for (Double dd : l) {
                    result += dd + "+";
                }
                result = result.substring(0, result.length() - 1);
                System.out.println("中奖了！找到了结果：" + yao + "=" + result);
                return l;
            }
        }
    }

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


    private static void printListListDouble(List<List<Double>> list) {
        for (List<Double> l : list) {
            printListDouble(l);
        }
    }

    private static void printListDouble(List<Double> list) {
        StringBuilder sb = new StringBuilder();
        for (Double l : list) {
            sb.append(l + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
