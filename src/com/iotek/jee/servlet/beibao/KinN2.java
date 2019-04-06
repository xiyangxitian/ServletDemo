package com.iotek.jee.servlet.beibao;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KinN2 {
    /*
     * n:1....n个数字
     * k:每次递归需要选出k个数字，每次调用依次减1
     * d：存放结果的数组，循环使用
     * num：一共选出num个数字
     */
    static void recursive_fun(int n, int k, List<Integer> d, int num) {
        while (n >= k) {
            d.set(num - k, n - 1);
            //k>1 代表取出的数字不足，需要继续调用递归
            if (k > 1) {
                recursive_fun(n - 1, k - 1, d, num);
            } else { //取满打印
//                System.out.println(d);
                double[] children = new double[d.size()];
                int count = 0;
                for (int i : d) {
                    children[count++] = source[i];
                }
                double sum = 0d;
                for (double i : children) {
                    sum += i;
                }
                if (isAllBiggerZero) {
                    if (yao == sum) {
                        System.out.println("找到结果：" + Arrays.toString(children));
                        list.add(children);
                    } else if (yao > sum) {
                        return;
                    }
                } else {
                    if (yao == sum) {
                        System.out.println("找到结果：" + Arrays.toString(children));
                        list.add(children);
                    }
                }
            }
            n--;
        }
    }

    //一个数组的所有的子数组 isAllBiggerZero是否全部大于0的数
    static void getChildren(double[] source, List<Double[]> list, boolean isAllBiggerZero, double yao) {
        int n = source.length;
        for (int k = n; k > 0; k--) {
            List<Integer> d = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                d.add(0);
            }
            int s = n;
            recursive_fun(s, k, d, k);
        }
    }

    static double[] source = {
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
    static boolean isAllBiggerZero = false;
    static List<double[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Arrays.sort(source);
        List<Double[]> l = new ArrayList<>();
        getChildren(source, l, false, 118305.94);
        System.out.println("一共有结果数量:" + list.size());
    }


}