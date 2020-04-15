package com.wyp.basics;



import com.sun.deploy.util.StringUtils;

import java.util.*;

public class AliString {


    public static String removeDuplicateLetters(String inputString){
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastSeen = new HashMap<>();
        for(int i = 0; i < inputString.length(); i++){
            lastSeen.put(inputString.charAt(i), i);
        }
        for(int i = 0; i < inputString.length(); i++){
            Character c = inputString.charAt(i);
            if(!seen.contains(c)){
                while(!stack.empty() && c < stack.peek() && lastSeen.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while(!stack.empty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println(removeDuplicateLetters("bcabc"));

    }
}
