package com.wyp.basics;

import javafx.util.Pair;

import java.util.*;

public class AliPq {


    public static List<Integer> getTopList(List<Integer> inputList){
        final Integer NUM_SIZE = 100;
        List<Integer> resultList = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(NUM_SIZE, Comparator.comparing(Integer::intValue));
        for(Integer x : inputList){
            pq.add(x);
            if (pq.size() > NUM_SIZE) {
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            resultList.add(pq.poll());
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list1.add(i);
        }

        getTopList(list1).stream().forEach(System.out::println);

    }
}
