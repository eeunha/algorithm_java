import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int i = 2;
        
        while (n > 1) {
            // i가 소수인가?
            if (isPrimeNumber(i)) {
                // 소수인 경우
                // 해당 소수로 나누어 떨어지는가?
                if (n % i == 0) {
                    // 나누어 떨어지면 list에 추가하고 다시 나누기
                    if (list.size() == 0 || list.get(list.size() - 1) != i) {
                        list.add(i);
                    } 
                    n /= i;
                } else {
                    // 나누어 떨어지지 않으면 i 증가
                    i++;
                }
            } else {
                // 소수가 아니면 i 증가
                i++;
            }
        }
        
        return list.stream().mapToInt(j -> j).toArray();
    }
    
    public boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}