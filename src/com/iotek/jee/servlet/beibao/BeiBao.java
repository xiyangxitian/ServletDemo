package com.iotek.jee.servlet.beibao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0-1背包经典问题来解决 从n个数中取任意个数 和为sum
 * 共有多少种可能
 */
public class BeiBao {
    /**从arr数组中取n个数，使和为sum
     * function findGroup(arr,n,sum){
     *     if(sum == 0 && n == 0){
     *         return true;
     *     }else if(n <= 0){
     *         return false;
     *     }
     *     if(n > 0)
     *         for(var i = 0; i < arr.length; i++){
     *             var temp = arr.slice(i+1,arr.length);
     *             return findGroup(temp,n-1,sum-arr[i]) || findGroup(temp,n,sum);
     *         }
     * }
     */

    private static List<Double> list = new ArrayList<>();
    //取n的第一个数
    public static boolean findGroup(Double[] doubles, int n,Double sum) {
        if (sum == 0 && n==0) {
            System.out.println("有结果了");
            return true;
        } else if (n <= 0) {
            return false;
        }

        if (n > 1) {
            for (int i = 0; i < doubles.length; i++) {
                Double[] temp = new Double[doubles.length - 1];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = doubles[j+1];
                }
                return findGroup(temp, n-1,sum-doubles[i]) || findGroup(temp, n, sum);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Double[] n = {3.0,6.0,4.0,7.0};
        Double sum = 10.0;
        findGroup(n, 2, sum);
    }


}
