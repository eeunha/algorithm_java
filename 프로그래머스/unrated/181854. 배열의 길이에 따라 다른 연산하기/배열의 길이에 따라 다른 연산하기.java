import java.util.*;
class Solution {
    public int[] solution(int[] arr, int n) {
        int length = arr.length;
        int[] answer = Arrays.copyOf(arr, length);
        
        int startIdx = (length % 2 == 0) ? 1 : 0;

        for (int i = startIdx; i < length; i += 2) {
            answer[i] += n;
        }
        
        return answer;
    }
}