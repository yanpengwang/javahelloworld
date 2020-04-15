package com.wyp.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AliMergeList {

    static class Node{
        Node(int val){
            this.val = val;
        }
        int val;
        Node next;
    }
    public static Node merge(Node l1, Node l2){
        Node answer = new Node(0);
        Node current = answer;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 == null){
            current.next = l2;
        } else {
            current.next = l1;
        }
        return answer.next;
    }
    public static void main(String[] args) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();

        for(int i = 0; i < 10; i+=2){
            Node n = new Node(i);
            list1.add(n);
        }
        for(int i = 0; i < 4; i++){
            list1.get(i).next = list1.get(i+1);
        }

        for(int i = 1; i < 10; i+=2){
            Node n = new Node(i);
            list2.add(n);
        }
        for(int i = 0; i < 4; i++){
            list2.get(i).next = list2.get(i+1);
        }

        Node res = merge(list1.get(0), list2.get(0));
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
