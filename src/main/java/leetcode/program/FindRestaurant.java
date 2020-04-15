package leetcode.program;

import java.util.*;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> resultList =new ArrayList<>();
        Integer minIndexSum = Integer.MAX_VALUE;
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            m.put(list1[i], i);
        }
        for(int j = 0; j < list2.length; j++){
            String curString = list2[j];
            if(m.containsKey(curString)){
                Integer curSize = j + m.get(curString);
                if(curSize.equals(minIndexSum)){
                    resultList.add(curString);
                } else if (curSize < minIndexSum){
                    minIndexSum = curSize;
                    resultList.clear();
                    resultList.add(curString);
                }
            }
        }

        return resultList.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String[] list1 = {"ok", "good"};
        String[] list2 = {"ok", "good"};
        String[] ans = new FindRestaurant().findRestaurant(list1, list2);
        Arrays.stream(ans).forEach(System.out::println);
    }
}


