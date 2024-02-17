/*
8명, 4번 vs 7번
1번째 - 3/4 7/8 -> 4/2 7/2 => 2 4
2번째 - 1/2 3/4 -> 2/2 4/2 => 1 2
3번째 - 1/2
*/
import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        int answer = 1;

        while (min > 0 && max > 0) {
            //바로 붙는 경우
            if (min % 2 == 1 && max == min + 1) {
                return answer;    
            }
            
            //다른 숫자와 붙는 경우
            min = min / 2 + min % 2;
            max = max / 2 + max % 2;
                
            answer++;
        }
        
        return answer;
    }
}