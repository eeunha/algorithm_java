import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        int startIdx = 0;
        int endIdx = arr.length - 1;
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                endIdx = startIdx + query[i];
            } else {
                startIdx = startIdx + query[i];
            }
        }
        
        int[] answer = new int [endIdx - startIdx + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[i + startIdx];
        }
        
        return answer;
    }
}