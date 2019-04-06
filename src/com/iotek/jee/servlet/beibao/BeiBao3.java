package com.iotek.jee.servlet.beibao;

public class BeiBao3 {
    //从m个数中取n个数共有多少个可能的组合。
    static int combin(int m, int n) {
        if (m == n || n == 0) {
            System.out.println(1);
            return 1;
        } else {
            int b = combin(m - 1, n) + combin(m - 1, n - 1);
            System.out.println(b);
            return b;
        }
    }

    //1,2,3  1,2  1,3 2,3
    //1,2,3,4  1,2,3, 1,2,4 1,3,4 2,3,4
    //1,2,3,4  1,2  1,3 1,4 2,3 2,4 3,4
    public static void main(String[] args) {
        int combin = combin(40, 20);
        System.out.println("结果:" + combin);
    }

}
