import java.util.*;

/*
I: int N, A, B
O: int answer
C: A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정
    N : 21 이상 220 이하인 자연수 (2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
    A, B : N 이하인 자연수 (단, A ≠ B 입니다.)
E: 

게임대회 N명 참가
토너먼트 형식으로 진행
1~N 번호 배정
바로 옆번호 사람과 대결
이기면 다음 라운드 진출
    다시 1 ~ n/2 번 배정
최종 한 명 남을 때까지 진행

n=8, a=4, b=7
1 2 3 4 5 6 7 8
      ^     ^
 1 4 5 7
(1 2 3 4)

4 > 2 > 1 > 1
7 > 4 > 2 > 1

time: O(logN)
space: O(1)
*/
class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        for (; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}