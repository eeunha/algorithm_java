import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] arr = new int[num];
        
        int n = (num - 1) * num / 2;
        
        int startN = (int) ((total - n) / num);
        
        for (int i = 0; i < num; i++) {
            arr[i] = startN + i;
        }
        
        return arr;
    }
}
