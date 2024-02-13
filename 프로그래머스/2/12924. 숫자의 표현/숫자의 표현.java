class Solution {
    public int solution(int n) {
        
        int answer = 1;
        
        for (int i = 1; i <= n / 2; i++) {
            int curSum = i;
            
            for (int j = i + 1; j <= n; j++) {
                 if (curSum >= n) {
                    if (curSum == n) {
                        answer++;
                    }
                    break;
                     
                } else {
                    curSum += j;
                }
            }
        }
        
        return answer;
    }
}