package com.iotek.jee.servlet.cao;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

public class TestAA {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        System.out.println(l);
        l.remove(1);
        System.out.println(l);
        l.add(1,5);
        System.out.println(l);

    }


}
