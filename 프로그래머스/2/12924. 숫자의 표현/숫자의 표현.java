class Solution {
    public int solution(int n) {
        
        int answer = 1;
        
        for (int i = 1; i <= n / 2; i++) {
            int curSum = i;
            
            for (int j = i + 1; j <= n; j++) {
                if (curSum < n) {
                    curSum += j;
                } else {
                    if (curSum == n) {
                        answer++;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}