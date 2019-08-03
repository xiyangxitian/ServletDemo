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
        Double yao = -136996.6;
        Double[] soure = {
                -200399.26,
                -420001d,
                -125103.6,
                -54644.99,
                -113299.48,
                -807715.47,
                -100000d,
                -86623d,
                -271681.97,
                -51000d,
                -300000d,
                -994356.41,
                -264884.2,
                -66816.02,
                -90737.97,
                -360000d,
                -44300d,
                -80000d,
                -56222.81,
                -54501.4,
                -341679.73,
                -120000d,
                -200000d,
                -1250856.16,
                -70000d,
                -472280.27,
                -304645.85,
                -33889.9,
                -104632.5,
                -50000d,
                -145274.01,
                -31260d,
                -157248d,
                -923819.43,
                -330757d,
                -49161d,
                -338000d,
                -85000d,
                -387246.5,
                -80103.74,
                -50000d,
                -392138.76,
                -48781.5,
                -100000d,
                -27843d,
                -50000d,
                43748.27,
                -93009.19,
                -50000d,
                -50000d,
                -29510.8,
                -70000d,
                -40000d,
                -477000d,
                -68772.5,
                -52458.45,
                -1749508.8,
                -30000d,
                -100752.25,
                -29999.7,
                -337573.2,
                -39850d,
                -46103.88,
                -41600d,
                -36450d,
                74096.83,
                -93220.01,
                -49977.49,
                -100000d,
                -69999.98,
                -50000d,
                19150d,
                -50000d,
                -60000d,
                -30093.7,
                -413169d,
                -24805.52,
                -1026275.88,
                -2099925.72,
                -448566.41,
                -15940.6,
                0.7,
                -36846d,
                -166000d,
                -125920d,
                -237571.96,
                -296420.1,
                0.8
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

    /**
     *
     * @param soure
     * @param yao
     * @return
     */
    public static List<Double> getCaoXiaoJie(Double[] soure, double yao) {
        Random random = new Random();
        Double[] a = null;
        boolean flag = true;
        for (Double d : soure) {
            if (d < 0) {
                flag = false;
            }
        }
        if (flag) {
            a = getRealArray(soure, yao);
        } else {
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
            //都是正数的时候这样可以
            if (flag && sum < yao) {
                continue;
            }
            if (l.size() >= soure.length) {
                sumCount++;
                list.clear();
                l.clear();
                continue;
            }
            if (sum == yao) {
                String result = "";
                //先对l进行排序
                Collections.sort(l);
                System.out.println("第" + (sumCount) + "次查找到数据：");
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
