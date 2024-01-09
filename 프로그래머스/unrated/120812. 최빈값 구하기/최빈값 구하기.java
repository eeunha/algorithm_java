import java.util.*;

class Solution {
    public int solution(int[] array) {
        //edge cases
        if (array.length == 1) return array[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int mode = 0;
        int modeCount = 0;
        
        for (int key : map.keySet()) {
            if (modeCount < map.get(key)) {
                mode = key;
                modeCount = map.get(key);
            }
        }
        
        for (int key : map.keySet()) {
            if (modeCount == map.get(key) && key != mode) {
                return -1;
            }
        } 
        
        return mode;
    }
}
