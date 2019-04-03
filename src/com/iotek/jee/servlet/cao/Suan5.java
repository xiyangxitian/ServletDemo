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
        double yao = 118305.94;

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
            if (sum < yao) {
                continue;
            }
            if (sum > yao) {
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
