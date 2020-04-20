package leetcode.program;

class Solution{
    public boolean canJump(int[] nums){
        int farEnd = 0;
        int i = 0;
        while(i <= farEnd && farEnd < nums.length){
            farEnd = Math.max(farEnd, i + nums[i]);
            i++;
        }
        return farEnd >= nums.length;
    }
}
public class CanJump {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] input = {3,2,1,0,4};
        System.out.println(s1.canJump(input));

    }
}
