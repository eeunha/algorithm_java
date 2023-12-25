import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] orderedArr = emergency.clone();
        
        Arrays.sort(orderedArr);

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = orderedArr.length - 1; i >= 0; i--) {
            map.put(orderedArr[i], orderedArr.length - i);
        }

        for (int i = 0; i < emergency.length; i++) {
            answer[i] = map.get(emergency[i]);
        }
        
        return answer;
    }
}