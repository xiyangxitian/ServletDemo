package com.iotek.jee.servlet.cao;

import java.util.*;

//用随机来解决 要不要启动多线程来做。

/**
 * 终于实现了功能，这样虽然很奇怪，不过的确是解决了问题。  希望以后能找到好的方法吧。
 * 这个问题加个线程来算会提升效率吧。
 */
public class SuanScanner {

    public static void main(String[] args) throws InterruptedException {
        List<List<Double>> listAll = new ArrayList<>();
        /*
        List<Double> cun = new ArrayList<>();
        Double yao = null;
        Scanner scanner = new Scanner(System.in);
        while(true){
            double v = scanner.nextDouble();
            if(v==0){
                break;
            }
            cun.add(v);
        }
        scanner.close();
        yao = cun.get(cun.size()-1);
        cun.remove(cun.size() - 1);
        Double[] soure = new Double[cun.size()];
        for(int i=0;i<cun.size();i++){
            soure[i] = cun.get(i);
        }
        */
        Double yao = 118305.94;
        Double[] soure = {
                268.25,
                291.82,
                2.04,
                20918.48,
                159.56,
                16407.56,
                3.71,
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

        int count = 0;
        while (true) {
            List<Double> list = getCaoXiaoJie(soure, yao);
            if (!listAll.contains(list)) {
                count = 0;
                listAll.add(list);
                continue;
            }
            //连着10次总数没有增加  就认为已经查到了所有数据
            if (count++ > 10) {
                break;
            }
        }

        System.out.println("********************************************");
        System.out.println("共有" + listAll.size() + "条数据符合要求。");
        sortListListDouble(listAll);
        printListListDouble(listAll);

    }

    private static long sumCount = 1;

    public static List<Double> getCaoXiaoJie(Double[] soure, double yao) {
        Random random = new Random();
        Double[] a = null;
        boolean flag = true;
        for(Double d : soure){
            if(d<0){
                flag = false;
            }
        }
        if(flag){
            a = getRealArray(soure, yao);
        }else{
            a = soure;
        }
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
                sumCount++;
                list.clear();
                l.clear();
                continue;
            }
            if (sum == yao) {
                String result = "";
                //先对l进行排序
                Collections.sort(l);
                System.out.println("第"+(sumCount)+"次查找到数据：");
                printListDouble(l);
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

    //对List<List<Double>> 进行排序，短的在前
    private static void sortListListDouble(List<List<Double>> list) {
        Collections.sort(list, new Comparator<List<Double>>() {
            @Override
            public int compare(List<Double> o1, List<Double> o2) {
                return o1.size() - o2.size();
            }
        });
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
