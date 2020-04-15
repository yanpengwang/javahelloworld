package leetcode.program;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class MaxSlidingWindow {

    public int[] getMaxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k){
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> sortedList = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){

            while (sortedList.size() > 0 && nums[i] >= nums[sortedList.peekLast()]){
                sortedList.pollLast();
            }
            sortedList.addLast(i);
            if(i >= k && sortedList.peekFirst().equals(i-k)){
                sortedList.pollFirst();
            }
            if(i >= k - 1){
                ans[i-k+1] = nums[sortedList.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow s1 = new MaxSlidingWindow();
        int[] nums = new int[]{-7,-8,7,5,7,1,6,0};
        Arrays.stream(s1.getMaxSlidingWindow(nums, 4)).forEach(System.out::println);
    }
}


