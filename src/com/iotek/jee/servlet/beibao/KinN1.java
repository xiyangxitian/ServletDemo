package com.iotek.jee.servlet.beibao;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KinN1 {
    /*
     * n:1....n个数字
     * k:每次递归需要选出k个数字，每次调用依次减1
     * d：存放结果的数组，循环使用
     * num：一共选出num个数字
     */
    static void recursive_fun(int n, int k, List<Integer> d, int num, List<Integer> l) {

//        int i = n;
//        if (k > n) return;
//        System.out.printf("*******[n=%d,k=%d,d=%s,num=%d,i=%d]\n", n, k, d.toString(), num, i);
        //循环递减设置本层的数字，例如：第一层递归5xx,4xx;第二层递归，x4x，x3x。 当i<k时（举例：当k=3时，第一层数字不能小于3，否则构不成3个数字的序列），退出。
        while (n >= k) {
            d.set(num - k, n - 1);
            //k>1 代表取出的数字不足，需要继续调用递归
            if (k > 1) {
                recursive_fun(n - 1, k - 1, d, num, l);
            } else { //取满打印
//                int j = 0;
//                while (j < num) {
//                    System.out.printf("%d ", d.get(j));
//                    j++;
//                }
//                System.out.printf("======[n=%d,k=%d,d=%s,num=%d,i=%d]\n", n, k, d.toString(), num, i);
//                System.out.println(d.toString());
//                System.out.println("l:" + Arrays.toString(l.toArray()));
                for (int i : d) {
                    //数组太长的时候这里会内存出来
                    l.add(i);
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
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                d.add(0);
            }
            int s = n;
            recursive_fun(s, k, d, k, l);
//            System.out.println("---d:" + d.toString());
//            System.out.println("---l:" + l.toString());
            for (int i = 0; i < l.size(); i++) {
                if (i % k == 0) {
                    Double[] children = new Double[k];
                    int temp = 0;
                    for (int j = i; j < i + k; j++) {
                        children[temp++] = source[l.get(j)];
                    }
//                System.out.println("children:" + Arrays.toString(children));
                    if (isAllBiggerZero) {
                        if (MyUtils.sumDouble(children) > yao) {
                            continue;
                        } else if (MyUtils.sumDouble(children) == yao) {
                            System.out.println("查出结果:" + Arrays.toString(children));
                            list.add(children);
                        } else {
                            break;
                        }
                    } else {
                        if (MyUtils.sumDouble(children) == yao) {
                            System.out.println("查出结果:" + Arrays.toString(children));
                            list.add(children);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
//        int n = 5;// 1,2,3,4,5
//        int k = 3;//取出3个数
//
//        n = 5;
//        k = 3;
//        List<Integer> d = new ArrayList<>(k);
//        //初始化list
//        for (int i = 0; i < k; i++) {
//            d.add(0);
//        }
//        List<Integer[]> l = new ArrayList<>();
//        recursive_fun(n, k, d, k, l);
//        System.out.println("---l:" + l.toString());


        double[] source = {

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
        Arrays.sort(source);
        List<Double[]> list = new ArrayList<>();
        getChildren(source, list, false, 118305.94);
    }


}