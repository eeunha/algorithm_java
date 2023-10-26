import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            int cur = (int) my_string.charAt(i) - 48;
            if (cur >= 0 && cur <= 9)
                list.add(cur);
        }
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}