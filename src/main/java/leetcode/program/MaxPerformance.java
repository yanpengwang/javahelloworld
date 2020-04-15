package leetcode.program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPerformance{
    public int calculateMaxPerformance(int n, int[] speed, int[] efficiency, int k){
        int[][] items = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0, sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(queue.size() > k - 1){
                sum -= queue.poll();
            }
            res = Math.max(res, (sum + items[i][0])* items[i][1]);
            queue.add(items[i][0]);
            sum += items[i][0];
        }
        return (int)(res % ((int)1e9 + 7));

    }
    public static void main(String[] args) {
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        System.out.println(new MaxPerformance().calculateMaxPerformance(6, speed, efficiency, 2));
    }
}