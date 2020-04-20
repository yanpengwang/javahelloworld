package leetcode.program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution1{
    public int longestConsecutive(int[] nums){
        Set<Integer> mySet = new HashSet<>();
        for(int x : nums) {
            mySet.add(x);
        }
        int ans = 0;
        for(int x : nums){
            int count = 0, c;
            if(mySet.contains(x)) {
                count = 1;
                mySet.remove(x);
                c = x;
                while (mySet.contains(--c)) {
                    count++;
                    mySet.remove(c);
                }
                c = x;
                while (mySet.contains(++c)) {
                    count++;
                    mySet.remove(c);
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public int longestConsecutive2(int[] nums){
        if(nums.length ==0) return 0;
        for(int x : nums){
            uf.put(x, x);
            count.put(x, 1);
        }
        int ans = 1;
        for(int x : nums){
            if(uf.containsKey(x+1)){
                ans = Math.max(ans, merge(x, x+1));
            }
        }
        return ans;
    }

    public int merge(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return count.get(x);
        uf.put(y, x);
        count.put(x, count.get(x) + count.get(y));
        return count.get(x);
    }

    public int find(int i){
        int j = uf.get(i);
        return j == i ? j : find(j);
    }
    private Map<Integer,Integer> uf = new HashMap<>();
    private Map<Integer,Integer> count = new HashMap<>();

}
public class LongestConsutive {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] input = {100,4,30,1,2,3};
        System.out.println(s1.longestConsecutive2(input));
    }
}
