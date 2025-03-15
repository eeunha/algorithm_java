/*
I: int[] prices
O: int[]
C: prices의 각 가격은 1 이상 10,000 이하인 자연수
    prices의 길이는 2 이상 100,000 이하
E:
 가격이 떨어지지 않은 기간은 몇초인지

ds:
algo:

pseudo:

time:
space:

solution:
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }    
        }
        
        return answer;
    }
}