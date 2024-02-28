import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int startIdx = -1;
        int endIdx = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                startIdx = i;
                break;
            }    
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                endIdx = i;
                break;
            }    
        }
        
        if (startIdx == -1) {
            return new int[] {-1};
        } else if (startIdx == endIdx) {
            return new int[] {arr[startIdx]};
        }
        
        return Arrays.copyOfRange(arr, startIdx, endIdx + 1);
    }
}
