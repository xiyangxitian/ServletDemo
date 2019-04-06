package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
