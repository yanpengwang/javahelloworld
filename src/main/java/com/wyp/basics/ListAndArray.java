package com.wyp.basics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAndArray {
    public static void main(String[] args){

        String[] array = {"apple", "pear"};
        List<String> list = Arrays.asList(array);
        array = list.toArray(array);
        for(String x : array){
            System.out.println(x);
        }
        array[0] = "fish";
        list.forEach(System.out::println);
        //list.add("fish");
        List<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add(0, "I am");
        list2.stream().forEach(System.out::println);


    }
}
