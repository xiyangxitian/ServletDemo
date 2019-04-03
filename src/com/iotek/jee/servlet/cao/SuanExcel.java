package com.iotek.jee.servlet.cao;

public class SuanExcel {

    public static void main(String[] args) {
        Double[] a = new Double[]{268.25d, 291.82d, 2.04d, 20918.48d, 159.56d, 3.71d, 16407.56d, 15667.35d, 25260.68d,
                15667.35d, 25260.68d, 3137.42d, 7981.88d, 17380.09d, 44962.2d, 58770.87d, 3897.08,
                7432.86, 47654.99, 319.37, 224.63, 4116.7, 25897.7, 47811d, 613.14, 4259.5,
                19426.62, 248.82, 54.64, 4698.79, 33.55, 2615d, 23d, 60.23};
        sort(a);
        for( int i = 0;i<a.length;i++){
            System.out.print(a[i] + "\n");
        }
    }

    //排序  从大到小
    private static void sort(Double[] d){
        for(int i=0;i<d.length;i++){
            for(int j=i+1;j<d.length;j++){
                if(d[i]<d[j]){
                    Double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
    }



}
