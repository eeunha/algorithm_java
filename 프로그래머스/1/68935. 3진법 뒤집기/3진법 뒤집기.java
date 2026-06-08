/*
26.06.08

I: int n
O: int
C: 1 <= n <= 100,000,000 자연수
E:

n을 3진법으로 바꾸기
앞뒤로 뒤집기
다시 10진법으로 바꾸기
반환하기

time: O(log3 N) - N을 3으로 나누기
space: O(log3 N) - toString, parseInt 에서 문자열 길이
*/
class Solution {
    public int solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        return Integer.parseInt(sb.toString(), 3);
    }
}