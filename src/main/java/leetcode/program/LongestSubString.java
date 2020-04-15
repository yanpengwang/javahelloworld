package leetcode.program;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int i = 0 , j = 0, max = 0;
        Set<Character> resultSet = new HashSet<>();
        while(j < s.length()) {
            if(resultSet.contains(s.charAt(j))) {
                resultSet.remove(s.charAt(i++));
            } else {
                resultSet.add(s.charAt(j++));
                max = Math.max(max, resultSet.size());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer i = new LongestSubString().lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}


