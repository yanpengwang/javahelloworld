package leetcode.program;

import javafx.util.Pair;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][];
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(x->x[0]));
        for(int[] x : intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1] < x[0]){
                result.add(x);
            } else {
                result.get(result.size()-1)[1] = Math.max(x[1], result.get(result.size()-1)[1]);
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {

        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        Arrays.stream(merge(input)).flatMapToInt(x->Arrays.stream(x)).forEach(System.out::println);

    }
}
