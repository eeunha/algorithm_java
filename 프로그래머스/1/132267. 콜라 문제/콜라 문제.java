/*
26.06.09

콜라 빈병 2개 > 콜라 1병 줌
빈병 20개 > 콜라 10병 > 5병 > 2병(+1) > 1(+1) > 1
10 + 5 + 2 + 1 + 1 = 19

I: int a, int b, int n
O: int
C: 보유 빈 병 < a  콜라 못받음
   1 <= b < a <= n <= 1,000,000
   int 범위 내 존재
E:

3개 주면 1개 받음
현재 가진 빈병 수: 20 - (3*6) + 6 = 8
20 / 3 = 6 ... 2
받은 콜라 수 = 6 + 2 + 1

8 / 3 = 2 ... 2
8 - (3*2) + 2 = 4

4 / 3 = 1 ... 1
4 - (3*1) + 1 = 2

2 < 3  >> 끝

현재 병 수 = n - (a*몫) + 몫 * b
받은 콜라 수 += 몫 * b

time: O(N)
space: O(1)
*/
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int quotient = n / a;
            answer += quotient * b;
            n -= quotient * a - quotient * b; 
        }
        
        return answer;
    }
}