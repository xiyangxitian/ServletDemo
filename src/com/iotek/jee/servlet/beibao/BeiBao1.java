package com.iotek.jee.servlet.beibao;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0-1背包经典问题来解决 从n个数中取任意个数 和为sum
 * 共有多少种可能
 */
public class BeiBao1 {
    /**
     * 从arr数组中取n个数，使和为sum
     * function findGroup(arr,n,sum){
     * if(sum == 0 && n == 0){
     * return true;
     * }else if(n <= 0){
     * return false;
     * }
     * if(n > 0)
     * for(var i = 0; i < arr.length; i++){
     * var temp = arr.slice(i+1,arr.length);
     * return findGroup(temp,n-1,sum-arr[i]) || findGroup(temp,n,sum);
     * }
     * }
     */

    private static List<Double> list = new ArrayList<>();

    //取n的第一个数
    //flag代表是否取第一个数
    public static boolean findGroup(Double[] doubles, Double sum) {
        if(doubles.length>0){
            list.add(doubles[0]);
        }
        if (sum == 0) {
            System.out.println("有结果了");
            System.out.println(Arrays.toString(list.toArray()));
            return true;
        }
        if (doubles.length <= 0) {
            list.clear();
            return false;
        }

        Double[] temp = new Double[doubles.length - 1];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = doubles[j + 1];
        }
        //回溯法。最终是可以得到一个结果的。
        return findGroup(temp, sum - doubles[0]) || findGroup(temp, sum);
    }
    //取n的第一个数
    //flag代表是否取第一个数
    public static boolean findGroup1(Double[] doubles, List<Double> sum,Double yao) {
        if(doubles.length>0){
            list.add(doubles[0]);
        }
        if (MyUtils.isEquals(sum, yao)) {
            System.out.println("有结果了");
            System.out.println(Arrays.toString(sum.toArray()));
            return true;
        }
        if (doubles.length <= 0) {
            list.clear();
            return false;
        }

        Double[] temp = new Double[doubles.length - 1];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = doubles[j + 1];
        }
        //回溯法。最终是可以得到一个结果的。
//        return findGroup(temp, sum.add(doubles[0])) || findGroup(temp, sum);
        return findGroup1(temp, sum.add(doubles[0])?sum:sum, yao)||findGroup1(temp, sum, yao);
    }


    public static void main(String[] args) {
        Double[] n = {8.0, 4.0, 5.0, 10.0, 3.0};
        Double sum = 7.0;
        findGroup(n, sum);
    }


}
