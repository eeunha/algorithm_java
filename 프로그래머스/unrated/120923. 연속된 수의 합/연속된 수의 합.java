import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = 0;
        
        for (int i = 1; num > 1 && i < num; i++) {
            n += i;
        }
        
        int startN = (int) ((total - n) / num);
        
        for (int i = 0; i < num; i++) {
            list.add(startN + i);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}