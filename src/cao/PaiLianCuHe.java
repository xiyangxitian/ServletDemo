package cao;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列组合详细情况
 */
public class PaiLianCuHe {
    /*
     * n:1....n个数字
     * k:每次递归需要选出k个数字，每次调用依次减1
     * d：存放结果的数组，循环使用
     * num：一共选出num个数字
     */
    static void recursive_fun(int n, int k, List<Integer> d, int num) {

        int i = n;
        if (k > n) return;
        System.out.printf("*******[n=%d,k=%d,d=%s,num=%d,i=%d]\n", n, k, d.toString(), num, i);
        //循环递减设置本层的数字，例如：第一层递归5xx,4xx;第二层递归，x4x，x3x。 当i<k时（举例：当k=3时，第一层数字不能小于3，否则构不成3个数字的序列），退出。
        while (i >= k) {
            d.set(num - k, i);
            //k>1 代表取出的数字不足，需要继续调用递归
            if (k > 1) {
                recursive_fun(i - 1, k - 1, d, num);
            } else { //取满打印
                int j = 0;
                while (j < num) {
                    System.out.printf("%d ", d.get(j));
                    j++;
                }
                System.out.printf("======[n=%d,k=%d,d=%s,num=%d,i=%d]\n", n, k, d.toString(), num, i);
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int n = 5;// 1,2,3,4,5
        int k = 3;//取出3个数
        List<Integer> d = new ArrayList<>(k);
        //初始化list
        for (int i = 0; i < k; i++) {
            d.add(0);
        }
        recursive_fun(n, k, d, k);
    }
}
