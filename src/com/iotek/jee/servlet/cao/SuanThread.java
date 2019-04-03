package com.iotek.jee.servlet.cao;

public class SuanThread implements Runnable {

    private Double[] soure = new Double[]{268.25d, 291.82d, 2.04d, 20918.48d, 159.56d, 3.71d, 16407.56d, 15667.35d, 25260.68d,
            15667.35d, 25260.68d, 3137.42d, 7981.88d, 17380.09d, 44962.2d, 58770.87d, 3897.08,
            7432.86, 47654.99, 319.37, 224.63, 4116.7, 25897.7, 47811d, 613.14, 4259.5,
            19426.62, 248.82, 54.64, 4698.79, 33.55, 2615d, 23d, 60.23};
    private double yao = 23861.2d;
    @Override
    public void run() {
        Suan5.getCaoXiaoJie(soure, yao);
    }


    public static void main(String[] args) {
        for(int i=100;i<=200;i++){
            new Thread(new SuanThread(), "线程"+i).start();
        }

    }



}
