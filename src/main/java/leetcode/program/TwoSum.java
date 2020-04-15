package leetcode.program;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<>(16);
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if (tracker.containsKey(nums[i])) {
                return new int[]{tracker.get(nums[i]), i};
            } else {
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ans = new TwoSum().twoSum(nums, 9);
        for (int i : ans){
            System.out.println(i);
        }
    }
}


