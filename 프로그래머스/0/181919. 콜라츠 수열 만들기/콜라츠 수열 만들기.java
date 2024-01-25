/*
I: int n
O: int[]
C: 1 ≤ n ≤ 1,000
E:

모든 자연수 x에 대해서 현재 값이 짝수면 2로 나누기
홀수면 3 * x + 1로 바꾸기
무한반복 후 x가 1이 되는가?
-> 콜라츠 문제, 콜라츠 수열

콜라츠 수열 리턴

*/
import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            list.add(n);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}