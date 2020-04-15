package com.wyp.basics;

import java.util.ArrayList;
import java.util.List;

public class SubListFailFast {
    public static void main(String[] args) {
        List masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);
        branchList.forEach(System.out::println);

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.add("eight");
        branchList.add("nigh");
        branchList.add("ten");
        branchList.remove(0);

        branchList.forEach(System.out::println);
        System.out.println("args = [" + args + "]");
        masterList.forEach(System.out::println);

    }
}
