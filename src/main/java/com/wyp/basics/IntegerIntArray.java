package com.wyp.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class IntegerIntArray {
    public static void main(String[] args) {

        int[] data = {2, 4, 7, 2, 3, 9};
        // int[] to List<Integer>
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());

        // int[] to Integer[]
        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);

        // List<Integer> to Integer[]
        Integer[] integers2 = list1.toArray(new Integer[0]);

        // List<Integer> to int[]
        int[] data2 = list1.stream().mapToInt(Integer::intValue).toArray();

        //Arrays.stream(data2).forEach(System.out::println);
        // Integer[] -> int[]
        int[] data3 = Arrays.stream(integers1).mapToInt(Integer::intValue).toArray();
        //Arrays.stream(data3).forEach(System.out::println);

        // Integer[] -> List<Integer>
        List<Integer> list3 = Arrays.asList(integers2);

    }
}
