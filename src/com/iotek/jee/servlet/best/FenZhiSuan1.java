package com.iotek.jee.servlet.best;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.*;

public class FenZhiSuan1 {

//    static Double[] source = new Double[]{
//            1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0,
//            9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0
//    };
    static Double[] source= {268.25,
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
            60.23};
    static double yao = 4732.34;


    public static void main(String[] args) {
        //1.把数组分成多个数组
        List<Double[]> list = fenSource(source, 8, new ArrayList<>());
        int size = list.size();//共有size个部分
        System.out.println("分成了"+size+"部分来进行计算");
        //2.每个部分的所有可能性都求出来。 也就是所有的和的可能
        //第几部分的和的可能值的情况
        Map<Integer, List<Double>> map = new HashMap<>();
        Map<Integer, Integer> mapPointer = new HashMap<>();//记录每部分的游标
        for (int i = 0; i < size; i++) {
            Double[] d = list.get(i);
            map.put(i, getAllSum(d, new ArrayList<>()));
            mapPointer.put(i, 0);//开始时指针都在0位置
        }
        System.out.println("第2步完成");
        //3.每个部分的和各取出一个相加，如果相等于yao的值，那么这就是一种可能。记录下来所有的可能
        //出问题了，这里相加又是一个超级天文大数字,有没有什么办法呢
        //所以分的组多了这里计算就太慢了，分的少了分组中的计算就慢了。甚至计算不出来。
        //要怎么分才合理呢。肯定要10以下。这里试试吧。
        List<Double[]> jilu = new ArrayList<>();//记录正确的结果 第一个数对应第一部分，。。。。

        //几部分就有几个循环,所以部分尽量控制在2个  不知道3个能不能行
        boolean flag = false;
//        long cishu = 0l;
        Double[] dj = new Double[size];
        for(int i=0;i<map.get(0).size();i++){
            dj[0] = map.get(0).get(i);
            for(int j=0;j<map.get(1).size();j++){
                dj[1] = map.get(1).get(j);
                for(int k = 0;k<map.get(2).size();k++){
                    dj[2] = map.get(2).get(k);
                    if(MyUtils.isEquals(sumDouble(dj), yao)){
                        jilu.add(dj);
                    }
                }
            }
        }
        System.out.println("第3步完成");
        System.out.println("一共有" + jilu.size() + "个满足的和结果");
        //4.求出具体的结果

    }

    private static List<Double> getFenSum(List<Double[]> list) {

        return null;
    }

    /**
     * 根据数组得到所有的可能的子数组的和的情况
     *
     * @param d
     * @return
     */
    private static List<Double> getAllSum(Double[] d, List<Double> sumList) {
        for (int i = 0; i < d.length; i++) {
            Double[] d1 = new Double[d.length - 1];
            int k = 0;
            for (int j = 0; j < d.length; j++) {
                if (i != j) {
                    d1[k++] = d[j];
                }
            }
            sumList.add(sumDouble(d1));
            if (d1.length > 1) {
                getAllSum(d1, sumList);
            }
        }
        return sumList;
    }

    /**
     * f求数组的和
     *
     * @param d
     * @return
     */
    private static Double sumDouble(Double[] d) {
        Double sum = 0d;
        for (Double d1 : d) {
            sum += d1;
        }
        return sum;
    }

    /**
     * 把一个数组分成多个数组，每个数组的长度是n，最后一个可以小于n
     *
     * @param source
     */
    private static List<Double[]> fenSource(Double[] source, int n, List<Double[]> list) {
        if (source.length > n) {
            Double[] jiechu = jieChu(source, n);
            Double[] jiesheng = jieSheng(source, n);
            list.add(jiechu);
            source = jiesheng;
            fenSource(source, n, list);
        } else if (source.length <= n) {
            list.add(source);
        }
        return list;
    }

    /**
     * 把一个数组从前面截n个，获得的n个数的数组
     * n在小于10的时候会比较快  建议选8
     *
     * @param d
     */
    private static Double[] jieChu(Double[] d, int n) {
        if (d.length <= n) {
            return d;
        }
        Double[] d1 = new Double[n];
        for (int i = 0; i < n; i++) {
            d1[i] = d[i];
        }
        return d1;
    }

    /**
     * 把一个数组从前面截n个之后剩余的部分,是大于n的数组，否则别调用这个方法
     */
    private static Double[] jieSheng(Double[] d, int n) {
        if (d.length <= n) {
            return null;
        }
        Double[] d1 = new Double[d.length - n];
        int k = 0;
        for (int i = n; i < d.length; i++) {
            d1[k++] = d[i];
        }
        return d1;
    }


}
