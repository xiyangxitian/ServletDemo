package com.iotek.jee.servlet.cao;

public class Suan3 {


    private static int sum = 3;
    private static int[] a = {1,2,3,4,5};
    static int index = 1;
    static int[][] result = new int[a.length][];

    //从小到大排序
    private static void sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    //得到真实想要的表
    private static int[] getArray(int[] a){
        if(a[a.length-1] < sum){
            return a;
        }
        if(a[0]>sum){
            return null;
        }
        for(int i = 0; i < a.length; i++){
            if(a[i]>sum){
                int[] b = new int[i-1];
                for(int j = 0; j < b.length; j++){
                    b[j] = a[j];
                }
                return b;
            }
        }
        return null;
    }

    static void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    //数组中所有的排列情况
    //取1个 的时候情况
    //取2个 的时候
    //..
    //取数组长度的时候  -- 一种

    static int[][] getResult(int[] a,int index){

        //取第index个数  共有的可能数是
        int m = a.length;
        int n = index;
        int cMn = getJie(m)/(getJie(n)*getJie(m-n));
        int[][] returnResult = new int[cMn][index];
        int startNum = 0;
        if(index==1){
            for(int i = 0; i < a.length; i++){
                int[] arr = new int[index];
                arr[0] = a[i];
                returnResult[startNum++] = arr;
            }
            return returnResult;
        }
        for(int i = 0; i < a.length; i++){
            int[] arr = new int[index];
            arr[0] = a[i];
            a = jieDuan(a,i);
            getResult(a, index-1);
        }
        return null;
    }

    private static int[] jieDuan(int[] a,int r) {
        int[] result = new int[a.length-r-1];
        int k = 0;
        for(int i= r+1;i<a.length;i++){
            result[k++] = a[i];
        }
        return result;
    }

    //求一个数据的阶乘
    static int getJie(int n){
        if(n==1){
            return 1;
        }else{
          return  n * getJie(n-1);
        }
    }



    public static void main(String[] args) {
        sort(a);
        a = getArray(a);
        //结果
        int[][] result = new int[a.length][];

        printArray(a);
    }

}
