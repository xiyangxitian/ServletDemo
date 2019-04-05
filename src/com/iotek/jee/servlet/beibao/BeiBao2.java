package com.iotek.jee.servlet.beibao;

import com.iotek.jee.servlet.util.MyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeiBao2 {

    public static void main(String[] args) {
        Double[] d = {1.0,2.0,3.0};
        getAllChildren(d);
//        System.out.println("*********************");
//        System.out.println("所有结果：");
//        System.out.println(Arrays.toString(list.toArray()));
    }

    static Double yao = 5.0;
    static List<Double[]> list = new ArrayList<>();
    //有重复数据，这样不行。
    public static void getAllChildren(Double[] d) {
        for (int i = 0; i < d.length; i++) {
            Double[] d1 = new Double[d.length - 1];
            int k = 0;
            for (int j = 0; j < d.length; j++) {
                if (i != j) {
                    d1[k++] = d[j];
                }
            }
            System.out.println(Arrays.toString(d1));
//            if(MyUtils.isEquals(MyUtils.sumDouble(d1), yao)){
//                System.out.println("找到结果:"+Arrays.toString(d1));
//                list.add(d1);
//            }
            if(d1.length>1){
                getAllChildren(d1);
            }
        }
    }



}
