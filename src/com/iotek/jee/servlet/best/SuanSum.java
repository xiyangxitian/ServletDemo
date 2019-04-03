package com.iotek.jee.servlet.best;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从一个数组中选择等于指定值的最快方案（自己写程序实现）
 */
public class SuanSum {


    private Double[] source = {1.0, 2.0, 3.0};
    private Double yao = 3.0;

    private static void calResult(Double[] d){
        Double sum = 0d;
        List<Integer> pointer = new ArrayList<>();//指针，指到哪了。
        Map<Integer,Integer> map = new HashMap<>();//第几个指针的到哪了
        for(int i = 0; i < d.length; i++){
            pointer.add(i);
        }


    }

    private static void sortDouble(Double[] d) {
        for (int i = 0; i < d.length - 1; i++) {
            for (int j = i + 1; j < d.length; j++) {
                double temp = d[i];
                d[i] = d[j];
                d[j] = temp;
            }
        }
    }


    /**
     * 得到从哪个数组中进行查询,如果数组都是正数时调用这个方法
     *
     * @param soure
     * @param yao
     * @return
     */
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

}
