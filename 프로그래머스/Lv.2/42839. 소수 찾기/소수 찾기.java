/*
I: String
O: int
C: numbers는 길이 1 이상 7 이하인 문자열
    numbers는 0~9까지 숫자만
    "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미
E: 

1. 숫자 만들기 -> StringBuilder 사용 -> 숫자로 변환 -> 중복 제거(Set 사용)
2. 해당 숫자가 소수인지 판별하기 -> boolean isPrimeNumber(int n)
3. 소수의 개수 세기 -> static int count++

-> 재귀

1.1. 자리수 지정


17 -> 1, 7, 17, 71 => 7, 17, 71
011 -> 0, 1, 1, 01, 01, 10, 11, 10, 11, 011, 101, 110 => 0, 1, 10, 11, 101, 110 => 11, 101

ds:
algo:

time:
space:
*/
import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] check = new boolean[7];
    
    public int solution(String numbers) {
        int count = 0;
        StringBuilder sb;
        
        // 숫자 만들기
        for (int i = 1; i <= numbers.length(); i++) {
            sb = new StringBuilder();
            dfs(numbers, sb, i);
        }
        
        // 소수 판별하기
        for (Integer curN : set) {
            int n = curN;
            if (isPrimeNumber(n)) count++;
        }
        
        return count;
    }
    
    public void dfs(String numbers, StringBuilder sb, int numLength) {
        if (sb.length() == numLength) {
            set.add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                sb.append(numbers.charAt(i));
                dfs(numbers, sb, numLength);
                check[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    // 소수 판별하기
    public boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}