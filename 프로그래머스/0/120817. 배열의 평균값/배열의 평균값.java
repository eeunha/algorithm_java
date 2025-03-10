/*
I: int[] numbers
O: double
C: 0 ≤ numbers의 원소 ≤ 1,000
    1 ≤ numbers의 길이 ≤ 100
    정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.
E: 

pseudo code:
numbers를 순회한다
각 값을 모두 더한다
numbers 길이만큼 나눈다.
반환한다.

time: O(N)
space: O(1)

solution:
*/
class Solution {
    public double solution(int[] numbers) {
        
        double answer = 0;
        
        for (int number : numbers){
            answer += number;
        }
        
        return answer/numbers.length;
    }
}