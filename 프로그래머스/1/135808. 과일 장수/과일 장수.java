/*
과일장수가 사과상자를 포장
사과는 1~k점으로 분류
k점이 최상품 1점이 최하품

사과 한 상자 가격
- 한 상자에 사과 m개씩
- 상자에 담긴 사과 중 가장 낮은 점수가 p > 사과 한 상자의 가격은 p*m

과일장수가 가능한 많은 사과 팔았을 때 얻을 수 있는 최대 이익 계산

k=3 (점), m=4(한 상자당 사과 수)
7개 [1, 2, 3, 1, 2, 3, 1]

전체 사과 수 / m = 팔 수 있는 사과 상자 수
7 / 4 = 1
1상자에 4개 > 4개 중 최대 가격 받게 하려면?
p * m = 사과 최저점 * 4
> 사과 최저점을 가능한 높게 잡기

사과상자에 점수가 가장 높은 사과부터 넣기 > 정렬 필요
최저점이 뭔지 알기
계산

[3, 3, 2, 2, 1, 1, 1]
> [3, 3, 2, 2]
최저점: 2
가격: 2 * 4 * 1(상자) = 8

I: int k, int m, int[] score
O: int
C: 3 <= k <= 9 (사과 최고점)
    3 <= m <= 10  (한 상자당 사과 수)
    7 <= score.length <= 1000000  -> O(N^2) 불가
    1 <= score[i] <= k
    이익이 발생하지 않는 경우 0 리턴
E:

이익이 발생하지 않는 경우가 뭐지?
사과가 0점 > 근데 사과는 최소 1점인데? 
사과가 0개 > 근데 사과는 최소 7개 있는데?
사과 최대점수가 0점 > 근데 사과 최대점수는 최소 3점 이상인데?

최대 4점, 한 상자에 3개, [4, 4, 4, 4, 4, 4, 2, 2, 2, 2, 1, 1]

12개 / 3 = 4
[4, 4, 4] [4, 4, 4] [2, 2, 2] [2, 1, 1]
4 * 3 + 4 * 3 + 2 * 3 + 1 * 3 = 12 + 12 + 6 + 3 = 33

ds: array
algo: sort

solution:
전체 가격 변수 = 0
현재 사과 인덱스 변수 = score.length - m
구해야 할 박스 개수 계산

score 정렬

for (i = 0; i < 구해야 할 박스 개수; i++) {
    //현재 상자 사과 최저점 > 근데 결국 맨 마지막 사과만 알면 되잖아?
    전체 사과 가격 += score[현재 인덱스] * m
    현재 인덱스 -= m
}

전체 가격 반환

time: O(NlogN) N = score.length
space: O(1)
*/
import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int boxCount = score.length / m;
        int idx = score.length - m;
        
        Arrays.sort(score);
        
        for (int i = 0; i < boxCount; i++) {
            answer += score[idx] * m;
            idx -= m;
        }
        
        return answer;
    }
}