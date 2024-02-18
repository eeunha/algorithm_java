import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int length = elements.length;
        int[] sumArr = new int[length];
        int count = 0;
        
        for (int i = 1; i <= length; i++) { // 자리수
            for (int j = 0; j < length; j++) { // 시작 인덱스
                
                int sum = elements[(j + count) % length];
                sumArr[j] += sum;
                set.add(sumArr[j]);
            }
            
            count++;
        }
        
        return set.size();
    }
}
