/*
I: int[] numbers, int target
O: int 방법의 수
C: 주어지는 숫자의 개수는 2개 이상 20개 이하
    각 숫자는 1 이상 50 이하인 자연수
    타겟 넘버는 1 이상 1000 이하인 자연수
E:  

n개의 음이 아닌 정수들
이 정수들을 순서 안바꾸고 더하거나 빼서 타겟넘버 만들기

ds:
algo:

time:
space:
*/
class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }
    
    public void dfs(int[] numbers, int target, int idx, int curSum) {
        if (idx == numbers.length) {
            if (curSum == target) {
                answer++;
            }
            return;
        }
        
        // 빼고 dfs
        dfs(numbers, target, idx + 1, curSum + -1 * numbers[idx]);
        
        // 더하고 dfs
        dfs(numbers, target, idx + 1, curSum + numbers[idx]);
    }
}