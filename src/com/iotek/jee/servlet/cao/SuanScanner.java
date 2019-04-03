package com.iotek.jee.servlet.cao;

import javax.xml.transform.Source;
import java.util.*;

//用随机来解决 要不要启动多线程来做。

/**
 * 终于实现了功能，这样虽然很奇怪，不过的确是解决了问题。  希望以后能找到好的方法吧。
 * 这个问题加个线程来算会提升效率吧。
 */
public class SuanScanner {

    public static void main(String[] args) throws InterruptedException {
        List<List<Double>> listAll = new ArrayList<>();
        List<Double> cun = new ArrayList<>();

        Double yao = null;
        int biao = 0;
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

        for (int i = 0; i < 100; i++) {
            List<Double> list = getCaoXiaoJie(soure, yao);
            if (!listAll.contains(list)) {
                listAll.add(list);
            }
        }


        System.out.println("共有"+listAll.size()+"条数据符合要求。");
        sortListListDouble(listAll);
        printListListDouble(listAll);

    }

    public static List<Double> getCaoXiaoJie(Double[] soure, double yao) {
        Random random = new Random();
        Double[] a = getRealArray(soure, yao);
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
                list.clear();
                l.clear();
                continue;
            }
            if (sum == yao) {
                String result = "";
                //先对l进行排序
                Collections.sort(l);
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
                return o1.size()-o2.size();
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
