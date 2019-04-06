package test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        System.out.println(list.add(0));
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.set(2, 3);
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    public void test3(){
        System.out.printf("%d ", 1);
        System.out.printf("%d ", 2);
        System.out.printf("%d ", 3);
    }
    @Test
    public void test4(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        List<List<Integer>> list = new ArrayList<>();

        list.add(l1);
        System.out.println(list);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(5);
//        l3 = l1;
        System.out.println(l1.size()==l3.size());
        list.add(l3);
        System.out.println(list);
    }
    @Test
    public void test5(){

    }
    @Test
    public void test6(){

    }
    @Test
    public void test7(){

    }



}
