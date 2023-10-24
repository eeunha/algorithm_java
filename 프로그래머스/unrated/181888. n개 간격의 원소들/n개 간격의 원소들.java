import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        if (n == 1) return num_list;
        
        int length = (num_list.length % n == 0) ? num_list.length / n : num_list.length / n + 1;
        int[] answer = new int[length];
        
        for (int i = 0, idx = 0; i < num_list.length; i += n, idx++) {
            answer[idx] = num_list[i];
        }
        
        return answer;
    }
}