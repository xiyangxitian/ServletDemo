package cao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SuanSum {
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

    static void getAllResult() {
        Arrays.sort(source);
        if (isAllBiggerZero && source[source.length - 1] > yao) {
            //要取所有数组元素小于这个的
            int len = 0;
            for (int i = 0; i < source.length; i++) {
                if (source[i] > yao) {
                    break;
                }
                len++;
            }
            double[] realSource = new double[len];
            for (int i = 0; i < len; i++) {
                realSource[i] = source[i];
            }
            getChildren(source, new ArrayList<>(), false, 118305.94);
            System.out.println("一共有结果数量:" + list.size());
        } else {
            getChildren(source, new ArrayList<>(), false, 118305.94);
            System.out.println("一共有结果数量:" + list.size());
        }
    }

    static double[] source = {
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
    static double yao =  35933.09;
    static boolean isAllBiggerZero = true;
    static List<double[]> list = new ArrayList<>();


    public static void main(String[] args) {
        long s1 = new Date().getTime();
        Arrays.sort(source);
        List<Double[]> l = new ArrayList<>();
        getChildren(source, new ArrayList<>(), false, 118305.94);
        long s2 = new Date().getTime();
        long haomiao = s2 - s1;
        long miao = haomiao / 1000;
        long minute = miao / 60;
        long hour = minute / 60;
        System.out.println(source.length + "个数，查找所有可能，共用时：" + haomiao + "毫秒");
        System.out.println(source.length + "个数，查找所有可能，共用时：" + miao + "秒");
        System.out.println(source.length + "个数，查找所有可能，共用时：" + minute + "分钟");
        System.out.println(source.length + "个数，查找所有可能，共用时：" + hour + "小时");
        System.out.println("一共有结果数量:" + list.size());
    }

}
