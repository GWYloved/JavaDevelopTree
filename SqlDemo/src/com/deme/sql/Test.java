package com.deme.sql;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Math.round(-11.5));
//        StringBuffer stringBuffer = new StringBuffer("hello");
//        stringBuffer.append("_world");
//        System.out.println(stringBuffer.toString());
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        List<Integer> j = new ArrayList<>(i);
       Collections.copy(i, j);
       for (int f : j){
           System.out.println(f+"");
       }
    }
}
