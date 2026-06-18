/*
초단위 기록된 주식가격
가격이 떨어지지 않은 기간은 몇 초인가

I: int[] prices
O: int
C: 1 <= prices[i] <= 10000 자연수
    2 <= prices.length <= 100000
E:

[1, 2, 3, 2, 3]
1 > 4초 지속
2 > 3 2 3 > 3초 지속 (처음 값과 같아도 됨)
3 > 2(-1) (근데 1초 지속된걸로 봄) > 1초 지속 (다음 초까지는 유지니까) (값이 줄었는데 그 값이 맨 마지막 값이 아니라면 1초 유지된 것)
2 > 3 > 1초 지속
3 > 뒤가 없으니 0초 지속

O(N^2) 이 편하긴 하겠으나 시간초과 (최대 10만)
정렬은 하면 안됨. 순서 중요

일단은 O(N^2)로 해보기

ds:
algo:

time: O(N^2)
space: O(N)
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            int startPrice = prices[i];
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                time++;
                if (startPrice > prices[j]) {
                    break;
                } 
            }
            answer[i] = time;
        }
        
        return answer;
    }
}