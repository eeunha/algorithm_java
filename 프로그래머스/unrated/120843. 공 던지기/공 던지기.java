class Solution {
    public int solution(int[] numbers, int k) {
        //edge cases
        if (k == 1) return 1;
        
        int answer = -1;
        
        for (int i = 1; i <= k; i++) {
            answer += 2;
            if (numbers.length < answer) {
                answer -= numbers.length;
            }
        }
        
        return answer;
    }
}