import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
            
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        
        if (map.size() == 1) { // 다 같음
            answer = 1111 * a;
        } else if (map.size() == 2) {
            if (map.get(a) == 2) { // 둘 둘
                int[] arr = new int[2];
                int idx = 0;
                
                for (int key : map.keySet()) {
                    arr[idx++] = key;
                }
                
                answer = (arr[0] + arr[1]) * Math.abs(arr[0] - arr[1]);
            } else { // 셋 하나
                int p = -1;
                int q = -1;
                
                for (int key : map.keySet()) { 
                    if (map.get(key) > 1) {
                        p = key;
                    } else {
                        q = key;
                    }
                }

                answer = (int) Math.pow(10 * p + q, 2);
            }
        } else if (map.size() == 3) { // 둘 하나 하나
            int[] arr = new int[2];
            int idx = 0;
            
            for (int key : map.keySet()) {
                if (map.get(key) == 1) {
                   arr[idx++] = key;
                }
            }
            
            answer = arr[0] * arr[1];
        } else { // 다 다름
            int min1 = Math.min(a, b);
            int min2 = Math.min(c, d);
            
            answer = Math.min(min1, min2);
        }
        
        return answer;
    }
}