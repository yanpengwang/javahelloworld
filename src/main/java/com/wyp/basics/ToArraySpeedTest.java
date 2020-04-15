package com.wyp.basics;

import java.util.ArrayList;
import java.util.List;

public class ToArraySpeedTest {
    private static final int COUNT = 100 * 100 * 100;

    public static void main(String[] args){
        List<Double> list = new ArrayList<>(COUNT);
        for(int i = 0; i < COUNT; i++) {
            list.add(i * 1.0);
        }

        Double[] notEnoughArray = new Double[COUNT - 1];
        long start = System.nanoTime();

        list.toArray(notEnoughArray);

        long middle1 = System.nanoTime();

        Double[] equalArray = new Double[COUNT];

        long middle2 = System.nanoTime();
        list.toArray(equalArray);
        long end = System.nanoTime();
        System.out.println(middle1 - start);
        System.out.println(end - middle2);

    }
}
