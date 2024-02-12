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

time: O(8 * N^2) N 은 발생할 수 있는 숫자의 개수
space: O(8 * N)
*/
import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        Map<Integer, Set<Integer>> dp = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(N);
        dp.put(1, set);

        for (int i = 2; i <= 8; i++) {
            set = new HashSet<>();
            StringBuilder sb = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            set.add(Integer.parseInt(sb.toString())); // 기본 숫자 넣기
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) { // 두 수의 사칙연산으로 발생하는 수 넣기
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if (num2 != 0) {
                            set.add(num1 / num2);
                        }
                    }
                }
            }
            if (set.contains(number)) {
                return i;
            }
            dp.put(i, set);
        }

        return -1;
    }
}