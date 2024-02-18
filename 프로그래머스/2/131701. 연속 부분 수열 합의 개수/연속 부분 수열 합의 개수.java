import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int length = elements.length;

        for (int i = 1; i <= length; i++) { // 자리수
            for (int j = 0; j < length; j++) { // 시작 인덱스
                int sum = 0;
                for (int count = 0; count < i; count++) {
                    sum += elements[(j + count) % length];    
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}