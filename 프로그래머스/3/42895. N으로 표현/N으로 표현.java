/*
I: int n, int number
O: int 
C: N은 1 이상 9 이하
   number는 1 이상 32,000 이하
   수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시
   최솟값이 8보다 크면 -1을 return
E: N == number -> return 1

ds: map, set
algo: dp

time: O(N^2)
space: O(N * 8)
*/
import java.util.*;
class Solution {
    public int solution(int N, int number) {
        //edge case
        if (N == number) return 1;
        
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = new HashSet<>();
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            set.add(num);
            dp.put(i, set);
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}